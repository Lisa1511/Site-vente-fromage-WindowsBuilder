package SAE.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollBar;

public class Facture {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facture window = new Facture();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Facture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 903, 731);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(230, 230, 250)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel Info_client = new JPanel();
		Info_client.setBackground(new Color(255, 255, 224));
		Info_client.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(230, 230, 250)));
		Info_client.setBounds(106, 135, 257, 156);
		panel.add(Info_client);
		Info_client.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 10, 237, 136);
		textPane.setText("Nom :" + Compte.nom.getText() + "\n"
		+ "Prenom :" + Compte.prenom.getText() + "\n"
		+ "Adresse 1 :" + Compte.adresse_1.getText() + "\n"
		+ "Adresse 2 :" + Compte.adresse_2.getText() + "\n"
		+ "Code Postal :" + Compte.code_postal.getText() + "\n"
		+ "Ville :" + Compte.ville.getText() + "\n"
		+ "Telephone :" + Compte.telephone.getText() + "\n"
		+ "E-mail :" + Compte.email.getText() + "\n");
		Info_client.add(textPane);
		
		JPanel facture = new JPanel();
		facture.setBackground(new Color(255, 255, 224));
		facture.setBorder(new MatteBorder(14, 14, 14, 14, (Color) new Color(230, 230, 250)));
		facture.setBounds(106, 328, 688, 277);
		panel.add(facture);
		facture.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(10, 10, 668, 257);
		textPane_1.setText("");
		for (int i = 0; i < Panier.showPanier().length; i++) {
			textPane_1.setText(textPane_1.getText() + Panier.showPanier()[i] + "\n");
		}
		facture.add(textPane_1);
		
		JLabel lblNewLabel = new JLabel("Fromagerie Chromage pour vous servir et resservir en fromages");
		lblNewLabel.setBounds(285, 72, 322, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Recapitulatif commande :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(106, 301, 183, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vous remerciant de votre confiance, la fromagerie Chromage.");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(258, 615, 448, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Chromage");
		lblNewLabel_3.setIcon(new ImageIcon(Facture.class.getResource("chromage.png")));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(298, 21, 308, 47);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Informations client :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(106, 111, 889, 24);
		panel.add(lblNewLabel_4);
	}
}
