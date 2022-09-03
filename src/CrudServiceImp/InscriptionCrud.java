package CrudServiceImp;

import java.sql.SQLException;

import Crud_Service.CrudInscription;
import DemandeFormation.Inscription;

public class InscriptionCrud implements CrudInscription {

	public void AddInscription(Inscription ins) throws ClassNotFoundException,SQLException {
		String sql="insert into Inscription (emailEnseignant,idSession ) values ( '"+ins.getEnseignant().getEmail()+"', '"+ins.getSession().getId()+"')";
		sqlConnection.executeSQLQuery(sql);
	}

	public void DeleteInscription(Inscription ins)throws ClassNotFoundException, SQLException {
		String sql="delete from Inscription where emailEnseignant='"+ins.getEnseignant().getEmail()+"' and idSession="+ins.getSession().getId();
		sqlConnection.executeSQLQuery(sql);
		
	}

}
