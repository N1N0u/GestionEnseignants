package Crud_Service;

import java.sql.SQLException;
import java.util.Vector;

public interface ServiceSession {
	public Vector getAllSession() throws SQLException;
	public Vector getSessionByIdFormation(int id) throws SQLException;
}
