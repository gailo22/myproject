package myproject.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class SolrSearch {

	public static void main(String[] args) throws Exception {
		// solr run inside a docker container
		String urlString = "http://192.168.99.100:32777/solr/gettingstarted";
		SolrClient solr = new HttpSolrClient(urlString);
		
		
		SolrQuery query = new SolrQuery();
		//query.setQuery(mQueryString);
		
//		query.set("fl", "category,title,price");
//		query.setFields("category", "title", "price");
//		query.set("q", "category:books");
		
		query.set("q", "video");
		
		QueryResponse response = solr.query(query);
		
		SolrDocumentList list = response.getResults();
		
		System.out.println(list);
	}

}
