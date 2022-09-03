package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Crud_Service.ServiceSession;
import Formation.Session;

public class SessionService implements ServiceSession {
	
	public Vector getAllSession() throws SQLException {
		Vector v = new Vector();
		Connection c =sqlConnection.conector();
		String sql="select * from Session";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next())
		{
			v.addElement(new Session(rs.getInt("idS"),rs.getInt("idForm"),rs.getString("lieu"),rs.getString("dateDebut"),rs.getString("dateFin")));
		}
		c.close();
		return v;
	}
	public Vector getSessionByIdFormation(int id) throws SQLException {
		Vector v = new Vector();
		Connection c =sqlConnection.conector();
		String sql="select * from Session where idForm="+id;
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next())
		{
			v.addElement(new Session(rs.getInt("idS"),rs.getInt("idForm"),rs.getString("lieu"),rs.getString("dateDebut"),rs.getString("dateFin")));
		}
		c.close();
		return v;
	}

}
