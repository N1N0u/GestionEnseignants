package Crud_Service;

import java.sql.SQLException;

import DemandeFormation.Inscription;

public interface CrudInscription {
	public void AddInscription(Inscription ins) throws ClassNotFoundException, SQLException;
	public void DeleteInscription(Inscription ins)throws ClassNotFoundException, SQLException;
	
}
