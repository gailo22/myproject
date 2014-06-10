package myproject.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pair implements Serializable {
	
	private static final long serialVersionUID = -7139750406243363548L;
	
	private int number;
	private String name;
	
	public Pair(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) throws Exception {
		
		writeData();
		
		readData();

	}

	private static void writeData() throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("/tmp/file");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeInt(10);
		oos.writeBoolean(false);
		oos.writeUTF("Hello");
		
		Pair pair = new Pair(42, "Fouty two");
		oos.writeObject(pair);
		
		oos.flush();
		oos.close();
		fos.close();
	}
	
	private static void readData() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("/tmp/file");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		int number = ois.readInt();
		boolean bool = ois.readBoolean();
		String string = ois.readUTF();
		
		Pair pair = (Pair) ois.readObject();
		
		System.out.println("number: " + number);
		System.out.println("bool: " + bool);
		System.out.println("string: " + string);
		System.out.println("pair.number: " + pair.number);
		System.out.println("pair.name: " + pair.name);
		
	}


}
