package InterfacesGraphic;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CrudServiceImp.CatalogueService;

public class CatalogueFormation extends JFrame {

	private JFrame frame;
	private JTable table;
	public Vector formation;
	public Vector catalogue;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogueFormation window = new CatalogueFormation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param d 
	 * @throws SQLException 
	 */
	
	public CatalogueFormation() throws SQLException {
		initialize();
		// Appel au service du catalogue
		CatalogueService cs=new CatalogueService();
		//Affichage de la liste du catalogue
		cs.Afficher(table);
		frame.setVisible(true);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Catalogue des formations");
		frame.setResizable(false);
		frame.setBounds(100, 100, 672, 476);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVoiciLaListe = new JLabel("Voici la liste de tous nos formation:");
		lblVoiciLaListe.setBounds(25, 11, 243, 14);
		frame.getContentPane().add(lblVoiciLaListe);
		
		
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(544, 403, 102, 23);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnQuitter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 41, 619, 351);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titre Formation", "Description Formation", "duree", "Prix"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(97);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(220);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setRowSelectionAllowed(false);
	}
}
