package Crud_Service;

import java.sql.SQLException;

import Formation.Formation;

public interface CrudFormation {
	public void addFormation(Formation formation) throws ClassNotFoundException, SQLException;
	public void deleteForation(Formation formation)throws ClassNotFoundException, SQLException;
	public void updateFormataion(Formation formation)throws ClassNotFoundException, SQLException;
	public Formation getFormation(int numeroFormation)throws ClassNotFoundException, SQLException;
}
