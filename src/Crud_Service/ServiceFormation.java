package Crud_Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public interface ServiceFormation {
	public Vector getFomationbynumero(int numero) throws SQLException;
	public Vector getAllFormation() throws SQLException;
	public int getIdFormation(String titre)throws ClassNotFoundException, SQLException;

}
