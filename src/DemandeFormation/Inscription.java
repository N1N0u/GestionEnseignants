package DemandeFormation;

import java.util.Date;

import Comptabilité.Facture;
import Formation.Session;

public class Inscription {
	private int numeroInscription;
	private String dateInscription; 
	//private double montant;
	private Enseignant enseignant;
	private Session session;
	public Inscription(){}
	public Inscription(int n,Enseignant enseignant, Session session, String dateIns)
	{
		this.enseignant=enseignant; this.session=session; this.setDateInscription(dateIns);
	 this.setNumeroInscription(n);
	}
	
	
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public int getNumeroInscription() {
		return numeroInscription;
	}
	public void setNumeroInscription(int numeroInscription) {
		this.numeroInscription = numeroInscription;
	}
	public String getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
	

}
