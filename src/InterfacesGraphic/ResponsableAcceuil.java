package InterfacesGraphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import CrudServiceImp.CatalogueService;
import CrudServiceImp.ChoixCrud;
import CrudServiceImp.ChoixService;
import CrudServiceImp.ContenuService;
import CrudServiceImp.DemandeCrud;
import CrudServiceImp.DemandeService;
import CrudServiceImp.EnseignantCrud;
import CrudServiceImp.EnseignantService;
import CrudServiceImp.FormationCrud;
import CrudServiceImp.FormationService;
import CrudServiceImp.InscriptionCrud;
import CrudServiceImp.SessionCrud;
import CrudServiceImp.SessionService;
import DemandeFormation.Choix;
import DemandeFormation.Demande;
import DemandeFormation.Enseignant;
import DemandeFormation.Inscription;
import Formation.Catalogue;
import Formation.Contenu;
import Formation.Formation;
import Formation.Session;

import javax.swing.JTextField;

public class ResponsableAcceuil {

	private JFrame frame;
	private JTable table;
	DemandeService ds=new DemandeService();
	EnseignantService es=new EnseignantService();
	EnseignantCrud ec=new EnseignantCrud();
	SessionService ss=new SessionService();
	ContenuService cos=new ContenuService();
	CatalogueService cs=new CatalogueService();
	FormationService fs=new FormationService();
	ChoixService chs=new ChoixService();
	ChoixCrud chc=new ChoixCrud();
	SessionCrud sec=new SessionCrud();
	InscriptionCrud ic=new InscriptionCrud();
	FormationCrud fc=new FormationCrud();
	//Vecteur qui contient tous les demande des enseignants
	Vector demande=new Vector();
	//
	Vector v=new Vector();
	DemandeCrud dc=new DemandeCrud();
	private JTable table_1;
	private JTable table_2;
	private JTextField idfield;
	private JTable table_3;
	private JTable table_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponsableAcceuil window = new ResponsableAcceuil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ResponsableAcceuil() throws ClassNotFoundException, SQLException {
		initialize();
		frame.setResizable(false);
		//Afficher le catalogue
		cs.Afficher(table_1);
		//Afficher tous les demandes
		AfficherDemande(table);
		//Afficher la liste des choix de l'enseignant
		AfficherChoix();
		frame.setVisible(true);
	}
	//Afficher tous les demandes
	private void AfficherDemande(JTable tab) throws ClassNotFoundException, SQLException
	{
		//recuperer la liste des demandes dans 1 vecteur
		demande=ds.getAllDemande();
		//Recuperer le modele de la table 
		DefaultTableModel model=(DefaultTableModel) tab.getModel();
		//Set nombres de ligne=0
		model.setRowCount(0);
		//Boucle pour remplir la table 
		for(int i=0; i<demande.size();i++)
		{
			//recuperer le vecteur dans une demadne
			Demande d=(Demande) demande.get(i);
			//1 objet pour remplir chaque cellule
			Object []row =new Object[]{d.getEnseignant().getNom(),d.getEnseignant().getEmail(),d.getFormation().getTitre(),d.getDateDemande(),d.getEtat(),false};
			//Ajout les données dans une ligne de la table
			model.addRow(row);
		}	
	}
	//Afficher la liste des choix que l'enseignant a choisie
	private void AfficherChoix()throws ClassNotFoundException, SQLException
	{
		DefaultTableModel mod=(DefaultTableModel) table_3.getModel();
		mod.setRowCount(0);
		//Recuprer tous les choix
		Vector v=chs.getAllChoix();
		for(int i=0;i<v.size();i++)
		{
			Choix choix=(Choix) v.get(i);
			Object [] row=new Object[]{choix.getEnseignant().getNom(),choix.getEnseignant().getEmail(),choix.getFormation().getTitre(),choix.getSession().getId(),choix.getFormation().getId(),choix.getEtatC(),false};
			mod.addRow(row);
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Acceuil Responsable ");
		frame.setBounds(100, 100, 680, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuitter.setBounds(565, 383, 89, 23);
		frame.getContentPane().add(btnQuitter);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 664, 367);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Traiter Demande", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 659, 303);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom Enseignant", "Email Enseignant", "Titre Formation", "Date Demande", "Etat", "Choix"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(104);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(123);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(116);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnRefus = new JButton("Refus\u00E9");
		btnRefus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Delete();
				} catch (ClassNotFoundException | SQLException e) {}
			}
		});
		btnRefus.setBounds(570, 314, 89, 23);
		panel.add(btnRefus);
		
		JButton btnAccepter = new JButton("Accepter");
		btnAccepter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					update();
				} catch (ClassNotFoundException | SQLException e) {}
			}
		});
		btnAccepter.setBounds(452, 314, 89, 23);
		panel.add(btnAccepter);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.setRowCount(0);
				try {
					AfficherDemande(table);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnActualiser.setBounds(10, 314, 141, 23);
		panel.add(btnActualiser);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Chercher Formation", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 659, 274);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titre Formation", "Description", "Objectif", "Plan", "Nombre Place", "date Debut", "date Fin", "Lieu Session", "choix"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(89);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(128);
		table_2.getColumnModel().getColumn(7).setPreferredWidth(71);
		table_2.getColumnModel().getColumn(8).setResizable(false);
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblIdFormation = new JLabel("Id Formation");
		lblIdFormation.setBounds(23, 285, 115, 14);
		panel_2.add(lblIdFormation);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					find();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnChercher.setBounds(217, 281, 89, 23);
		panel_2.add(btnChercher);
		
		idfield = new JTextField();
		idfield.setBounds(97, 282, 86, 20);
		panel_2.add(idfield);
		idfield.setColumns(10);
		
		JLabel lblLid = new JLabel("NB: L'Id ce trouve dans le catalogue");
		lblLid.setBounds(23, 314, 224, 14);
		panel_2.add(lblLid);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Inscription", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 659, 278);
		panel_3.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom Enseignant", "Email Enseignant", "Titre Formation", "Id Session", "Id Formation", "etat Choix", "Choix"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_3.getColumnModel().getColumn(6).setResizable(false);
		scrollPane_3.setViewportView(table_3);
		
		JButton btnInscrire = new JButton("Inscrire");
		btnInscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel mod=(DefaultTableModel) table_3.getModel();
				for (int i=0; i<mod.getRowCount();i++)
				{
					String date="";
					String email=(String) mod.getValueAt(i, 1);
					//System.out.println(email);
					int ids=(int) mod.getValueAt(i, 3);
				//	System.out.println(ids);
					int idf=(int) mod.getValueAt(i, 4);
				//	System.out.println(idf);
					boolean check=(Boolean) mod.getValueAt(i, 6);
					if(check)
					{
					try {
						Vector v=chs.getAllChoix();
						Choix choix=(Choix) v.get(i);
						Session	s = sec.getSession(ids);
						Enseignant e=ec.getEnseignant(email);
						Formation f=fc.getFormation(idf);
						choix.setEnseignant(e);
						choix.setSession(s);
						choix.setEtatC(3);
						choix.setFormation(f);
						chc.UpdateChoix(choix);
						Inscription ins=new Inscription(0,e,s,date);
						ic.AddInscription(ins);
						JOptionPane.showMessageDialog(null, "Inscription Valider");
					} catch (ClassNotFoundException | SQLException e1) {}
					
					}
				}
				mod.setRowCount(0);
				try {
					AfficherChoix();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInscrire.setBounds(547, 305, 89, 23);
		panel_3.add(btnInscrire);
		
		JButton btnAcctualiser = new JButton("Actualiser");
		btnAcctualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table_3.getModel();
				model.setRowCount(0);
				try {
					AfficherChoix();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAcctualiser.setBounds(10, 305, 113, 23);
		panel_3.add(btnAcctualiser);
		
		JButton btnAnnulerInscription = new JButton("Annuler Inscription");
		btnAnnulerInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel mod=(DefaultTableModel) table_3.getModel();
				for (int i=0; i<mod.getRowCount();i++)
				{
					String date="";
					String email=(String) mod.getValueAt(i, 1);
					int ids=(int) mod.getValueAt(i, 3);
					int idf=(int) mod.getValueAt(i, 4);
					boolean check=(Boolean) mod.getValueAt(i, 6);
					if(check)
					{
					try {
						Vector v=chs.getAllChoix();
						Choix choix=(Choix) v.get(i);
						Session	s = sec.getSession(ids);
						Enseignant e=ec.getEnseignant(email);
						Formation f=fc.getFormation(idf);
						choix.setEnseignant(e);
						choix.setSession(s);
						choix.setEtatC(3);
						choix.setFormation(f);
						chc.DeleteChoix(choix);
						Inscription ins=new Inscription(0,e,s,date);
						ic.DeleteInscription(ins);
						JOptionPane.showMessageDialog(null, "Inscription Annuler");
					} catch (ClassNotFoundException | SQLException e1) {}
					
					}
				}
				mod.setRowCount(0);
				try {
					AfficherChoix();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnAnnulerInscription.setBounds(376, 305, 142, 23);
		panel_3.add(btnAnnulerInscription);
		
		table_4 = new JTable();
		table_4.setBounds(0, 0, 659, 278);
		panel_3.add(table_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Catalogue", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 659, 339);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Formation", "Titre Formation", "Description ", "duree", "Prix"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(81);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(107);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(151);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		scrollPane_1.setViewportView(table_1);
	}
	private void find() throws SQLException
	{
		//Recuprer l'id de la formation a chercher
		String id=idfield.getText();
		int idF=Integer.parseInt(id);
		//recuperer le model de la table qui va afficher la liste des formation avec ses differentes session
		DefaultTableModel model=(DefaultTableModel) table_2.getModel();
		model.setRowCount(0);
		//Recuperer la formation a chercher
		Vector formation=fs.getFomationbynumero(idF);
		//recuperer les infos de la formation dans le catalogue (description)
		Vector catalogue=cs.getCatalogueByIdFormation(idF);
		//Recuperer les sessions de la formation
		Vector session=ss.getSessionByIdFormation(idF);
		//recuperer les info dans le contenu de la formation
		Vector contenu=cos.getContenubyIdFormation(idF);
		for (int i=0; i<formation.size();i++)
		{
			Catalogue c=(Catalogue) catalogue.get(i);
			Contenu con=(Contenu) contenu.get(i);
			Formation f=(Formation) formation.get(i);
			int j=0;
			while(j<session.size()){
			Session s=(Session) session.get(j);
			Object row[]=new Object[]{f.getTitre(),c.getDescription(),con.getObjectif(),con.getPlan(),con.getNombrePlace(),s.getDateDebut(),s.getDateFin(),s.getLieu(),false};
			model.addRow(row);
			j++;
			}
		}
	}

	private void update() throws ClassNotFoundException, SQLException
	{
		DefaultTableModel mod=(DefaultTableModel) table.getModel();
		for(int i=0; i<mod.getRowCount();i++)
		{
			//une variable pour recuperer la case chauché
			boolean check=(Boolean) mod.getValueAt(i, 5);
			//si la case est cauché
			if (check)
			{
				Demande d=(Demande) demande.get(i);
				//On mis l'etat=2 (demande accepter)
				d.setEtat(2);
				//mis a jour l'etat de la demande
				dc.updateDemande(d);
				JOptionPane.showMessageDialog(null, "Update Succes");
			}
		}
		mod.setRowCount(0);
		AfficherDemande(table);
		
	}
	private void Delete() throws ClassNotFoundException, SQLException
	{
		DefaultTableModel mod=(DefaultTableModel) table.getModel();
		for(int i=0; i<mod.getRowCount();i++)
		{
			boolean check=(Boolean) mod.getValueAt(i, 5);
			if (check)
			{
				Demande d=(Demande) demande.get(i);
				//on mis l'etat=1 (demande refusé)
				d.setEtat(1);
				dc.updateDemande(d);
				JOptionPane.showMessageDialog(null, "Update Succes");
			}
		}
		mod.setRowCount(0);
		AfficherDemande(table);
	}

}
