package Crud_Service;

import java.sql.SQLException;

import DemandeFormation.Choix;

public interface CrudChoix {
	public void AddChoix(Choix choix)throws ClassNotFoundException, SQLException;
	public void DeleteChoix(Choix choix) throws ClassNotFoundException, SQLException;
	public void UpdateChoix(Choix choix)throws ClassNotFoundException, SQLException;
		
}
