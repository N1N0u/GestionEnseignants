package Crud_Service;

import java.sql.SQLException;
import java.util.Vector;

public interface ServiceContenu {
	public Vector getAllContenu() throws SQLException;
	public Vector getContenubyIdFormation(int id)throws SQLException;
}
