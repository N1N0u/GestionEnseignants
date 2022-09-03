package CrudServiceImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Crud_Service.CrudDemande;
import DemandeFormation.Demande;
import DemandeFormation.Enseignant;
import Formation.Formation;
import Formation.Session;

public class DemandeCrud implements CrudDemande{

	public void AddDemande(Demande demande) throws ClassNotFoundException, SQLException {
	String sql="insert into Demande (IDFormation,emailEnseignant,etat)  values("+demande.getFormation().getId()+",'"+demande.getEnseignant().getEmail()+"',0)";
	sqlConnection.executeSQLQuery(sql);
	}

	public void updateDemande(Demande demande)throws ClassNotFoundException, SQLException{
	String sql=" update Demande set etat= "+demande.getEtat()+" where Demande.idFormation= "+demande.getFormation().getId()+" and Demande.emailEnseignant='"+demande.getEnseignant().getEmail()+"'";
	sqlConnection.executeSQLQuery(sql);	
	}
	public void updateDemandeByIdSession(Demande d, int id)throws ClassNotFoundException, SQLException {
		String sql=" update Demande set etat= "+d.getEtat()+" where Demande.idFormation= "+d.getFormation().getId()+" and Session.id="+id+" and Demande.emailEnseignant='"+d.getEnseignant().getEmail()+"'";
		sqlConnection.executeSQLQuery(sql);	

	}

	
	
	

}
