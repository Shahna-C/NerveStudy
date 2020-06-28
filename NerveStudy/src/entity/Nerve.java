package entity;



public class Nerve {
	
	private int nerveId;
	private String muscle;
	private String type;
	
	
	public Nerve(String muscle, String type, int nerveId ) {
				
			this.setMuscle(muscle);	
			this.setType(type);
			this.setNerveId(nerveId);
	}

	public int getNerveId() {
		return nerveId;
	}

	public void setNerveId(int nerveId) {
		this.nerveId = nerveId;
	}

	public String getMuscle() {
		return muscle;
	}

	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
