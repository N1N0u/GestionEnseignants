package CrudServiceImp;

import java.sql.Connection;
import java.sql.SQLException;

import Crud_Service.CrudCatalogue;
import Formation.Catalogue;
import Formation.Formation;

public class CatalogueCrud implements CrudCatalogue {
	
	public void deleteFormationFromCatalogue(int id) throws ClassNotFoundException, SQLException {
		String sql="delete from Catalogue where idFormation='"+id+"'";
		sqlConnection.executeSQLQuery(sql);
	}
	public void updateFormationFromCatalogue(Catalogue catalogue,Formation formation)throws ClassNotFoundException, SQLException {
		 String sql = "UPDATE Catalogue SET description = '"+catalogue.getDescription()+"',  titreFormation = '" +formation.getTitre()+ "' WHERE idFormation = "+formation.getId()+" ";
		sqlConnection.executeSQLQuery(sql);
	}
	public void addFormationToCatalogue(Catalogue c,Formation f)throws ClassNotFoundException, SQLException {
		String sql="insert into Catalogue (idFormation,description,titreFormation) values("+c.getIdFormation()+", '"+c.getDescription()+"', '"+f.getTitre()+"')";
		sqlConnection.executeSQLQuery(sql);
	}

}
