package myproject.jaxb;
//package com.ncs.sal.lawnet.portlet.reference.search.output.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="facet")
public class MarkLogicFacet {
	private String name;	

	List<MarkLogicFacetElement> element;
	
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	public List<MarkLogicFacetElement> getElement() {
		return element;
	}
	
	@XmlElement(name="search:facet-value", type=MarkLogicFacetElement.class)
	public void setElement(List<MarkLogicFacetElement> element) {
		this.element = element;
	}

}
