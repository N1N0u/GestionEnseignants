package CrudServiceImp;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Crud_Service.ServiceCatalogue;
import Formation.Catalogue;
import Formation.Formation;

public class CatalogueService implements ServiceCatalogue{
	
	public Vector getAllCatalogue() throws SQLException {
		Vector v=new Vector();
		Connection c= sqlConnection.conector();
		String sql="select * from Catalogue";
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next())
		{
		v.addElement(new Catalogue(rs.getInt("idFormation"),rs.getString("description")));
		}
		c.close();
		return v;
		
	}
	public void Afficher(JTable table) throws SQLException
	{
		FormationService fs=new FormationService();
		Vector formation = fs.getAllFormation();
		CatalogueService cs=new CatalogueService();
		Vector catalogue = cs.getAllCatalogue();
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		int j=0;
		do{
			Catalogue c=(Catalogue) catalogue.get(j);
		for (int i=0; i<formation.size();i++)
		{
			Formation f= (Formation) formation.get(i);
			if(f.getId()==c.getIdFormation()){
			Object[]row=new Object[]{f.getId(),f.getTitre(),c.getDescription(),f.getDuree(),f.getPrix(),false};
			model.addRow(row);	}
		}
		j++;
		}while(j<catalogue.size());
	}

	public Vector getCatalogueByIdFormation(int id) throws SQLException {
		Vector v=new Vector();
		Connection c= sqlConnection.conector();
		String sql="select * from Catalogue where idFormation="+id;
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next())
		{
		v.addElement(new Catalogue(rs.getInt("idFormation"),rs.getString("description")));
		}
		c.close();
		return v;
	}
}
