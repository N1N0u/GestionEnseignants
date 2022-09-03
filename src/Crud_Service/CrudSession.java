package Crud_Service;

import java.sql.SQLException;

import Formation.Session;

public interface CrudSession {
	public void addSession(Session s) throws ClassNotFoundException, SQLException;
	public void deleteSession(Session s)throws ClassNotFoundException, SQLException;
	public void updateSession(Session s)throws ClassNotFoundException, SQLException;
	public Session getSession(int id)throws ClassNotFoundException, SQLException;
}
