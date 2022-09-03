package Crud_Service;

import java.sql.SQLException;

import DemandeFormation.Enseignant;

public interface CrudEnseignant {
	public void AddEnseignant(Enseignant enseignant) throws SQLException, ClassNotFoundException;
	public Enseignant getEnseignant(String email)throws SQLException, ClassNotFoundException;
}
