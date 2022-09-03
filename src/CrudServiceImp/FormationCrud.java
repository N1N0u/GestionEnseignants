package CrudServiceImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Crud_Service.CrudFormation;
import Formation.Formation;

public class FormationCrud implements CrudFormation{
	
	public void addFormation(Formation formation) throws ClassNotFoundException, SQLException {
		String sql="insert into Formation (titre, duree, prix) values('"+formation.getTitre()+"', '"+formation.getDuree()+"', "+formation.getPrix()+")";
		sqlConnection.executeSQLQuery(sql);
	}


	public void deleteForation(Formation formation) throws ClassNotFoundException, SQLException {
	String sql="Delete  from Formation where id="+formation.getId();
	sqlConnection.executeSQLQuery(sql);
	}

	
	public void updateFormataion(Formation formation) throws ClassNotFoundException, SQLException {
		 String sql = "UPDATE Formation SET titre = '"+formation.getTitre()+"', duree = '"+formation.getDuree()+ "', prix = " +formation.getPrix()+ " WHERE id = "+formation.getId()+" ";
		 sqlConnection.executeSQLQuery(sql);
	}

	
	public Formation getFormation(int numeroFormation) throws ClassNotFoundException, SQLException{
		java.sql.Connection c=sqlConnection.conector();
		String sql="select * from Formation where id='"+numeroFormation+"'";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		Formation f=null;
		while (rs.next())
		{
			f=new Formation(rs.getInt("id"),rs.getString("titre"),rs.getString("duree"),rs.getDouble("prix"));
		}
		return f;
	}

}
