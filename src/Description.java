package SAE.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Description {

	private JFrame frmDesc;

	private static Fromage fromage;
	
	public static void setFromage(Fromage fromage) {
		Description.fromage = fromage;
	}
	
	private static Article[] getArticles() {
		int size = fromage.getArticles().size();
		Article[] articles = new Article[size];
		
		for (int i = 0; i < size; i++) {
			articles[i] = fromage.getArticles().get(i);
		}
		
		return articles;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Description window = new Description();
					window.frmDesc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Description() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDesc = new JFrame();
		frmDesc.setIconImage(Toolkit.getDefaultToolkit().getImage(Description.class.getResource("fromage.png")));
		frmDesc.setTitle("Chromage");
		frmDesc.setBounds(100, 100, 450, 300);
		
		JTextPane textPane = new JTextPane();
		frmDesc.getContentPane().add(textPane, BorderLayout.CENTER);
		
		textPane.setText(fromage.getDescription());
		textPane.setEditable(false);
		
		JPanel panelButtons = new JPanel();
		frmDesc.getContentPane().add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new GridLayout(2, 2, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(getArticles()));
		panelButtons.add(comboBox);

		JPanel panel_1 = new JPanel();
		panelButtons.add(panel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, ((Article) comboBox.getSelectedItem()).getQuantiteEnStock(), 1));
		panel_1.add(spinner);
		
		JButton ajouterAuPanier = new JButton("Ajouter au Panier");
		ajouterAuPanier.setBackground(Color.WHITE);
		panelButtons.add(ajouterAuPanier);
		ajouterAuPanier.addActionListener(event -> {
			float price = Accueil.getPrice(comboBox.getSelectedItem().toString(), ",");
			Panier.ajouterAuPanier(fromage.getDesignation(), Integer.parseInt(spinner.getValue().toString()), price);
			Panier.main(null);
		});
		
		JButton annuler = new JButton("Annuler");
		annuler.setBackground(Color.WHITE);
		panelButtons.add(annuler);
		annuler.addActionListener(event -> {
			frmDesc.dispose();
		});
	}

}
