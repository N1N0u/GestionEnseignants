package Formation;

import java.util.Date;

public class Session {
	private int idFormation,idS;
	private String lieu;
	private String dateDebut, dateFin;
	public Session(){}
	public Session(int id,int idFormation,String lieu, String dateDebut, String dateFin)
	{
	this.idS=id;	this.idFormation=idFormation; this.lieu=lieu;
	this.dateDebut=dateDebut; this.setDateFin(dateFin);
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	

	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public int getId() {
		return idS;
	}
	public void setId(int id) {
		this.idS = id;
	}
	
	
	
}
