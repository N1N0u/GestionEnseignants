package Formation;

public class Catalogue {
	private int idFormation;
	private String description;
	public Catalogue(){}
	public Catalogue(int id,String description)
	{this.setIdFormation(id); this.description=description;}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	
	

}
