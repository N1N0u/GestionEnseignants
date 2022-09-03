package CrudServiceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Crud_Service.ServiceEnseignant;
import DemandeFormation.Enseignant;

public class EnseignantService implements ServiceEnseignant {
	
	public Vector getAllEnseignant() throws SQLException {
		Connection c=sqlConnection.conector();
		Vector en=new Vector();
		String sql="select * from Enseignant";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
		en.addElement(new Enseignant(rs.getString("nom"),rs.getString("prenom"),rs.getString("adress"),rs.getString("email"),rs.getString("password")));
		}
		c.close();
		return en;
	}

	public Enseignant login(String email, String password) throws SQLException {
		Connection c=sqlConnection.conector();
		Enseignant e=null;
		String sql="select * from Enseignant where email='"+email+"' and password='"+password+"'";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
		e=new Enseignant(rs.getString("nom"),rs.getString("prenom"),rs.getString("adress"),rs.getString("email"),rs.getString("password"));
		}
		c.close();
		return e;
	}

}
