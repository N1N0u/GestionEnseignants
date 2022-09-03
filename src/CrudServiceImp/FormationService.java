package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import Crud_Service.ServiceFormation;
import Formation.Catalogue;
import Formation.Formation;

public class FormationService implements ServiceFormation{
	
	
	public Vector getFomationbynumero(int numero) throws SQLException {
		Connection c=sqlConnection.conector();
		Vector v=new Vector();
		String sql="select * from Formation where id='"+numero+"'";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			v.addElement(new Formation(rs.getInt("id"),rs.getString("titre"),rs.getString("duree"),rs.getDouble("prix")));
			
		}
		c.close();
		return v;
	}

	public Vector getAllFormation() throws SQLException  {
		Connection c=sqlConnection.conector();
		Vector v=new Vector();
		String sql=" select * from Formation ";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
		v.addElement(new Formation(rs.getInt("id"),rs.getString("titre"),rs.getString("duree"),rs.getDouble("prix")));
		}
		c.close();
		return v;
	}
	public int getIdFormation(String titre) throws ClassNotFoundException,SQLException {
		int id = 0;
		String sql="select id from Formation where titre='"+titre+"'";
		Connection c=sqlConnection.conector();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next())
		{
			id=rs.getInt("id");
		}
		return id;
	}

	
	
}
