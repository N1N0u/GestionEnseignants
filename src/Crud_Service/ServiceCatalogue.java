package Crud_Service;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import Formation.Catalogue;

public interface ServiceCatalogue {
	public Vector getAllCatalogue() throws SQLException;
	public void Afficher(JTable table) throws SQLException;
	public Vector getCatalogueByIdFormation(int id)throws SQLException;
}
