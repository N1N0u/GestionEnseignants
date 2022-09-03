package Formation;

public class Contenu {
	private String plan, objectif;
	private int nombrePlace,idFormation;
	public Contenu(){}
	public Contenu(String plan, String objectif, int nombrePlace,int idFormation)
	{
		this.plan=plan; this.objectif=objectif;
		this.nombrePlace=nombrePlace; this.idFormation=idFormation;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	

}
