package Crud_Service;

import java.sql.SQLException;
import java.util.Vector;

import DemandeFormation.Enseignant;

public interface ServiceEnseignant {
	public Vector getAllEnseignant() throws SQLException;
	public Enseignant login(String email, String password) throws SQLException;
}
