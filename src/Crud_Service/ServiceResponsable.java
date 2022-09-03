package Crud_Service;

import java.sql.SQLException;

import DemandeFormation.Responsable;

public interface ServiceResponsable {
	public Responsable getUser(String user, String password) throws SQLException;

}
