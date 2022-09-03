package InterfacesGraphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import CrudServiceImp.CatalogueService;
import CrudServiceImp.ChoixCrud;
import CrudServiceImp.ContenuService;
import CrudServiceImp.DemandeCrud;
import CrudServiceImp.DemandeService;
import CrudServiceImp.EnseignantCrud;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class AcceuilEnseignant  {

	private JFrame frame;
	private JTable DR;
	private JTable table_1;
	private JTable tabA;
	static String email=new String();
	CatalogueService cs=new CatalogueService();
	DemandeService ds=new DemandeService();
	SessionService ss=new SessionService();
	ContenuService cos=new ContenuService();
	FormationService fs=new FormationService();
	FormationCrud fc=new FormationCrud();
	DemandeCrud dc=new DemandeCrud();
	SessionCrud sc=new SessionCrud();
	EnseignantCrud ec=new EnseignantCrud();
	ChoixCrud chc=new ChoixCrud();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilEnseignant window = new AcceuilEnseignant(email);
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
	public AcceuilEnseignant(String email) throws SQLException, ClassNotFoundException {
		setEmail(email);
		initialize();
		//Affichage du catalogue
		cs.Afficher(table_1);
		frame.setResizable(false);
		//Remplir la table des demandes refuser ou en Attente
		AfficherDemandeRefuser(DR);
		//Remplir la table des demandes Accepter
		AfficherDemandeAccepter(tabA);
		frame.setVisible(true);
	}
	//Méthode pour Afficher tous les demandes refuser
	private void AfficherDemandeRefuser(JTable tab) throws ClassNotFoundException, SQLException
	{
		DefaultTableModel mod=(DefaultTableModel) tab.getModel();
		mod.setRowCount(0);
		Vector v=new Vector();
		v=ds.getDemandeRefuser(email);
		for(int i=0;i<v.size();i++)
		{
		Demande demande=(Demande) v.get(i);
		Object [] row=new Object[]{demande.getDateDemande(),demande.getFormation().getTitre(),demande.getEtat()};
		mod.addRow(row);
		}	
	}
	//Tableau pour recupérer les id des formations Accepter 
	int[] index=new int[50];
	//Méthode pour Afficher tous les demandes accepter et ses informations
	private void AfficherDemandeAccepter(JTable tab)throws ClassNotFoundException, SQLException
	{
		Vector  formation = new Vector();
		Vector catalogue=new Vector();
		Vector session=new Vector();
		Vector contenu=new Vector();
		DefaultTableModel model= (DefaultTableModel) tab.getModel();
		model.setRowCount(0);
		Vector d=ds.getDemandeAccepter(email);
		for (int i=0; i<d.size();i++)
		{
			Demande dem=(Demande) d.get(i);
			index[i]=dem.getFormation().getId();
		}
		int k=0;
		while (k<d.size())
		{
			formation=fs.getFomationbynumero(index[k]);
			session=ss.getSessionByIdFormation(index[k]);
			catalogue=cs.getCatalogueByIdFormation(index[k]);
			contenu=cos.getContenubyIdFormation(index[k]);
		for (int i=0; i<formation.size();i++)
		{
			Demande de=(Demande) d.get(i);
			Catalogue c= (Catalogue) catalogue.get(i);
			Contenu con=(Contenu) contenu.get(i);
			Formation f=(Formation) formation.get(i);
			int j=0;
			while(j<session.size()){
			Session s=(Session) session.get(j);
			Object row[]=new Object[]{f.getTitre(),c.getDescription(),con.getObjectif(),con.getPlan(),con.getNombrePlace(),s.getDateDebut(),s.getDateFin(),s.getLieu(),false,s.getId(),f.getId()};
			model.addRow(row);
			j++;
			}
		}
		k++;
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 686, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 650, 357);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Demande R/A", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 645, 279);
		panel.add(scrollPane);
		
		DR = new JTable();
		DR.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date Demadne", "titre Formation", "Etat"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		DR.getColumnModel().getColumn(0).setResizable(false);
		DR.getColumnModel().getColumn(0).setPreferredWidth(116);
		DR.getColumnModel().getColumn(1).setResizable(false);
		DR.getColumnModel().getColumn(1).setPreferredWidth(99);
		DR.getColumnModel().getColumn(2).setResizable(false);
		DR.getColumnModel().getColumn(2).setPreferredWidth(58);
		scrollPane.setViewportView(DR);
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnQuitter.setBounds(546, 295, 89, 23);
		panel.add(btnQuitter);
		
		JButton btnActualiser_1 = new JButton("Actualiser");
		btnActualiser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) DR.getModel();
				model.setRowCount(0);
				try {
					AfficherDemandeRefuser(DR);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnActualiser_1.setBounds(10, 290, 115, 23);
		panel.add(btnActualiser_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Demande Accepter", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 645, 260);
		panel_2.add(scrollPane_2);
		
		tabA = new JTable();
		tabA.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titre Formation", "Description", "Objectif", "Plan", "nombre Place", "date Debut", "date Fin", "lieu", "Choix", "idSession", "id Formation"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Boolean.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return   columnEditables[column];
			}
		});
		tabA.getColumnModel().getColumn(0).setPreferredWidth(85);
		tabA.getColumnModel().getColumn(1).setPreferredWidth(64);
		tabA.getColumnModel().getColumn(2).setPreferredWidth(59);
		tabA.getColumnModel().getColumn(3).setPreferredWidth(54);
		tabA.getColumnModel().getColumn(5).setPreferredWidth(66);
		tabA.getColumnModel().getColumn(6).setPreferredWidth(51);
		tabA.getColumnModel().getColumn(7).setPreferredWidth(56);
		tabA.getColumnModel().getColumn(8).setResizable(false);
		tabA.getColumnModel().getColumn(9).setResizable(false);
		scrollPane_2.setViewportView(tabA);
		// Valider une demande et faire une inscription
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						try {
							Valider();
						} catch (SQLException | ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
					}
		});
		btnValider.setBounds(546, 271, 89, 23);
		panel_2.add(btnValider);
		// Annuler une demande 
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Annuler();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		});
		btnAnnuler.setBounds(447, 271, 89, 23);
		panel_2.add(btnAnnuler);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel mod=(DefaultTableModel) tabA.getModel();
					mod.setRowCount(0);
					AfficherDemandeAccepter(tabA);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnActualiser.setBounds(31, 271, 111, 23);
		panel_2.add(btnActualiser);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Catalogue", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 645, 278);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titre Formation", "Description", "Duree", "Prix", "Choix"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Double.class, Boolean.class
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
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(117);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(167);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(5).setResizable(false);
		scrollPane_1.setViewportView(table_1);
		// Demande une formation
		JButton btnDemander = new JButton("Demander");
		btnDemander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DemandeCrud dc=new DemandeCrud();
				DefaultTableModel model=(DefaultTableModel) table_1.getModel();
				String d="2016-11-11";
				Enseignant ens=new Enseignant(null,null,null,email,null);
				for (int i=0;i<model.getRowCount();i++)
				{
					boolean check=(Boolean) model.getValueAt(i, 5);
					int id=(int) model.getValueAt(i, 0);
					if (check)
					{
					Formation f=new Formation(id,null,null,0);
					Demande demande=new Demande(d,f,ens,0);
					try {
						dc.AddDemande(demande);
						
						JOptionPane.showMessageDialog(null, "Demande Ajouter");
					} catch (ClassNotFoundException | SQLException e) {
					}	
				}
			}
				
				
			}
		});
		btnDemander.setBounds(518, 289, 117, 23);
		panel_1.add(btnDemander);
		
	}
	// Annulation Choix
	private void Annuler() throws SQLException, ClassNotFoundException
	{
		DefaultTableModel mod=(DefaultTableModel) tabA.getModel();
		for(int i=0; i<mod.getRowCount();i++)
		{
			boolean check=(Boolean) mod.getValueAt(i, 8);
			if(check)
			{
				Enseignant enseignant=ec.getEnseignant(email);
				int id=(int) mod.getValueAt(i, 9);
				int num=(int) mod.getValueAt(i, 10);
				Formation f=fc.getFormation(num);
				Session s=sc.getSession(id);
				Choix c=new Choix(enseignant,f,s,1);
				chc.UpdateChoix(c);
				JOptionPane.showMessageDialog(null, "Choix Annuler");
			}
		}
		
	}
	//Validation du choix
		private void Valider() throws SQLException, ClassNotFoundException {
			DefaultTableModel mod=(DefaultTableModel) tabA.getModel();
			for(int i=0; i<mod.getRowCount();i++)
			{
				boolean check=(Boolean) mod.getValueAt(i, 8);
				if(check)
				{
					Enseignant enseignant=ec.getEnseignant(email);
					int id=(int) mod.getValueAt(i, 9);
					int num=(int) mod.getValueAt(i, 10);
					Formation f=fc.getFormation(num);
					Session s=sc.getSession(id);
					Choix c=new Choix(enseignant,f,s,2);
					chc.AddChoix(c);
					JOptionPane.showMessageDialog(null, "Choix Valider");
				}
			}
		}
		
// Recuperer l'email depuis l'authentification
	public void setEmail(String email) {
		this.email = email;
	}

}
