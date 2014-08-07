package myproject.jaxb;
//package com.ncs.sal.lawnet.portlet.reference.search.output.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;



@XmlRootElement(name = "facet-value")
public class MarkLogicFacetElement {
	private String name;
	private int count;
	private String value;
	
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCount() {
		return count;
	}
	@XmlAttribute
	public void setCount(int count) {
		this.count = count;
	}
	public String getValue() {
		return value;
	}
	@XmlValue
	public void setValue(String value) {
		this.value = value;
	}

}
