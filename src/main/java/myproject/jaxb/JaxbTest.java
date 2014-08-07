package myproject.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JaxbTest {


	public static void main(String[] args) throws Exception {
		
		File document = new File("C:\\dev\\dev_project\\git\\myproject\\src\\main\\java\\myproject\\jaxb\\output.xml");

		getMarkLogicSearchFacetList(loadXMLFromFile(document));
		
	}
	
	public static Document loadXMLFromFile(File file) throws Exception
	{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	    factory.setNamespaceAware(true);
	    DocumentBuilder builder = factory.newDocumentBuilder();

	    return builder.parse(new FileInputStream(file));
	}
	
    public static List<MarkLogicFacet> getMarkLogicSearchFacetList(Document doc)
            throws Exception {

        System.out.println("inside getMarkLogicSearchFacetList");// + getStringFromDocument(doc));
        
        List<MarkLogicFacet> facetList = new LinkedList<MarkLogicFacet>();

        JAXBContext jaxbContext = JAXBContext.newInstance(MarkLogicFacet.class);
        Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
        
        NodeList fList = doc.getElementsByTagName("search:facet");
        System.out.println("fList=>" + fList.getLength());

        for (int i = 0; i < fList.getLength(); i++) {
        	System.out.println("b4 marshalling");
            Node fNode = fList.item(i);

            MarkLogicFacet facet = (MarkLogicFacet) unMarshaller
                    .unmarshal(fNode);
            facetList.add(facet);
        }
        System.out.println("facetList: " + facetList);
        System.out.println("facetList=>" + facetList.size());
        
        return facetList;
    }

}
