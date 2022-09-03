package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Crud_Service.CrudSession;
import Formation.Session;

public class SessionCrud implements CrudSession{

	public void addSession(Session s) throws ClassNotFoundException, SQLException {
	String sql="insert into Session (idForm,dateDebut,dateFin,lieu) values("+s.getIdFormation()+", '"+s.getDateDebut()+"', '"+s.getDateFin()+"', '"+s.getLieu()+"')";
		sqlConnection.executeSQLQuery(sql);
	}
	public void deleteSession(Session s) throws ClassNotFoundException, SQLException {
	String sql="delete from Session where idS="+s.getId();
		sqlConnection.executeSQLQuery(sql);
	}

	public void updateSession(Session s) throws ClassNotFoundException, SQLException {
	String sql="update Session set dateDebut='"+s.getDateDebut()+"', dateFin='"+s.getDateFin()+"' ,lieu='"+s.getLieu()+"' where idS="+s.getId();
		sqlConnection.executeSQLQuery(sql);
	}
	public Session getSession(int id) throws ClassNotFoundException,SQLException {
		Session s=null;
		String sql="select * from Session where idS="+id;
		Connection c=sqlConnection.conector();
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			s=new Session(rs.getInt("idS"),rs.getInt("idForm"),rs.getString("lieu"),rs.getString("dateDebut"),rs.getString("dateFin"));
		}
		c.close();
		return s;
	}
	

}
