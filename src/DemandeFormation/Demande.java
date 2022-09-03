package DemandeFormation;

import java.util.Date;

import Formation.Formation;

public class Demande {
	private int etat;
	private String dateDemande;
	private Formation formation;
	private Enseignant enseignant;
	public Demande(){ this(null,null,null,0);}
	public Demande(String d, Formation f,Enseignant e,int etat)
	{this.setDateDemande(d); this.formation=f;this.enseignant=e; this.etat=etat;}
	
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getDateDemande() {
		return dateDemande;
	}
	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}

}
