package SAE.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.Toolkit;

public class Accueil {

	private JFrame frmPageDaccueil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frmPageDaccueil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static float getPrice(String str, String regex) {
		int euro = 0;
		float centimes = 0;
		
		// 1. Je separe la chaine de caractere en tableau (chaque element du tableau separer par la virgule).
		String temp[] = str.split(regex);
		
		// 2. Je recupere le dernier element du tableau (car il contient le prix).
		str = temp[temp.length-1];
		
		// 3. Je remplace chaque nombre non numerique par un espace.
		str = str.replaceAll("[^\\d]", " ");
		
		// 4. Je supprime les espace de debut et de fin.
		str = str.trim();
		
		// 5. Je remplace les espaces consecutifs par un seul espace.
		str = str.replaceAll(" +", " ");
		
		// 6. Je recupere les euros et les centimes.
		euro = Integer.parseInt(str.split(" ")[0]);
		centimes = Float.parseFloat(str.split(" ")[1]);
		
		// 7. Je calcule et retourne le prix.
		if (centimes > 10)
			return euro + (centimes / 100);
		
		return euro + (centimes / 10);
	}

	/**
	 * Create the application.
	 */
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageDaccueil = new JFrame();
		frmPageDaccueil.setIconImage(Toolkit.getDefaultToolkit().getImage(Accueil.class.getResource("fromage.png")));
		frmPageDaccueil.setTitle("Chromage");
		frmPageDaccueil.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmPageDaccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Box description fromage
		JOptionPane descFromageBox = new JOptionPane();
		
		JPanel panel_nord = new JPanel();
		frmPageDaccueil.getContentPane().add(panel_nord, BorderLayout.NORTH);
		panel_nord.setLayout(new BorderLayout(0, 0));
		
		JPanel logo = new JPanel();
		panel_nord.add(logo, BorderLayout.WEST);
		logo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon(Accueil.class.getResource("logo.png")));
		logo.add(lblNewLabel);
		
		JPanel menu = new JPanel();
		panel_nord.add(menu, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		menu.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("   Accueil   ");
        mnNewMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Accueil.main(null);
                frmPageDaccueil.dispose();
            }
        });
        mnNewMenu.setIcon(new ImageIcon(Accueil.class.getResource("accueil.png")));
        menuBar.add(mnNewMenu);
        
        JMenu mnNewMenu_1 = new JMenu("   Fromage   ");
        mnNewMenu_1.setIcon(new ImageIcon(Accueil.class.getResource("fromage.png")));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Vache");
        mntmNewMenuItem.setBackground(new Color(230, 230, 250));
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                new PageVache(new Panier());
                frmPageDaccueil.dispose();
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Chevre");
        mntmNewMenuItem_1.setBackground(new Color(255, 228, 225));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
               new PageChevre(new Panier());
                frmPageDaccueil.dispose();
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Brebis");
        mntmNewMenuItem_2.setBackground(new Color(255, 255, 224));
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                new PageBrebis(new Panier());
                frmPageDaccueil.dispose();
            }
        });
        
        mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("   Promotion   ");
		mnNewMenu_2.setIcon(new ImageIcon(Accueil.class.getResource("promotion.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("   Contact   ");
		mnNewMenu_3.setBackground(new Color(255, 255, 255));
		mnNewMenu_3.setIcon(new ImageIcon(Accueil.class.getResource("contact.png")));
		menuBar.add(mnNewMenu_3);
		
		/*JMenu mnNewMenu_4 = new JMenu("Vache");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PageVache.main(null);
			}
		});
		
		menuBar.add(mnNewMenu_4);*/
		
		JButton btnNewButton = new JButton("Compte");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Compte.main(null);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(Accueil.class.getResource("compte.png")));
		menu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Panier");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panier.main(null);
				frmPageDaccueil.dispose();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(Accueil.class.getResource("panier.png")));
		menu.add(btnNewButton_1);
		
		JPanel footer = new JPanel();
		frmPageDaccueil.getContentPane().add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		footer.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Contactez-nous");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nos engagements");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("La garantie fra\u00EEcheur");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Conditions G\u00E9n\u00E9rales de vente");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Exp\u00E9dition et livraison");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fabricants");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mention l\u00E9gales");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Mode de paiement");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Configurer les cookies");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_9);
		
		JPanel panel = new JPanel();
		frmPageDaccueil.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("La carte des fromages");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_10, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		List<Fromage> fromages = new ArrayList<Fromage>(GenerationFromages.generationBaseFromages().getLesFromages());
		
		List<String> designations = new ArrayList<String>();
		
		for (Fromage f : fromages) {
			designations.add(f.getDesignation());
		}
		
		JList list = new JList(designations.toArray());
		
		list.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent event) {
				// 1. Je recupere l'instance du fromage cliquer.
				Fromage currentFromage = fromages.get(list.getSelectedIndex());
				
				// 2. Je passe en le fromage courrant dans ma classe Description.
				Description.setFromage(currentFromage);
				
				// 3. J'appelle ma classe description;
				Description.main(null);
			}
		});
		
		
		scrollPane.setViewportView(list);
	}

}
