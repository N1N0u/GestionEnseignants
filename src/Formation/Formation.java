package Formation;

public class Formation {
	private int id;
	private String titre,duree;
	private double prix;
	public Formation(){}
	public Formation(int id,String titre,String duree, double prix)
	{
		this.id=id; this.titre=titre; this.duree=duree; this.prix=prix;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}


}
