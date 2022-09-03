package InterfacesGraphic;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CrudServiceImp.EnseignantService;
import CrudServiceImp.OrganismeService;
import CrudServiceImp.ResponsableService;
import DemandeFormation.Enseignant;
import DemandeFormation.Responsable;
import Formation.Organisme;

	public class Login  {

		private JFrame frame;
		Connection c=null;
		private JTextField nom;
		private JPasswordField passwordField;
		JComboBox comboBox;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login window = new Login();
						window.frame.setVisible(true);
						window.frame.setResizable(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public Login() {
			initialize();
			frame.setVisible(true);
		}
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame("Authentification");
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ninou\\Desktop\\ProjetKouah\\Project\\Project\\img\\login.png"));
			frame.getContentPane().setBackground(new Color(0, 51, 51));
			frame.setBounds(100, 100, 569, 453);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\Ninou\\Desktop\\ProjetKouah\\Project\\Project\\img\\Login-icon.png"));
			label.setBounds(10, 11, 121, 97);
			frame.getContentPane().add(label);
			
			JLabel lblNewLabel = new JLabel("Nom Utilisateur (Email):");
			lblNewLabel.setEnabled(false);
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setFont(new Font("Viner Hand ITC", Font.ITALIC, 16));
			lblNewLabel.setBounds(35, 107, 215, 26);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel mdp = new JLabel("Mot de passe:");
			mdp.setEnabled(false);
			mdp.setFont(new Font("Viner Hand ITC", Font.ITALIC, 16));
			mdp.setBounds(139, 148, 96, 14);
			frame.getContentPane().add(mdp);
			
			nom = new JTextField();
			nom.setBounds(275, 96, 151, 27);
			frame.getContentPane().add(nom);
			nom.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setText("");
			passwordField.setBounds(275, 137, 151, 27);
			frame.getContentPane().add(passwordField);
			//Connection 
			JButton login = new JButton("Se connecter");
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//recuperer les données entrer par l'utilisateur
					String choix=comboBox.getSelectedItem().toString();
					String user=nom.getText();
					String psw=passwordField.getText();
					ResponsableService rs=new ResponsableService();
					OrganismeService os=new OrganismeService();
					EnseignantService es=new EnseignantService();
					//si c'est l'organisme
					if (choix.equalsIgnoreCase("Organisme"))
					{
						try {
							//on recupere l'utilisateur
							Organisme o=os.login(user, psw);
							//si il y'a 1 
							if (o != null){ 
							frame.dispose();
							//Ouvrir la fenetre de l'organisme
							AcceuilOrganisme ao=new AcceuilOrganisme();
							}
							// message d'erreur
							else {JOptionPane.showMessageDialog(null, "wrong email or password");}
						} catch (SQLException e1) {}	
					}
					//Si c'est 1 responsable (les memes etapes que l'organisme)
					else if (choix.equalsIgnoreCase("Responsable"))
					{
						try {
							Responsable r=rs.getUser(user, psw);
							if (r != null){frame.dispose(); ResponsableAcceuil ra=new ResponsableAcceuil();}
							else {JOptionPane.showMessageDialog(null, "wrong email or password");}
						} catch (SQLException | ClassNotFoundException e1) {}
					}
					//si c'est un enseignant (meme étapes)
					else if(choix.equalsIgnoreCase("Enseignant"))
					{
						try {
							Enseignant ens=es.login(user, psw);
							if(ens != null){
							AcceuilEnseignant lde=new AcceuilEnseignant(user);
							lde.setEmail(user);
							frame.dispose();
							}
							else {JOptionPane.showMessageDialog(null, "wrong email or password");}
						} catch (SQLException | ClassNotFoundException e1) {}
					}
				}
			});
			login.setIcon(new ImageIcon("C:\\Users\\Ninou\\Desktop\\ProjetKouah\\Project\\Project\\img\\ok.png"));
			login.setBounds(285, 175, 148, 33);
			frame.getContentPane().add(login);
			
			JLabel lblSiVousEtes = new JLabel("Si vous etes un nouveau enseignant cliquer sur la photo :p");
			lblSiVousEtes.setFont(new Font("Viner Hand ITC", Font.ITALIC, 16));
			lblSiVousEtes.setEnabled(false);
			lblSiVousEtes.setBounds(35, 229, 432, 26);
			frame.getContentPane().add(lblSiVousEtes);
			
			// Boutton pour sortir
			JButton quitter = new JButton("Quitter");
			quitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			quitter.setIcon(new ImageIcon("C:\\Users\\Ninou\\Desktop\\ProjetKouah\\Project\\Project\\img\\close.png"));
			quitter.setBounds(365, 370, 148, 33);
			frame.getContentPane().add(quitter);
			//Nouveau Enregistrement (nouveau enseignant)
			JButton button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					//Ouvrir la fenetre d'enregistrement
					EnregistrementEnseignant demande=new EnregistrementEnseignant();
				}
			});
			button.setIcon(new ImageIcon("C:\\Users\\Ninou\\Desktop\\ProjetKouah\\Project\\Project\\img\\Teacher.png"));
			button.setBounds(35, 266, 161, 137);
			frame.getContentPane().add(button);
			
			JLabel lblUtilisateur = new JLabel("Utilisateur:");
			lblUtilisateur.setFont(new Font("Viner Hand ITC", Font.ITALIC, 16));
			lblUtilisateur.setEnabled(false);
			lblUtilisateur.setBounds(154, 47, 96, 14);
			frame.getContentPane().add(lblUtilisateur);
			
			 comboBox = new JComboBox();
			String r="Responsable"; String o="Organisme"; String e="Enseignant";
			comboBox.addItem(o); comboBox.addItem(r); comboBox.addItem(e); 
			comboBox.setBounds(275, 43, 151, 20);
			frame.getContentPane().add(comboBox);
		}
	}


