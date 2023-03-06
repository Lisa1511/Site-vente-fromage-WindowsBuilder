package SAE.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.event.ChangeListener;


import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
 
public class PageChevre {

	private JFrame frmChevre;
	private JTextField inputPrix;
	private JTextField searchBarInput;
	private JPanel panelPrixInput;
	private List<Fromage> fromages = new ArrayList<Fromage>(GenerationFromages.generationBaseFromages().getLesFromages());
	private List<Fromage> fromagesChevre = new ArrayList<Fromage>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PageChevre(new Panier());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PageChevre(Panier panier) {
		initialize(panier);
		frmChevre.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Panier panier) {
		
		
		for (Fromage f : fromages) {
			if (f.getTypeFromage() == TypeLait.CHEVRE) {
				fromagesChevre.add(f);
			}
		}
		
		frmChevre = new JFrame();
		frmChevre.setIconImage(Toolkit.getDefaultToolkit().getImage(PageChevre.class.getResource("logo.png")));
		frmChevre.setTitle("Chevre");
		frmChevre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmChevre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChevre.getContentPane().setLayout(new BorderLayout(25, 10));
		
		//NORTH
		
		JPanel panel_nord = new JPanel();
		frmChevre.getContentPane().add(panel_nord, BorderLayout.NORTH);
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
                new PageVache(panier);
                frmChevre.dispose();
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Chevre");
        mntmNewMenuItem_1.setBackground(new Color(255, 228, 225));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
               new PageChevre(panier);
               frmChevre.dispose();
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Brebis");
        mntmNewMenuItem_2.setBackground(new Color(255, 255, 224));
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                new PageBrebis(panier);
                frmChevre.dispose();
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
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(Accueil.class.getResource("panier.png")));
		menu.add(btnNewButton_1);
		
	
		//WEST
		
		JScrollPane scrollMenu = new JScrollPane();
		frmChevre.getContentPane().add(scrollMenu, BorderLayout.WEST);
		
		JPanel panelSearchMenu = new JPanel();
		scrollMenu.setViewportView(panelSearchMenu);
		panelSearchMenu.setLayout(new GridLayout(0, 1, 5, 0));
		
		JPanel panelSearchBar = new JPanel();
		panelSearchMenu.add(panelSearchBar);
		FlowLayout fl_panelSearchBar = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelSearchBar.setLayout(fl_panelSearchBar);
		
		JButton searchButton = new JButton("Search");
		//searchButton.setIcon(new ImageIcon(PageChevre.class.getResource("/Image/icons/3936854_creanimasi_pencarian_searching_search.png")));
		
		panelSearchBar.add(searchButton);
		
		searchBarInput = new JTextField();
		panelSearchBar.add(searchBarInput);
		searchBarInput.setColumns(10);
		
		JLabel labelFiltres = new JLabel("Filtres :");
		labelFiltres.setHorizontalAlignment(SwingConstants.CENTER);
		panelSearchMenu.add(labelFiltres);
		
		JPanel panelPrixMax = new JPanel();
		panelSearchMenu.add(panelPrixMax);
		panelPrixMax.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelPrixText = new JPanel();
		panelPrixMax.add(panelPrixText);
		panelPrixText.setLayout(new BorderLayout(0, 0));
		JLabel labelPrix = new JLabel("Prix Maximum :");
		panelPrixText.add(labelPrix, BorderLayout.WEST);
		
		panelPrixInput = new JPanel();
		panelPrixText.add(panelPrixInput, BorderLayout.EAST);
		FlowLayout fl_panelPrixInput = new FlowLayout(FlowLayout.CENTER, 30, 15);
		panelPrixInput.setLayout(fl_panelPrixInput);
		float PRIX_MAX = fromagesChevre.get(0).getArticles().get(0).getPrixTTC();
		float PRIX_MIN = fromagesChevre.get(0).getArticles().get(0).getPrixTTC();
		for (Fromage f : fromagesChevre) {
			if (PRIX_MAX < f.getArticles().get(0).getPrixTTC()) {
				PRIX_MAX = f.getArticles().get(0).getPrixTTC();
			}
			if (PRIX_MIN > f.getArticles().get(0).getPrixTTC()) {
				PRIX_MIN = f.getArticles().get(0).getPrixTTC();
			}
		}
		inputPrix = new JTextField();
		inputPrix.setHorizontalAlignment(SwingConstants.LEFT);
		inputPrix.setColumns(10);
		inputPrix.setText(String.valueOf(PRIX_MAX));
		panelPrixInput.add(inputPrix);
		
		JPanel panelPrixMaxSlider = new JPanel();
		panelPrixMaxSlider.setLayout(new GridLayout(0, 1, 0, 0));
		panelSearchMenu.add(panelPrixMaxSlider);
		
		JSlider sliderPrix = new JSlider();
		sliderPrix.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				inputPrix.setText(String.valueOf(sliderPrix.getValue()));
			}
		});
		inputPrix.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				sliderPrix.setValue(Integer.parseInt(inputPrix.getText()));
			}
		});
		
		sliderPrix.setValue((((int) PRIX_MAX/10) * 10) + 10);
		sliderPrix.setMaximum((((int) PRIX_MAX/10) * 10) + 10);
		sliderPrix.setMinorTickSpacing(1);
		sliderPrix.setMajorTickSpacing(10);
		sliderPrix.setMinimum((((int) PRIX_MIN / 5) * 5) + 5);
		panelPrixMaxSlider.add(sliderPrix);
		
		JPanel panelOccasion = new JPanel();
		panelSearchMenu.add(panelOccasion);
		panelOccasion.setLayout(new GridLayout(0, 1, 0, 0));
		
		ArrayList<TypeOccasion> wantedOccasion = new ArrayList<TypeOccasion>();
		
		JLabel labelOccasion = new JLabel("Occasion :");
		panelOccasion.add(labelOccasion);
		
		for (int i = 0 ; i < TypeOccasion.getAllOccasions().size(); i++) {
			JPanel panelOccasionCB = new JPanel();
			panelOccasionCB.setLayout(new GridLayout(0, 1, 0, 0));
			panelSearchMenu.add(panelOccasionCB);
			final int i2 = i;
			JCheckBox checkBoxOccasion = new JCheckBox(String.valueOf(TypeOccasion.getAllOccasions().get(i).getTypeOccasion()));
			checkBoxOccasion.setPreferredSize(new Dimension(panelPrixMax.getWidth() - 10, checkBoxOccasion.getHeight()));
			checkBoxOccasion.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (checkBoxOccasion.isSelected()) {
						wantedOccasion.add(TypeOccasion.getAllOccasions().get(i2));
					} else {
						wantedOccasion.remove(wantedOccasion.indexOf(TypeOccasion.getAllOccasions().get(i2)));
					}
				}
			});
			panelOccasionCB.add(checkBoxOccasion);
		}
		
		JPanel panelPate = new JPanel();
		panelSearchMenu.add(panelPate);
		panelPate.setLayout(new GridLayout(0, 1, 5, 0));
		
		JLabel labelPate = new JLabel("Choix de la pâte :");
		panelPate.add(labelPate);
		
		ArrayList<TypePate> wantedPate = new ArrayList<TypePate>();
		
		for (int i = 0 ; i < TypePate.getAllPate().size(); i++) {
			JPanel panelPateCB = new JPanel();
			panelPateCB.setLayout(new GridLayout(0, 1, 0, 0));
			panelSearchMenu.add(panelPateCB);
			final int i2 = i;
			JCheckBox checkBoxPate = new JCheckBox(String.valueOf(TypePate.getAllPate().get(i).getTypePate()));
			checkBoxPate.setPreferredSize(new Dimension(panelPrixMax.getWidth() - 10, checkBoxPate.getHeight()));
			checkBoxPate.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (checkBoxPate.isSelected()) {
						wantedPate.add(TypePate.getAllPate().get(i2));
					} else {
						wantedPate.remove(wantedPate.indexOf(TypePate.getAllPate().get(i2)));
					}
				}
			});
			panelPateCB.add(checkBoxPate);
		}
		
		
		
		//CENTER
		
		JScrollPane scrollFromages = new JScrollPane();
		scrollFromages.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frmChevre.getContentPane().add(scrollFromages, BorderLayout.CENTER);
		
		JPanel panelFromages = new JPanel();
		scrollFromages.setViewportView(panelFromages);
		panelFromages.setLayout(new GridLayout(0, 4, 20, 20));
		
		genererCartesFromage(panelFromages, sliderPrix.getValue(), searchBarInput.getText(), wantedOccasion, wantedPate, panier);
		
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelFromages.removeAll();
				panelFromages.repaint();
				genererCartesFromage(panelFromages, sliderPrix.getValue(), searchBarInput.getText(), wantedOccasion, wantedPate, panier);
			}
		});
		
		//SOUTH
		
		JPanel footer = new JPanel();
		frmChevre.getContentPane().add(footer, BorderLayout.SOUTH);
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
		
	}
	
	
	public boolean isFromageWanted(Fromage f, int prixMax, String searchedWord, ArrayList<TypeOccasion> wantedOccasion, ArrayList<TypePate> wantedPate) {
		Article fArticle = f.getFArticle();
		if (fArticle == null) {
			return false;
		}
		
		if (fArticle.getPrixTTC() > prixMax) {
				return false;
		}
		
		if (!(f.getDescription().toLowerCase().contains(searchedWord.toLowerCase()) ||
			 (f.getDesignation().toLowerCase().contains(searchedWord.toLowerCase())))) {
			return false;
		}
		
		if (wantedOccasion.size() > 0) {
			ArrayList<TypeOccasion> fOccasions = new ArrayList<TypeOccasion>();
			for(TypeOccasion o: f.getOccasion()) {
		         fOccasions.add(o);
		      }

			for (TypeOccasion o : wantedOccasion) {
				if (!fOccasions.contains(o)) {
					return false;
				}
			}
			
		
		if (wantedPate.size() > 0) {
			if (!wantedPate.contains(f.getPate())) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void genererCartesFromage(JPanel p, int prixMax, String searchedWord, ArrayList<TypeOccasion> wantedOccasions, ArrayList<TypePate> wantedPate, Panier panier){
		int nbCases = 0;
		//Creation des carte presentant les fromages
		for (int i = 0; i < fromagesChevre.size(); i ++) {
			final Article fArticle = fromagesChevre.get(i).getFArticle();
			if (isFromageWanted(fromagesChevre.get(i), prixMax, searchedWord, wantedOccasions, wantedPate)) {		
				nbCases = nbCases + 1;
				//Creation du panel contenant la carte
				JPanel carteFromage = new JPanel();
				carteFromage.setBorder(new LineBorder(new Color(0, 0, 0)));
				p.add(carteFromage);
				
				
				
				//Creation de l'image du fromage
				ImageIcon iconFromage = new ImageIcon(PageChevre.class.getResource("/fromage/fromage"+String.valueOf(i%9)+".jpg"));
				Image scaledIconFromage = iconFromage.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
				
				JLabel imgFromage = new JLabel("");
				imgFromage.setIcon(new ImageIcon(scaledIconFromage));
				imgFromage.setHorizontalAlignment(SwingConstants.CENTER);
			
				//panel d'information sur le fromage
				JPanel panelInfoFromage = new JPanel();
				panelInfoFromage.setLayout(new GridLayout(0, 1, 0, 0));
				
				JLabel nameFromage = new JLabel("<html>" + fromagesChevre.get(i).getDesignation() + "</html>");
				nameFromage.setFont(new Font("Calibri", Font.PLAIN, 20));
				nameFromage.setPreferredSize(new Dimension(carteFromage.getWidth() - 10, nameFromage.getHeight()));
				nameFromage.setHorizontalAlignment(SwingConstants.CENTER);
				
				JPanel panelNote = new JPanel();
			

				final int i2 = i;
				JButton buttonAddFromage = new JButton("Ajouter au panier");
				buttonAddFromage.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						new PopUpWindowAjouterPanier(fromagesChevre.get(i2), panier, "/fromage/fromage"+String.valueOf(i2%9)+".jpg");
					}
				});
				
				
				JTextField tFieldPrice = new JTextField();
				tFieldPrice.setEditable(false);
				tFieldPrice.setHorizontalAlignment(SwingConstants.CENTER);
				tFieldPrice.setText(String.valueOf(fArticle.getPrixTTC()) + "€");
				tFieldPrice.setColumns(10);
				tFieldPrice.setBorder(null);
				tFieldPrice.setFont(new Font("Calibri", Font.BOLD, 20));
				tFieldPrice.setMaximumSize(new Dimension(tFieldPrice.getHeight(), carteFromage.getWidth() - 10));
				tFieldPrice.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						imgFromage.setIcon(null);
						imgFromage.setText("<html>" + fromagesChevre.get(i2).getDescription() + "</html>");
						imgFromage.setPreferredSize(new Dimension(carteFromage.getWidth() - 10, (int) (carteFromage.getWidth() * 1)));
					}
				@Override
					public void mouseExited(MouseEvent e) {
						imgFromage.setIcon(new ImageIcon(scaledIconFromage));
						imgFromage.setText(null);
					}
				});
				
				carteFromage.setLayout(new GridLayout(0, 1, 0, 0));
				carteFromage.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						imgFromage.setIcon(null);
						imgFromage.setText("<html>" + fromagesChevre.get(i2).getDescription() + "</html>");
						imgFromage.setPreferredSize(new Dimension(carteFromage.getWidth() - 10, (int) (carteFromage.getWidth() * 1)));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						imgFromage.setIcon(new ImageIcon(scaledIconFromage));
						imgFromage.setText(null);
					}
				});
				carteFromage.add(imgFromage);
				carteFromage.add(panelInfoFromage);
				panelInfoFromage.add(nameFromage);
				panelInfoFromage.add(tFieldPrice);
				panelInfoFromage.add(panelNote);
					for (int j = 0; j < fromagesChevre.get(i).getNote(); j++) {
						JLabel labelStarIcon = new JLabel();
						ImageIcon iconNoteJ = new ImageIcon(PageChevre.class.getResource("/starIcon/star"+ (j + 1) +".png"));
						Image scaledNoteJ = iconNoteJ.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
							
						labelStarIcon.setIcon(new ImageIcon(scaledNoteJ));
						
						panelNote.add(labelStarIcon);
					}
				panelInfoFromage.add(buttonAddFromage);
			}
		}
		
		for (int i = nbCases; i < (4)*2; i++) {
			JPanel emptyCarteFromage = new JPanel();
			p.add(emptyCarteFromage);
			JLabel imgFromage = new JLabel("");
			imgFromage.setIcon(new ImageIcon(PageChevre.class.getResource("/Image/filler.png")));
			emptyCarteFromage.add(imgFromage);
		
		}
		
		return;
	}
}
