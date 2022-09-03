package InterfacesGraphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.TableModel;

import CrudServiceImp.DemandeCrud;
import CrudServiceImp.DemandeService;
import CrudServiceImp.EnseignantCrud;
import CrudServiceImp.FormationCrud;
import DemandeFormation.Demande;
import DemandeFormation.Enseignant;
import Formation.Formation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.JPasswordField;

public class EnregistrementEnseignant {

	private JFrame frame;
	private JTextField nom;
	private JTextField prenom;
	private JTextField adress;
	private JTextField email;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnregistrementEnseignant window = new EnregistrementEnseignant();
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
	public EnregistrementEnseignant() {
		initialize();
		frame.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Acceuil Enseignant");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Ninou\\Desktop\\ProjetKouah\\Project\\Project\\img\\enseignant.png"));
		frame.setBounds(100, 100, 464, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ninou\\Desktop\\ProjetKouah\\Project\\Project\\img\\welcome-icon.png"));
		label.setBounds(322, 7, 128, 103);
		frame.getContentPane().add(label);
		
		JLabel lblBienvenu = new JLabel("BIENVENU ");
		lblBienvenu.setFont(new Font("Segoe Script", Font.BOLD, 30));
		lblBienvenu.setBounds(24, 11, 185, 49);
		frame.getContentPane().add(lblBienvenu);
		
		JLabel lblConsulterVosDemandes = new JLabel("Veuillez remplir les champs suivants s'il vous plait");
		lblConsulterVosDemandes.setBounds(24, 71, 289, 14);
		frame.getContentPane().add(lblConsulterVosDemandes);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(24, 96, 46, 14);
		frame.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom:");
		lblPrenom.setBounds(24, 121, 74, 14);
		frame.getContentPane().add(lblPrenom);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(24, 152, 46, 14);
		frame.getContentPane().add(lblAdress);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(24, 186, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		nom = new JTextField();
		nom.setBounds(108, 96, 200, 20);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(108, 123, 200, 20);
		frame.getContentPane().add(prenom);
		
		adress = new JTextField();
		adress.setColumns(10);
		adress.setBounds(108, 152, 200, 20);
		frame.getContentPane().add(adress);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(108, 180, 200, 20);
		frame.getContentPane().add(email);
		//Boutton d'enregistrement
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Appel a la classe crud enseignant
			EnseignantCrud ec=new EnseignantCrud();
			//Recuperer les données saisie par le nouveau enseignant
			Enseignant ens=new Enseignant();
			if(!nom.getText().isEmpty() && !prenom.getText().isEmpty() && !adress.getText().isEmpty() && !email.getText().isEmpty() && !password.getText().isEmpty())
			{
			ens.setAdress(adress.getText());
			ens.setEmail(email.getText());
			ens.setNom(nom.getText());
			ens.setPassword(password.getText());
			ens.setPrenom(prenom.getText());
			try {
				//Ajouter de l'enseignant
				ec.AddEnseignant(ens);
				JOptionPane.showMessageDialog(null, "Enregistrement avec succés");
				frame.dispose();
				//la fenetre d'authentification
				Login log=new Login();
			} catch (ClassNotFoundException | SQLException e1) {
			}	
			}
			else {JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");}
			
			}
		});
		btnEnregistrer.setBounds(198, 236, 115, 23);
		frame.getContentPane().add(btnEnregistrer);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(24, 211, 74, 14);
		frame.getContentPane().add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(108, 205, 200, 20);
		frame.getContentPane().add(password);
	}
}
