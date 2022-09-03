package DemandeFormation;

import Formation.Formation;
import Formation.Session;

public class Choix {
	private Enseignant enseignant;
	private Formation formation;
	private Session session;
	private int etatC;
	public Choix(){}
	public Choix(Enseignant e,Formation f, Session s, int etat)
	{
		this.enseignant=e; this.formation=f; this.session=s; this.etatC=etat;
	}
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
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public int getEtatC() {
		return etatC;
	}
	public void setEtatC(int etatC) {
		this.etatC = etatC;
	}
	

}
