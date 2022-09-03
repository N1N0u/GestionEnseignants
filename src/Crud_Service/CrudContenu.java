package Crud_Service;

import java.sql.SQLException;

import Formation.Contenu;

public interface CrudContenu {
	public void updateContenu(Contenu c) throws ClassNotFoundException, SQLException;
	public void deleteContenu(Contenu c)throws ClassNotFoundException, SQLException;
	public void addContenu(Contenu c)throws ClassNotFoundException, SQLException;

}
