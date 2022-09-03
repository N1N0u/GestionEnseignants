package InterfacesGraphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

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
import javax.swing.JTextField;

import CrudServiceImp.CatalogueCrud;
import CrudServiceImp.CatalogueService;
import CrudServiceImp.ContenuCrud;
import CrudServiceImp.ContenuService;
import CrudServiceImp.DemandeService;
import CrudServiceImp.FormationCrud;
import CrudServiceImp.FormationService;
import CrudServiceImp.SessionCrud;
import CrudServiceImp.SessionService;
import Formation.Catalogue;
import Formation.Contenu;
import Formation.Formation;
import Formation.Session;

public class AcceuilOrganisme {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField titref;
	private JTextField descf;
	private JTextField objf;
	private JTextField planf;
	private JTextField dureef;
	private JTextField prixf;
	private JTextField nbpf;
	DemandeService ds=new DemandeService();
	FormationService fs=new FormationService();
	FormationCrud fc=new FormationCrud();
	CatalogueService cs=new CatalogueService();
	CatalogueCrud cc=new CatalogueCrud();
	ContenuService cos=new ContenuService();
	SessionService ss=new SessionService();
	SessionCrud sc=new SessionCrud();
	ContenuCrud conc=new ContenuCrud();
	private JTextField idformation;
	private JTextField datedebut;
	private JTextField datefin;
	private JTextField lieu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilOrganisme window = new AcceuilOrganisme();
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
	 */
	public AcceuilOrganisme() throws SQLException {
		initialize();
		frame.setResizable(false);
		//Afficher tous les formations
		AfficherFormations();
		//Afficher tous les sessions
		AfficherSessions();
		frame.setVisible(true);
	}
	//Afficher tous les formations
	private void AfficherFormations() throws SQLException
	{
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		//recuperer tous les formation
		Vector formation=fs.getAllFormation();
		//recuperer les detailles des formations
		Vector catalogue=cs.getAllCatalogue();
		//recuperer le contenu des formations
		Vector contenu=cos.getAllContenu();
		//Boucle d'ajout des formations dans la table
		for(int i=0; i<formation.size();i++)
		{
			Formation f=(Formation) formation.get(i);
			Catalogue c=(Catalogue) catalogue.get(i);
			Contenu con=(Contenu) contenu.get(i);
			Object []row=new Object[]{f.getId(),f.getTitre(),c.getDescription(),con.getPlan(),con.getObjectif(),con.getNombrePlace(),f.getDuree(),f.getPrix(),false};
			model.addRow(row);	
		}
		
	}
	//Afficher tous les sessions pour chaque formation
	private void AfficherSessions() throws SQLException
	{
		DefaultTableModel model= (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		Vector session=ss.getAllSession();
		for(int i=0; i<session.size();i++)
		{
			Session s=(Session) session.get(i);
			Object []row=new Object[]{s.getId(),s.getDateDebut(),s.getDateFin(),s.getLieu(),s.getIdFormation(),false};
			model.addRow(row);
			
		}

	}	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Organisme Acceuil");
		frame.setBounds(100, 100, 824, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(700, 395, 98, 23);
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnQuitter);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 808, 384);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Gerer Formations", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 803, 311);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Titre Formation", "Description", "plan", "Objectif", "Nombre Place", "Duree", "Prix", "Choix"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Double.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(42);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		scrollPane.setViewportView(table);
		// Modifier les informations de la formation
		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				for (int i=0; i<model.getRowCount();i++)
				{
					boolean check=(Boolean) model.getValueAt(i, 8);
					try {
						if(check){
							//cree une formation
						Formation form=new Formation();
						//Recuperer l'id et l'ajouter
						form.setId((int) model.getValueAt(i, 0));
						//Ajouter le titre
						form.setTitre((String)model.getValueAt(i, 1));
						//Ajouter la duree
						form.setDuree((String)model.getValueAt(i, 6));
						//Ajouter le prix de la formation
						form.setPrix((Double) model.getValueAt(i, 7));
						//Modifier la session
						fc.updateFormataion(form);
						Catalogue cat=new Catalogue();
						cat.setDescription((String)model.getValueAt(i, 2));
						cat.setIdFormation((int) model.getValueAt(i, 0));
						//Modifier la description dans le catalogue
						cc.updateFormationFromCatalogue(cat, form);
						Contenu co=new Contenu();
						co.setIdFormation((int) model.getValueAt(i, 0));
						co.setNombrePlace((Integer)model.getValueAt(i, 5));
						co.setObjectif((String)model.getValueAt(i, 4));
						co.setPlan((String)model.getValueAt(i, 3));
						//Modifier le contenu de la formation
						conc.updateContenu(co);
						JOptionPane.showMessageDialog(null, "Modification succes");
						}
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				model.setRowCount(0);
				try {
					//reafficher la table des formations
					AfficherFormations();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(504, 322, 106, 23);
		panel.add(btnUpdate);
		//Supprimer une formation
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				for(int i=0;i<model.getRowCount();i++)
				{
					boolean check=(Boolean) model.getValueAt(i, 8);
					if (check)
					{
						try {
							Formation form=new Formation();
							form.setId((int) model.getValueAt(i, 0));
							//Supprimer la formation
							fc.deleteForation(form);
							Catalogue c=new Catalogue();
							c.setIdFormation((int) model.getValueAt(i, 0));
							//Supprimer la description de la formation dans le catalogue
							cc.deleteFormationFromCatalogue(c.getIdFormation());
							Contenu con=new Contenu();
							con.setIdFormation((int) model.getValueAt(i, 0));
							//Supprimer le contenu de la formation
							conc.deleteContenu(con);
							JOptionPane.showMessageDialog(null, "Suppression succes");
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				model.setRowCount(0);
				try {
					//reafficher la liste des formations
					AfficherFormations();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setBounds(681, 322, 112, 23);
		panel.add(btnSupprimer);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Cree Formatoin", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(10, 11, 93, 14);
		panel_3.add(lblTitre);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 36, 93, 14);
		panel_3.add(lblDescription);
		
		JLabel lblObjectif = new JLabel("Objectif");
		lblObjectif.setBounds(10, 61, 93, 14);
		panel_3.add(lblObjectif);
		
		JLabel lblPlan = new JLabel("Plan");
		lblPlan.setBounds(10, 92, 93, 14);
		panel_3.add(lblPlan);
		
		JLabel lblDuree = new JLabel("Duree");
		lblDuree.setBounds(10, 119, 93, 14);
		panel_3.add(lblDuree);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(10, 145, 93, 14);
		panel_3.add(lblPrix);
		
		JLabel lblNombrePlace = new JLabel("Nombre Place");
		lblNombrePlace.setBounds(10, 170, 93, 14);
		panel_3.add(lblNombrePlace);
		
		titref = new JTextField();
		titref.setBounds(158, 8, 145, 20);
		panel_3.add(titref);
		titref.setColumns(10);
		
		descf = new JTextField();
		descf.setColumns(10);
		descf.setBounds(158, 33, 145, 20);
		panel_3.add(descf);
		
		objf = new JTextField();
		objf.setColumns(10);
		objf.setBounds(158, 58, 145, 20);
		panel_3.add(objf);
		
		planf = new JTextField();
		planf.setColumns(10);
		planf.setBounds(158, 89, 145, 20);
		panel_3.add(planf);
		
		dureef = new JTextField();
		dureef.setColumns(10);
		dureef.setBounds(158, 116, 145, 20);
		panel_3.add(dureef);
		
		prixf = new JTextField();
		prixf.setColumns(10);
		prixf.setBounds(158, 142, 145, 20);
		panel_3.add(prixf);
		
		nbpf = new JTextField();
		nbpf.setColumns(10);
		nbpf.setBounds(158, 167, 145, 20);
		panel_3.add(nbpf);
		//Ajouter une nouvelle formation
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Cree une formation
					Formation f=new Formation();
					//recuperer le titre etl'ajouter 
					f.setTitre((String)titref.getText());
					f.setDuree(dureef.getText());
					String pr=prixf.getText();
					double d=Double.parseDouble(pr);
					f.setPrix(d);
					//Ajouter la formation
					fc.addFormation(f);
					Catalogue c=new Catalogue();
					int identifiant=fs.getIdFormation(titref.getText());
					c.setDescription(descf.getText());
					c.setIdFormation(identifiant);
					//Ajouter la description de la formation dans le catalogue
					cc.addFormationToCatalogue(c, f);
					Contenu co=new Contenu();
					co.setIdFormation(identifiant);
					int nbr=Integer.parseInt(nbpf.getText());
					co.setNombrePlace(nbr);
					co.setObjectif(objf.getText());
					co.setPlan(planf.getText());
					//Ajouter le contenu de la formation
					conc.addContenu(co);
					JOptionPane.showMessageDialog(null, "Ajouter succes");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					AfficherFormations();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAjouter.setBounds(221, 210, 89, 23);
		panel_3.add(btnAjouter);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Gerer Session", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 803, 302);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id Session", "Date Debut", "Date Fin", "Lieu", "Id Formation", "Choix"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_1);
		//Supprimer une session
		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table_1.getModel();
				for(int i=0; i<model.getRowCount();i++)
				{
					boolean check=(Boolean) model.getValueAt(i, 5);
					if (check)
					{
						
						try {
							Session s=new Session();
							s.setId((int) model.getValueAt(i, 0));
							//Supprimer la session depuis son id
							sc.deleteSession(s);
							JOptionPane.showMessageDialog(null, "Supprission succes");
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
				}
				model.setRowCount(0);
				try {
					//reafficher la liste des sessions
					AfficherSessions();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSupprimer_1.setBounds(660, 313, 118, 23);
		panel_2.add(btnSupprimer_1);
		//Modifier une session
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table_1.getModel();
				for(int i=0; i<model.getRowCount();i++)
				{
					boolean check=(Boolean) model.getValueAt(i, 5);
					if (check)
					{
						
						try {
							//Recuperer tous les Nouveaux detailles 
							Session s=new Session();
							s.setId((int) model.getValueAt(i, 0));
							s.setIdFormation((int) model.getValueAt(i, 4));
							s.setLieu((String) model.getValueAt(i, 3));
							s.setDateDebut((String) model.getValueAt(i, 1));
							s.setDateFin((String) model.getValueAt(i, 2));
							//Modifier la session
							sc.updateSession(s);
							JOptionPane.showMessageDialog(null, "Update succes");
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
				}
				model.setRowCount(0);
				try {
					//reafficher la liste des sessions
					AfficherSessions();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModifier.setBounds(488, 313, 112, 23);
		panel_2.add(btnModifier);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cree Session", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblIdFormation = new JLabel("Id Formation");
		lblIdFormation.setBounds(10, 23, 93, 14);
		panel_1.add(lblIdFormation);
		
		JLabel lblDateDebut = new JLabel("Date Debut");
		lblDateDebut.setBounds(10, 57, 93, 14);
		panel_1.add(lblDateDebut);
		
		JLabel lblDateFin = new JLabel("Date Fin");
		lblDateFin.setBounds(10, 88, 93, 14);
		panel_1.add(lblDateFin);
		
		JLabel lblLieu = new JLabel("Lieu");
		lblLieu.setBounds(10, 122, 93, 14);
		panel_1.add(lblLieu);
		//Ajouter une session
		JButton btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aa=Integer.parseInt(idformation.getText());
				try {
					//Nouvelle session depuis les détailles saisie parl'organisme
					Session s=new Session();
					s.setDateDebut(datedebut.getText());
					s.setLieu(lieu.getText());
					s.setIdFormation(aa);
					s.setDateFin(datefin.getText());
					//Ajouter la session a la liste
					sc.addSession(s);
					JOptionPane.showMessageDialog(null, "Ajout avec succés");
				} catch (ClassNotFoundException | SQLException e1) {}
				
				try {
					//reafficher la liste des sessions
					AfficherSessions();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAjouter_1.setBounds(10, 166, 89, 23);
		panel_1.add(btnAjouter_1);
		
		idformation = new JTextField();
		idformation.setBounds(165, 20, 167, 20);
		panel_1.add(idformation);
		idformation.setColumns(10);
		
		datedebut = new JTextField();
		datedebut.setColumns(10);
		datedebut.setBounds(165, 54, 167, 20);
		panel_1.add(datedebut);
		
		datefin = new JTextField();
		datefin.setColumns(10);
		datefin.setBounds(165, 85, 167, 20);
		panel_1.add(datefin);
		
		lieu = new JTextField();
		lieu.setColumns(10);
		lieu.setBounds(165, 119, 167, 20);
		panel_1.add(lieu);
	}
}
