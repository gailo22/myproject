package myproject.gson;

import java.util.List;

public class ResumeInfo {

	private String name;
	
	private List<Summary> summarys;
	private List<Occupation> occupations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Summary> getSummarys() {
		return summarys;
	}

	public void setSummarys(List<Summary> summarys) {
		this.summarys = summarys;
	}

	public List<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}
	
}
