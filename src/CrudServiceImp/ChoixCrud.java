package CrudServiceImp;

import java.sql.SQLException;

import Crud_Service.CrudChoix;
import DemandeFormation.Choix;

public class ChoixCrud implements CrudChoix {


	public void AddChoix(Choix choix) throws ClassNotFoundException, SQLException {
		String sql="insert into Choix (etatC,idFormation, idSession, emailEns) values("+choix.getEtatC()+","+choix.getFormation().getId()+", "+choix.getSession().getId()+", '"+choix.getEnseignant().getEmail()+"')";
		sqlConnection.executeSQLQuery(sql);
	}
	

	public void DeleteChoix(Choix choix) throws ClassNotFoundException, SQLException {
		String sql="delete from Choix where emailEns='"+choix.getEnseignant().getEmail()+"' and idSession="+choix.getSession().getId();
		sqlConnection.executeSQLQuery(sql);
	}

	public void UpdateChoix(Choix choix) throws ClassNotFoundException,SQLException {
		String sql="update Choix set etatC="+choix.getEtatC()+" where emailEns='"+choix.getEnseignant().getEmail()+"' and idSession="+choix.getSession().getId();
		sqlConnection.executeSQLQuery(sql);
	}

}
