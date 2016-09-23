package myproject.gson;

import java.util.List;

public class Resume {
	private String name;
	
	private List<ResumeInfo> resumeInfos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResumeInfo> getResumeInfos() {
		return resumeInfos;
	}

	public void setResumeInfos(List<ResumeInfo> resumeInfos) {
		this.resumeInfos = resumeInfos;
	}

}
