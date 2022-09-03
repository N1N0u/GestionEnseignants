package Crud_Service;

import java.sql.SQLException;

import Formation.Organisme;

public interface ServiceOrganisme {
public Organisme login(String user, String password) throws SQLException;
}
