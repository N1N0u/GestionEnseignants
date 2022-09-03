package Crud_Service;

import java.sql.SQLException;

import DemandeFormation.Demande;
import Formation.Session;

public interface CrudDemande {
	public void AddDemande(Demande demande) throws ClassNotFoundException, SQLException;
	public void updateDemande(Demande demande)throws ClassNotFoundException, SQLException;
	public void updateDemandeByIdSession(Demande d, int id)throws ClassNotFoundException, SQLException;
}