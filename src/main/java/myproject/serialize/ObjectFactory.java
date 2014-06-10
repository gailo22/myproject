//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.10 at 04:31:51 PM ICT 
//


package myproject.serialize;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the myproject.serialize package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmpResponse_QNAME = new QName("http://www.gailo22.com/Employee", "empResponse");
    private final static QName _EmpRequest_QNAME = new QName("http://www.gailo22.com/Employee", "empRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: myproject.serialize
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmpRequest }
     * 
     */
    public EmpRequest createEmpRequest() {
        return new EmpRequest();
    }

    /**
     * Create an instance of {@link EmpResponse }
     * 
     */
    public EmpResponse createEmpResponse() {
        return new EmpResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gailo22.com/Employee", name = "empResponse")
    public JAXBElement<EmpResponse> createEmpResponse(EmpResponse value) {
        return new JAXBElement<EmpResponse>(_EmpResponse_QNAME, EmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.gailo22.com/Employee", name = "empRequest")
    public JAXBElement<EmpRequest> createEmpRequest(EmpRequest value) {
        return new JAXBElement<EmpRequest>(_EmpRequest_QNAME, EmpRequest.class, null, value);
    }

}