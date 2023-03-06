package SAE.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Compte {

	private JFrame frmChro;
	public static JTextField adresse_1;
	public static JTextField adresse_2;
	public static JTextField code_postal;
	public static JTextField ville;
	public static JTextField prenom;
	public static JTextField telephone;
	public static JTextField nom;
	public static JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compte window = new Compte();
					window.frmChro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Compte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChro = new JFrame();
		frmChro.setIconImage(Toolkit.getDefaultToolkit().getImage(Compte.class.getResource("fromage.png")));
		frmChro.setTitle("Chromage");
		frmChro.getContentPane().setBackground(new Color(255, 255, 240));
		frmChro.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 374, 635);
		frmChro.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Compte.class.getResource("chromagebis.png")));
		
		adresse_1 = new JTextField();
		adresse_1.setBounds(443, 257, 230, 19);
		frmChro.getContentPane().add(adresse_1);
		adresse_1.setColumns(10);
		
		adresse_2 = new JTextField();
		adresse_2.setColumns(10);
		adresse_2.setBounds(443, 309, 230, 19);
		frmChro.getContentPane().add(adresse_2);
		
		code_postal = new JTextField();
		code_postal.setColumns(10);
		code_postal.setBounds(443, 361, 230, 19);
		frmChro.getContentPane().add(code_postal);
		
		ville = new JTextField();
		ville.setColumns(10);
		ville.setBounds(443, 413, 230, 19);
		frmChro.getContentPane().add(ville);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(443, 153, 230, 19);
		frmChro.getContentPane().add(prenom);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(443, 465, 230, 19);
		frmChro.getContentPane().add(telephone);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(443, 205, 230, 19);
		frmChro.getContentPane().add(nom);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(443, 517, 230, 19);
		frmChro.getContentPane().add(email);
		
		JLabel lblNewLabel = new JLabel("Prenom :");
		lblNewLabel.setBounds(443, 130, 68, 13);
		frmChro.getContentPane().add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(443, 182, 68, 13);
		frmChro.getContentPane().add(lblNom);
		
		JLabel lblAdresse = new JLabel("Adresse 1 :");
		lblAdresse.setBounds(443, 234, 87, 13);
		frmChro.getContentPane().add(lblAdresse);
		
		JLabel lblAdresse_1 = new JLabel("Adresse 2 :");
		lblAdresse_1.setBounds(443, 286, 87, 13);
		frmChro.getContentPane().add(lblAdresse_1);
		
		JLabel lblCodePostal = new JLabel("Code Postal :");
		lblCodePostal.setBounds(443, 338, 98, 13);
		frmChro.getContentPane().add(lblCodePostal);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(443, 390, 45, 13);
		frmChro.getContentPane().add(lblVille);
		
		JLabel lblTlphone = new JLabel("Telephone :");
		lblTlphone.setBounds(443, 442, 87, 13);
		frmChro.getContentPane().add(lblTlphone);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(443, 494, 45, 13);
		frmChro.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Informations client");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_1.setBounds(432, 38, 281, 45);
		frmChro.getContentPane().add(lblNewLabel_1);
		
		Button button_1 = new Button("Annuler ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmChro.dispose();
			}
			
		});
		button_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		button_1.setBackground(new Color(255, 228, 225));
		button_1.setBounds(589, 558, 116, 36);
		frmChro.getContentPane().add(button_1);
		frmChro.setBounds(100, 100, 800, 656);
		frmChro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Button button = new Button(" Valider  ");
		button.setFont(new Font("Dialog", Font.PLAIN, 13));
		button.setBackground(new Color(255, 228, 225));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facture.main(null);
			}
		});
		button.setBounds(432, 558, 116, 36);
		frmChro.getContentPane().add(button);
	}
}
