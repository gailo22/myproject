package myproject.memcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.KeyIterator;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.MemcachedClientCallable;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class MemcachedMultiKeyTest {

	private static final String LOCALHOST_11211 = "localhost:11213";

	public static void main(String[] args) throws Exception {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(LOCALHOST_11211));
		MemcachedClient client = builder.build();

		client.set("helloworld", 0, "hello world");
		String value = client.get("CACHE_INFO_POSITION_LANGUAGE_POSITION_KEY_1");

		System.out.println("key: helloworld, value: " + value);

		// iterate all keys
		KeyIterator it = client.getKeyIterator(AddrUtil.getOneAddress(LOCALHOST_11211));
		while (it.hasNext()) {
			String key = it.next();
			System.out.println("key: " + key);
		}

		// namespace
		String ns = "namespace";
		client.withNamespace(ns, new MemcachedClientCallable<Void>() {

			public Void call(MemcachedClient c) throws MemcachedException, InterruptedException, TimeoutException {
				//a,b,c is under namespace
				c.set("a", 0, 1);
				c.set("b", 0, 1);
				c.set("c", 0, 1);
				return null;
			}
		});
		//get the value of a in namespace
		Integer aValue = client.withNamespace(ns, new MemcachedClientCallable<Integer>() {

			public Integer call(MemcachedClient c) throws MemcachedException, InterruptedException,
					TimeoutException {
				return c.get("a");
			}
		});

		//invalidate namespace
		client.invalidateNamespace(ns);

		shoutdown(client);

	}

	private static void shoutdown(MemcachedClient client) {
		try {
			//close memcached client
			client.shutdown();
		} catch (IOException e) {
			System.err.println("Shutdown MemcachedClient fail");
			e.printStackTrace();
		}
	}

}
