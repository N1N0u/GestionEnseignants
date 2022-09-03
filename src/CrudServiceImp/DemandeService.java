package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Crud_Service.ServiceDemande;
import DemandeFormation.Demande;
import DemandeFormation.Enseignant;
import Formation.Catalogue;
import Formation.Contenu;
import Formation.Formation;
import Formation.Session;

public class DemandeService implements ServiceDemande{
	
	
	public Vector getDemandebyEmail(String email) throws ClassNotFoundException, SQLException {
	Vector v=new Vector();
	String sql="select  * from Demande,Enseignant,Formation where Demande.emailEnseignant='"+email+"' and Formation.id=Demande.idFormation";
	v=requette(sql);
	return v;
	}


	public Vector getAllDemande() throws ClassNotFoundException, SQLException{
		Vector v=new Vector();
		String sql="select * from Demande,Enseignant,Formation where  Demande.emailEnseignant=Enseignant.email and Formation.id=Demande.idFormation ";
		v=requette(sql);
		return v;
	}
	
	public Vector requette(String sql) throws SQLException
	{
		Connection c=sqlConnection.conector();
		Vector v=new Vector();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{		
	v.addElement(new Demande(rs.getString("dateDemande"),new Formation(rs.getInt("id"),rs.getString("titre"),rs.getString("duree"),rs.getDouble("prix")),new Enseignant(rs.getString("nom"),rs.getString("prenom"),rs.getString("adress"),rs.getString("email"),rs.getString("password")),rs.getInt("etat")));
			}
		c.close();
		return v;
	}

	public Vector getDemandeRefuser(String email) throws ClassNotFoundException, SQLException {
		Vector v=new Vector();
		String sql="select  * from Demande,Formation,Enseignant where Demande.emailEnseignant='"+email+"' and Enseignant.email='"+email+"'  and  (Demande.etat=0 or Demande.etat=1) and Formation.id=Demande.idFormation";
		v=requette(sql);
		return v;
		
	}
	public Vector getDemandeAccepter(String email)throws ClassNotFoundException, SQLException {
		Vector v=new Vector();
		String sql="select  * from Demande,Formation,Enseignant where Demande.emailEnseignant='"+email+"' and Enseignant.email='"+email+"' and (Demande.etat=2 or Demande.etat=3) and Formation.id=Demande.idFormation";
		v=requette(sql);
		return v;
	}


	
	
}
