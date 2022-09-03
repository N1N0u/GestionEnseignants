package Crud_Service;

import java.sql.SQLException;
import java.util.Vector;

public interface ServiceDemande {
	public Vector getDemandebyEmail(String email) throws ClassNotFoundException, SQLException;
	public Vector getAllDemande()throws ClassNotFoundException, SQLException;
	public Vector getDemandeRefuser(String email) throws ClassNotFoundException, SQLException;
	public Vector getDemandeAccepter(String email) throws ClassNotFoundException, SQLException;
}
