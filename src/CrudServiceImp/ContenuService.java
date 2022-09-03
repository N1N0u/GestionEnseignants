package CrudServiceImp;

import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Crud_Service.ServiceContenu;
import Formation.Contenu;
import java.sql.*;
public class ContenuService implements ServiceContenu {
 
	public Vector getAllContenu() throws SQLException {
	Vector v=new Vector();
	java.sql.Connection c=sqlConnection.conector();
	String sql="select * from Contenu";
	Statement st=c.createStatement();
	ResultSet rs=st.executeQuery(sql);
	while (rs.next())
	{
		v.addElement(new Contenu(rs.getString("plan"),rs.getString("objectif"),rs.getInt("nombrePlace"),rs.getInt("idFormation")));
	}
	c.close();
		return v;
	}

	public Vector getContenubyIdFormation(int id) throws SQLException {
		Vector v=new Vector();
		 java.sql.Connection c=sqlConnection.conector();
		String sql="select * from Contenu where idFormation="+id;
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next())
		{
			v.addElement(new Contenu(rs.getString("plan"),rs.getString("objectif"),rs.getInt("nombrePlace"),rs.getInt("idFormation")));
		}
		c.close();
		return v;
	}

}
