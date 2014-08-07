@XmlSchema(

elementFormDefault = XmlNsForm.QUALIFIED, 
namespace = "http://marklogic.com/appservices/search", 
xmlns = { 
		@XmlNs(prefix = "search", 
		namespaceURI = "http://marklogic.com/appservices/search") })

package myproject.jaxb;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;


