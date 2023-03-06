package SAE.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.Toolkit;

public class Panier {

	private JFrame frmChromage;
	private JTable table;
	private JPanel Tableau;
	DefaultTableModel model;
	
	private static int MAX_SIZE = 10;
	private static int COLUMN = 5;
	private static int i = 0;
	
	private static float total = 0f;
	private static float frais = 0f;
	
	private static Object[][] panier = new Object[MAX_SIZE][COLUMN];
	
	public static String filtre(float x) {
		return new DecimalFormat("#.##").format(x).toString();
	}
	
	public static String[] showPanier() {
		String[] articles = new String[i];
		for (int j = 0; j < i; j++) {
			Object[] article = panier[j];
			articles[j] = "[" + (j+1) + "] Nom de l'article \t\t: " + article[0] + "\n"
					+ "[" + (j+1) + "] Prix de l'article \t\t: " + article[1] + "\n"
					+ "[" + (j+1) + "] Quantite de l'article \t\t: " + article[2] + "\n"
					+ "[" + (j+1) + "] Prix total \t\t\t: " + article[3] + "\n"
			;
		}
		
		return articles;
	}
	
	public static void chargementDuPanier() {
		if (i == 0) {
			panier[i][0] = "Produit";
			panier[i][1] = "Prix";
			panier[i][2] = "Quantite";
			panier[i++][3] = "Prix Total";
		}
		
		panier[i][2] = "";
		panier[i+1][2] = "Sous Total TTC";
		panier[i+2][2] = "Frais de port";
		panier[i+3][2] = "Total TTC";
		
		panier[i][3] = "";
		panier[i+1][3] = filtre(total) + "€";
		panier[i+2][3] = frais + "€";
		panier[i+3][3] = filtre(total + frais) + "€";
	}
	
	public static void ajouterAuPanier(String name, int quantite, float price) {
		if (!(i < MAX_SIZE - COLUMN)) return;
		
		panier[i][0] = name;
		panier[i][1] = filtre(price) + "€";
		panier[i][2] = quantite;
		panier[i++][3] = filtre(price * quantite) + "€";
		
		total += price * quantite;
		
		if (total >= 100)
			frais = 0;
		
		chargementDuPanier();
		
	}
	
	private static void editFrais(String str) {
		
		if (total < 100)
			frais = Accueil.getPrice(str, " ");
		
		chargementDuPanier();

	}
	
	public static float getFrais() {
		return frais;
	}
	
	public static float getTotal() {
		return total;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panier window = new Panier();
					window.frmChromage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void clearTable() {
		panier = new Object[MAX_SIZE][COLUMN];
		i = 0;
		total = 0;
		chargementDuPanier();
	}
	
	private void loadTable() {
		Tableau.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		table.setModel(new DefaultTableModel(
			panier,
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		Tableau.add(table);
	}

	/**
	 * Create the application.
	 */
	public Panier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChromage = new JFrame();
		frmChromage.setIconImage(Toolkit.getDefaultToolkit().getImage(Panier.class.getResource("fromage.png")));
		frmChromage.setTitle("Chromage");
		frmChromage.setBounds(100, 100, 913, 509);
		
		JPanel panel = new JPanel();
		frmChromage.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel menu = new JPanel();
		panel.add(menu, BorderLayout.CENTER);
		menu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		menu.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Accueil");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accueil.main(null);
			}
		});
		mnNewMenu.setIcon(new ImageIcon(Panier.class.getResource("accueil.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Fromage");
		mnNewMenu_1.setIcon(new ImageIcon(Panier.class.getResource("fromage.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Vache");
		mntmNewMenuItem.setBackground(new Color(230, 230, 250));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Brebis");
		mntmNewMenuItem_1.setBackground(new Color(255, 228, 225));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Chevre");
		mntmNewMenuItem_2.setBackground(new Color(255, 255, 224));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Promotion");
		mnNewMenu_2.setIcon(new ImageIcon(Panier.class.getResource("promotion.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Contact");
		mnNewMenu_3.setIcon(new ImageIcon(Accueil.class.getResource("contact.png")));
		menuBar.add(mnNewMenu_3);
		
		JButton btnNewButton = new JButton("Compte");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Compte.main(null);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Panier.class.getResource("compte.png")));
		menu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Panier");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panier.main(null);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(Panier.class.getResource("panier.png")));
		menu.add(btnNewButton_1);
		
		JPanel logo = new JPanel();
		panel.add(logo, BorderLayout.WEST);
		logo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Panier.class.getResource("logo.png")));
		logo.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("Votre panier");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 36));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_10);
		
		JPanel footer = new JPanel();
		frmChromage.getContentPane().add(footer, BorderLayout.SOUTH);
		footer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		footer.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Contactez-nous");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nos engagements");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("La garantie fraÃ®cheur");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Conditions Generales");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Expedition et livraison");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fabricants");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mention legales");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mode de paiement");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Configurer les cookies");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_9);
		
		JPanel panel_2 = new JPanel();
		frmChromage.getContentPane().add(panel_2, BorderLayout.CENTER);
		model=new DefaultTableModel();
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Tableau = new JPanel();
		panel_2.add(Tableau, BorderLayout.NORTH);
		table = new JTable();
		
		JPanel Livraison = new JPanel();
		panel_2.add(Livraison, BorderLayout.CENTER);
		Livraison.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("Choix de livraison :");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		Livraison.add(lblNewLabel_11);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Colissimo Point Relais 4,9â‚¬");
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton.setSelected(true);
		editFrais(rdbtnNewRadioButton.getText());
		Livraison.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Colissimo Ã  domicile 4,9â‚¬");
		Livraison.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Chronopost 9,9â‚¬");
		rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.TOP);
		Livraison.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton.addActionListener(event -> {
			editFrais(rdbtnNewRadioButton.getText());
			rdbtnNewRadioButton.setSelected(true);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
			loadTable();
		});
		
		rdbtnNewRadioButton_1.addActionListener(event -> {
			editFrais(rdbtnNewRadioButton_1.getText());
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(true);
			rdbtnNewRadioButton_2.setSelected(false);
			loadTable();
		});
		
		rdbtnNewRadioButton_2.addActionListener(event -> {
			editFrais(rdbtnNewRadioButton_2.getText());
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(true);
			loadTable();
		});
		
		loadTable();
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Valider le panier");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Compte.main(null);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Vider le panier");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(event -> {
			clearTable();
			loadTable();
		});
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Continuer les achats");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accueil.main(null);
			}
		});
		panel_3.add(btnNewButton_5);
	}
}
