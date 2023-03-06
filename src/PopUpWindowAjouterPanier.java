package SAE.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpWindowAjouterPanier {

	private JFrame frame;
	private JLabel descriptionFromage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					PopUpWindowAjouterPanier window = new PopUpWindowAjouterPanier(new Fromage("le fromage"), new Panier());
			} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PopUpWindowAjouterPanier(Fromage f, Panier panier, String image) {
		initialize(f, panier, image);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Fromage f, Panier panier, String image) {
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 548);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelTitleAndImage = new JPanel();
		frame.getContentPane().add(panelTitleAndImage);
		panelTitleAndImage.setLayout(new BorderLayout(0, 0));

		JPanel panelNomFromage = new JPanel();
		panelTitleAndImage.add(panelNomFromage, BorderLayout.NORTH);
		panelNomFromage.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel spaceFiller = new JPanel();
		panelNomFromage.add(spaceFiller);
		
		JLabel labelNomFromage = new JLabel(f.getDesignation());
		labelNomFromage.setHorizontalAlignment(SwingConstants.CENTER);
		labelNomFromage.setFont(new Font("Calibri", Font.BOLD, 20));
		panelNomFromage.add(labelNomFromage);
		
		JLabel imageFromage = new JLabel("");
		ImageIcon iconFromage = new ImageIcon(PageVache.class.getResource(image));
		Image scaledIconFromage = iconFromage.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		
		imageFromage.setIcon(new ImageIcon(scaledIconFromage));
		imageFromage.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitleAndImage.add(imageFromage, BorderLayout.CENTER);
		
		JPanel panelDescAndAjout = new JPanel();
		frame.getContentPane().add(panelDescAndAjout);
		panelDescAndAjout.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelDescription = new JPanel();
		panelDescAndAjout.add(panelDescription);
		
		descriptionFromage = new JLabel();
		descriptionFromage.setText("<html>" + f.getDescription() + "</html>");
		panelDescription.add(descriptionFromage);
		descriptionFromage.setPreferredSize(new Dimension(frame.getWidth() - 50, (int) (frame.getWidth() / 5)));
		
		JPanel panelAjoutEtValider = new JPanel();
		panelDescAndAjout.add(panelAjoutEtValider);
		panelAjoutEtValider.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelQuantiteeEtArticle = new JPanel();
		panelAjoutEtValider.add(panelQuantiteeEtArticle);
		panelQuantiteeEtArticle.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelChoix = new JPanel();
		panelQuantiteeEtArticle.add(panelChoix);
		
		JLabel labelArticle = new JLabel("Article : ");
		labelArticle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(labelArticle);
		
		JComboBox<Article> comboArticle = new JComboBox<Article>();
		panelChoix.add(comboArticle);

		Article[] signatureArray = new Article[f.getArticles().size()];
		comboArticle.setModel(new DefaultComboBoxModel<Article>((f.getArticles().toArray(signatureArray))));
		
		JLabel labelQuantitee = new JLabel("Quantitee : ");
		labelQuantitee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelChoix.add(labelQuantitee);
		
		JSpinner spinnerQuantitee = new JSpinner();
		
		spinnerQuantitee.setModel(new SpinnerNumberModel(1, 1, ((Article) comboArticle.getSelectedItem()).getQuantiteEnStock() , 1));
		panelChoix.add(spinnerQuantitee);
		
		JLabel labelPrix = new JLabel(String.valueOf(((Article) comboArticle.getSelectedItem()).getPrixTTC() * ((int) spinnerQuantitee.getValue())) 
				+ "€");
		labelPrix.setVerticalAlignment(SwingConstants.TOP);
		labelPrix.setFont(new Font("Calibri", Font.BOLD, 30));
		labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
		panelQuantiteeEtArticle.add(labelPrix);
		
		spinnerQuantitee.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				labelPrix.setText(String.valueOf(((Article) comboArticle.getSelectedItem()).getPrixTTC() * ((int) spinnerQuantitee.getValue())) + "€");
			}
		});
		comboArticle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				labelPrix.setText(String.valueOf(((Article) comboArticle.getSelectedItem()).getPrixTTC() * ((int) spinnerQuantitee.getValue())) + "€");
			}
		});
		
		JPanel panelValider = new JPanel();
		panelAjoutEtValider.add(panelValider);
		
		JButton buttonAnnuler = new JButton("retour");
		buttonAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		buttonAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelValider.add(buttonAnnuler);
		JButton buttonValider = new JButton("Ajouter au panier");
		buttonValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Article article = (Article) comboArticle.getSelectedItem();
				Panier.ajouterAuPanier(article.getFromage().getDesignation(), (int) spinnerQuantitee.getValue(), article.getPrixTTC());
				frame.dispose();
			}
		});
		buttonValider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelValider.add(buttonValider);
	}

}
