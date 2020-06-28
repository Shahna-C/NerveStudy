package entity;

import java.util.List;

public class Study {
	
	
	private int studyId;
	private String name;
	private List<Nerve> nerves;
	
	// constructor 
	public Study(int studyId, String name, List<Nerve> nerves) {
		this.setStudyId(studyId);
		this.setName(name);
		this.setNerves(nerves);
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Nerve> getNerves() {
		return nerves;
	}

	public void setNerves(List<Nerve> nerves) {
		this.nerves = nerves;
	}

}
