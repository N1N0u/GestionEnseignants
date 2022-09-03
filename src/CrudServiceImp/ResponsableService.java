package CrudServiceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Crud_Service.ServiceResponsable;
import DemandeFormation.Responsable;
import InterfacesGraphic.ResponsableAcceuil;

public class ResponsableService implements ServiceResponsable{

	public Responsable getUser(String user, String password) throws SQLException {
		String sql="select * from Responsable where email='"+user+"' and password='"+password+"'";
		Responsable r=null;
		Connection c=sqlConnection.conector();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
		 r=new Responsable(rs.getString("nom"),rs.getString("prenom"),rs.getString("adress"),rs.getString("email"),rs.getString("password"));
		}
		c.close();
		return r;
	}

}
