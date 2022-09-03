package DemandeFormation;
public class Agent {
	private String nom,prenom,adress,email,password;
	public Agent(){}
	public Agent(String n,String p,String a,String e,String pass)
	{
		this.nom=n; this.prenom=p; this.adress=a; this.email=e; this.password=pass;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
