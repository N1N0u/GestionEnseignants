package CrudServiceImp;

import java.sql.SQLException;

import Crud_Service.CrudContenu;
import Formation.Contenu;

public class ContenuCrud implements CrudContenu{

	
	public void updateContenu(Contenu c) throws ClassNotFoundException, SQLException {
		String sql=" update Contenu set objectif= '"+c.getObjectif()+"', plan= '"+c.getPlan()+"', nombrePlace= "+c.getNombrePlace()+" where idFormation= "+c.getIdFormation();
		sqlConnection.executeSQLQuery(sql);
	}


	public void deleteContenu(Contenu c) throws ClassNotFoundException,SQLException {
		String sql="delete from Contenu where idFormation="+c.getIdFormation();
		sqlConnection.executeSQLQuery(sql);
	}

	
	public void addContenu(Contenu c) throws ClassNotFoundException,SQLException {
		String sql="insert into Contenu (plan,objectif,nombrePlace,idFormation) values('"+c.getPlan()+"', '"+c.getObjectif()+"', "+c.getNombrePlace()+", "+c.getIdFormation()+")";
		sqlConnection.executeSQLQuery(sql);
	}

}
