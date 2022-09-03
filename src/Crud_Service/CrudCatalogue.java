package Crud_Service;

import java.sql.SQLException;

import Formation.Catalogue;
import Formation.Formation;

public interface CrudCatalogue {
	public void deleteFormationFromCatalogue(int id) throws ClassNotFoundException, SQLException;
	public void updateFormationFromCatalogue(Catalogue catalogue,Formation formation)throws ClassNotFoundException, SQLException;
	public void addFormationToCatalogue(Catalogue c,Formation f)throws ClassNotFoundException, SQLException;
}
