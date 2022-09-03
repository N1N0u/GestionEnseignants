package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Crud_Service.CrudEnseignant;
import DemandeFormation.Enseignant;

public class EnseignantCrud implements CrudEnseignant{

	public void AddEnseignant(Enseignant enseignant) throws SQLException, ClassNotFoundException {
String sql="insert into Enseignant (nom,prenom,adress,email,password) values ('"+enseignant.getNom()+"','"+enseignant.getPrenom()+"','"+enseignant.getAdress()+"','"+enseignant.getEmail()+"','"+enseignant.getPassword()+"')";
sqlConnection.executeSQLQuery(sql);
	}
	
	public Enseignant getEnseignant(String email)throws ClassNotFoundException, SQLException {
		String sql="select * from Enseignant where email='"+email+ "'";
		Connection con=sqlConnection.conector();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		Enseignant en=null;
		while(rs.next()){
		en=new Enseignant(rs.getString("nom"),rs.getString("prenom"),rs.getString("adress"),rs.getString("email"),rs.getString("password"));
		}
		con.close();
		return en;
	}

}
