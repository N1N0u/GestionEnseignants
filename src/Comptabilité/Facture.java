package Comptabilité;
import java.util.Date;
import DemandeFormation.Enseignant;
import Formation.Session;
public class Facture {
	private int numeroFacture;
	private Date dateFacture;
	private double montant;
	private Enseignant enseignant;
	private Session session;
	public Facture(){}
	public Facture(int numFac,Enseignant enseignant, Session session, Date dateF, double montant)
	{
		this.enseignant=enseignant; this.session=session; this.dateFacture=dateF; 
		this.montant=montant; this.numeroFacture=numFac;
	}
	public Date getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
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
	public int getNumeroFacture() {
		return numeroFacture;
	}
	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}

}
