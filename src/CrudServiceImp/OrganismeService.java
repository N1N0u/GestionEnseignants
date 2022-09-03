package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Crud_Service.ServiceOrganisme;
import Formation.Organisme;

public class OrganismeService implements ServiceOrganisme {

	public Organisme login(String user, String password) throws SQLException {
		String sql="select * from Organisme where email= '"+user+"' and password= '"+password+"'";
		Connection c=sqlConnection.conector();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		Organisme o=null;
		while (rs.next())
		{
			o=new Organisme(rs.getString("nom"),rs.getString("prenom"),rs.getString("adress"),rs.getString("email"),rs.getString("password"));
			System.out.println(rs.getString("email"));
		}
		c.close();
		return o;
	}

}
