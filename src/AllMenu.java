import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Une classe pour gérer le contenu de notre  application
 * 
 * @author Djessa
 *
 */
public class AllMenu extends JPanel{
	//Propriete de notre conteneur
	private ImageIcon bg;
	private Image imBg;
	public JButton btn_new_menu;
	private JLabel plat_label;
	private JLabel entree_label;
	private JLabel dessert_label;
	private JLabel boisson_label;
	private JButton btn_addition;
	private JLabel prix;
	//Propriete pour stocker les menus disponibles
	private static ArrayList menus;
	// Proprietes pour stocker les menus choisis
	private static ArrayList menusChoisis;
	public static ArrayList listChoisis;
	//Variable de classe pour positionnement des menus sur  le conteneur de l'appication
	private static int space_plat = 0;
	private static int space_entree = 0;
	private static int space_dessert = 0;
	private static int space_boisson = 0;
	private static int space_choisi = 0;
	
	
	public AllMenu() {
		//Construction  du conteneur et ses decoration
		super();
		bg = new ImageIcon(getClass().getResource("fond.jpg"));
		imBg = bg.getImage();
		btn_new_menu = new JButton("Nouveau menu");
		btn_new_menu.setBackground(Color.BLACK);
		btn_new_menu.setBounds(570, 70, 150, 23);
		btn_new_menu.setForeground(new Color(200, 105, 32));
		//Action sur le bouton "nouveau menu"
		btn_new_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saisir();
			}	
		});
		plat_label = new JLabel("Plat résistant");
		plat_label.setForeground(new Color(200, 105, 32));
		plat_label.setBounds(480, 190, 150, 25);
		plat_label.setFont(new Font("Impact", Font.ROMAN_BASELINE, 18));
		entree_label = new JLabel("Entrée");
		entree_label.setForeground(new Color(200, 105, 32));
		entree_label.setBounds(720, 190, 150, 25);
		entree_label.setFont(new Font("Impact", Font.ROMAN_BASELINE, 18));
		dessert_label = new JLabel("Dessert");
		dessert_label.setForeground(new Color(200, 105, 32));
		dessert_label.setBounds(480, 360, 150, 25);
		dessert_label.setFont(new Font("Impact", Font.ROMAN_BASELINE, 18));
		boisson_label = new JLabel("Boisson");
		boisson_label.setForeground(new Color(200, 105, 32));
		boisson_label.setBounds(720, 360, 150, 25);
		boisson_label.setFont(new Font("Impact", Font.ROMAN_BASELINE, 18));
		btn_addition = new JButton();
		btn_addition.setBackground(Color.BLACK);
		btn_addition.setBounds(170, 500, 250, 30);
		btn_addition.setForeground(new Color(200, 105, 32));
		prix = new JLabel();
		prix.setBounds(500, 510, 300, 25);
		prix.setForeground(Color.green);
		setLayout(null);
		//Ajout de composant principale de notre conteneur
		add(btn_new_menu);
		add(plat_label);
		add(entree_label);
		add(dessert_label);
		add(boisson_label);
		add(prix);
		//Remplissage des listes des menus dans  notre conteneur
		menus = new ArrayList();
		addMenu(new Menu("Viande de poulet", 7000, 1), "space_plat");
		addMenu(new Menu("Viande de boeuf", 5000, 1),  "space_plat");
		addMenu(new Menu("Salade de legiume", 4000, 1), "space_entree");
		addMenu(new Menu("Avocat au crevette", 9000, 1),  "space_entree");
		addMenu(new Menu("Café gourmand", 3000, 1),  "space_dessert");
		addMenu(new Menu("Glace", 2000, 1),  "space_dessert");
		addMenu(new Menu("Jus naturel", 2000, 1),  "space_boisson");
		addMenu(new Menu("Boisson star", 4000, 1),  "space_boisson");
		menusChoisis = new ArrayList();
		listChoisis = new ArrayList();
	}	
	
	/**
	 * ajout d'un menu dans notre conteneur et dans la liste des menus disponible
	 * @param menu: objet menu à ajouter
	 * @param space_name: categorie de menu à ajouter (plat ou dessert etc , pour avoir le bon placement
	 */
	public void addMenu(Menu menu,  String space_name) {
		JLabel label = new JLabel(menu.getNom());
		int space = 0;
		int posYLabel = 0;
		int posXLabel = 0;
		if(space_name == "space_plat") {
			space = space_plat;
			space_plat+=25;
			posYLabel = 220;
			posXLabel = 500;
		}
		else if(space_name == "space_entree") {
			space = space_entree;
			space_entree+=25;
			posYLabel = 220;
			posXLabel = 690;
		}
		else if(space_name == "space_dessert") {
			space_dessert+=25;
			space = space_dessert;
			posYLabel = 360;
			posXLabel = 500;
		} else  if(space_name == "space_boisson"){
			space_boisson+=25;
			space = space_boisson;
			posYLabel = 360;
			posXLabel = 690;
		}
		label.setBounds(posXLabel, posYLabel+space, 180, 25);
		label.setForeground(new Color(100, 105, 32));
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		label.setFont(new Font("Trebauchet", Font.ROMAN_BASELINE, 12));
		menu.setLabel(label);
		JButton bouton = new JButton("");
		bouton.setBounds(posXLabel-15, posYLabel+space+8, 10, 9);
		bouton.setFont(new Font("Arial", Font.BOLD, 9));
		menu.setBtn(bouton);
		menus.add(menu);
		((Menu) menus.get(menus.indexOf(menu))).getBtn().addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				choisir(menu);
			}
			public void mouseEntered(MouseEvent arg0) {
				prix.setText(((Menu) menus.get(menus.indexOf(menu))).getNom() + " : " + ((Menu) menus.get(menus.indexOf(menu))).getPrix() + " Ar");
			}
			public void mouseExited(MouseEvent arg0) {
				prix.setText("");
			}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		add(menu.getLabel());
		add(menu.getBtn());
	}
	
	
	// pour saisir et rajouter un menu
	
	public void saisir() {
		// On va enlever tous les menus sur  le conteneur pour ajouter les contenus de formulaire
		for(int i=0; i<menus.size(); i++) {
			remove(((Menu) menus.get(i)).getLabel());
			remove(((Menu) menus.get(i)).getBtn());
		}
		for(int i=0; i<menusChoisis.size(); i++) {
			remove(((Menu) menusChoisis.get(i)).getChoix());
			remove(((Menu) menus.get(i)).getBtnRetour());
		}
		remove(btn_addition);
		//Plat
		JLabel nom_plat = new JLabel("Nom");
		nom_plat.setBounds(480, 220, 50, 25);
		nom_plat.setForeground(new Color(50, 80, 20));
		JTextField nom_plat_text = new JTextField();
		nom_plat_text.setBounds(480, 250, 100, 18);
		add(nom_plat);
		add(nom_plat_text);
		JLabel prix_plat = new JLabel("Prix");
		prix_plat.setBounds(480, 280, 50, 25);
		prix_plat.setForeground(new Color(50, 80, 20));
		JTextField prix_plat_text = new JTextField();
		prix_plat_text.setBounds(480, 310, 100, 18);
		add(prix_plat);
		add(prix_plat_text);
		//Entree
		JLabel nom_entree = new JLabel("Nom");
		nom_entree.setBounds(680, 220, 50, 25);
		nom_entree.setForeground(new Color(50, 80, 20));
		JTextField nom_entree_text = new JTextField();
		nom_entree_text.setBounds(680, 250, 100, 18);
		add(nom_entree);
		add(nom_entree_text);
		JLabel prix_entree = new JLabel("Prix");
		prix_entree.setBounds(680, 280, 50, 25);
		prix_entree.setForeground(new Color(50, 80, 20));
		JTextField prix_entree_text = new JTextField();
		prix_entree_text.setBounds(680, 310, 100, 18);
		add(prix_entree);
		add(prix_entree_text);
		//Dessert
		JLabel nom_dessert = new JLabel("Nom");
		nom_dessert.setBounds(480, 380, 50, 25);
		nom_dessert.setForeground(new Color(50, 80, 20));
		JTextField nom_dessert_text = new JTextField();
		nom_dessert_text.setBounds(480, 410, 100, 18);
		add(nom_dessert);
		add(nom_dessert_text);
		JLabel prix_dessert = new JLabel("Prix");
		prix_dessert.setBounds(480, 430, 50, 25);
		prix_dessert.setForeground(new Color(50, 80, 20));
		JTextField prix_dessert_text = new JTextField();
		prix_dessert_text.setBounds(480, 460, 100, 18);
		add(prix_dessert);
		add(prix_dessert_text);
		//Boisson
		JLabel nom_boisson = new JLabel("Nom");
		nom_boisson.setBounds(680, 380, 50, 25);
		nom_boisson.setForeground(new Color(50, 80, 20));
		JTextField nom_boisson_text = new JTextField();
		nom_boisson_text.setBounds(680, 410, 100, 18);
		add(nom_boisson);
		add(nom_boisson_text);
		JLabel prix_boisson = new JLabel("Prix");
		prix_boisson.setBounds(680, 430, 50, 25);
		prix_boisson.setForeground(new Color(50, 80, 20));
		JTextField prix_boisson_text = new JTextField();
		prix_boisson_text.setBounds(680, 460, 100, 18);
		add(prix_boisson);
		add(prix_boisson_text);
		JButton btn_ajouter = new JButton("Ajouter");
		btn_ajouter.setBounds(480, 510, 100, 25);
		btn_ajouter.setBackground(Color.BLACK);
		btn_ajouter.setForeground(new Color(200, 105, 32));
		btn_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nom_plat_text.getText().length() > 0 && prix_plat_text.getText().length() > 0 ) {
					addMenu(new Menu(nom_plat_text.getText(), prix_plat_text.getText(), 1),  "space_plat");
				}
				if(nom_entree_text.getText().length() > 0 && prix_entree_text.getText().length() > 0 ) {
					addMenu(new Menu(nom_entree_text.getText(), prix_entree_text.getText(), 1),  "space_entree");
				}
				if(nom_dessert_text.getText().length() > 0 && prix_dessert_text.getText().length() > 0 ) {
					addMenu(new Menu(nom_dessert_text.getText(), prix_dessert_text.getText(), 1),  "space_dessert");
				}
				if(nom_boisson_text.getText().length() > 0 && prix_boisson_text.getText().length() > 0 ) {
					addMenu(new Menu(nom_boisson_text.getText(), prix_boisson_text.getText(), 1),  "space_boisson");
				}
				remove(nom_plat);
				remove(nom_plat_text);
				remove(prix_plat);
				remove(prix_plat_text);
				remove(nom_entree);
				remove(nom_entree_text);
				remove(prix_entree);
				remove(prix_entree_text);
				remove(nom_dessert);
				remove(nom_dessert_text);
				remove(prix_dessert);
				remove(prix_dessert_text);
				remove(nom_boisson);
				remove(nom_boisson_text);
				remove(prix_boisson);
				remove(prix_boisson_text);
				remove(btn_ajouter);
				for(int i=0; i<menus.size(); i++) {
					add(((Menu) menus.get(i)).getLabel());
					add(((Menu) menus.get(i)).getBtn());
					repaint();
				}
			}
			
		});
		add(btn_ajouter);
		repaint();
	}
	/**
	 * Choisir un  menu
	 * @param menu (menu choisi)
	 */
	public void choisir(Menu menu) {
		if(!(listChoisis.contains(((Menu) menus.get(menus.indexOf(menu))).getNom()))) {
			((Menu) menus.get(menus.indexOf(menu))).setQte(1);
			int each = ((Menu) menus.get(menus.indexOf(menu))).getPrix() * ((Menu) menus.get(menus.indexOf(menu))).getQte();
			JLabel choix = new JLabel (((Menu) menus.get(menus.indexOf(menu))).getNom() + " " + ((Menu) menus.get(menus.indexOf(menu))).getQte() + " : " + each + " Ar");
			choix.setCursor(new Cursor(Cursor.HAND_CURSOR));
			choix.setForeground(new Color(250, 250, 250));
			choix.setFont(new Font("Trebauchet", Font.ROMAN_BASELINE, 14));
			JButton btn = new JButton();
			btn.setBounds(210, 228+space_choisi, 10, 9);
			((Menu) menus.get(menus.indexOf(menu))).setChoix(choix);
			((Menu) menus.get(menus.indexOf(menu))).getChoix().setBounds(225, 220+space_choisi, 250, 25);
			space_choisi+= 25;
			((Menu) menus.get(menus.indexOf(menu))).setBtnRetour(btn);
			menusChoisis.add(((Menu) menus.get(menus.indexOf(menu))));
			add(((Menu) menus.get(menus.indexOf(menu))).getBtnRetour());
			add(((Menu) menus.get(menus.indexOf(menu))).getChoix());
			listChoisis.add(((Menu) menus.get(menus.indexOf(menu))).getNom());
			((Menu) menus.get(menus.indexOf(menu))).getBtnRetour().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((Menu) menus.get(menus.indexOf(menu))).decrement();
					if(((Menu) menus.get(menus.indexOf(menu))).getQte() == 0) {
						remove(((Menu) menus.get(menus.indexOf(menu))).getChoix());
						remove(((Menu) menus.get(menus.indexOf(menu))).getBtnRetour());
						menusChoisis.remove(((Menu) menus.get(menus.indexOf(menu))));
						listChoisis.remove(((Menu) menus.get(menus.indexOf(menu))).getNom());
						repaint();
					} else {
						int each = ((Menu) menus.get(menus.indexOf(menu))).getPrix() * ((Menu) menus.get(menus.indexOf(menu))).getQte();
						((Menu) menus.get(menus.indexOf(menu))).getChoix().setText(((Menu) menus.get(menus.indexOf(menu))).getNom() + " " + ((Menu) menus.get(menus.indexOf(menu))).getQte() + " : " + each + " Ar");
					}
					if(menusChoisis.isEmpty()) {
						remove(btn_addition);
						space_choisi = 0;
					}
					else {
						addition();
					}
				}
			});
		} else {
			((Menu) menus.get(menus.indexOf(menu))).increment();
			int each = ((Menu) menus.get(menus.indexOf(menu))).getPrix() * ((Menu) menus.get(menus.indexOf(menu))).getQte();
			((Menu) menus.get(menus.indexOf(menu))).getChoix().setText(((Menu) menus.get(menus.indexOf(menu))).getNom() + " " + ((Menu) menus.get(menus.indexOf(menu))).getQte() + " : " + each + " Ar");
		}
		addition();
		add(btn_addition);
		repaint();
	}
	/**
	 * calcul addition
	 */
	public void addition() {
		int addition = 0;
		for(int k=0; k<menusChoisis.size(); k++)
			addition += ((Menu) menusChoisis.get(k)).getPrix() * ((Menu) menusChoisis.get(k)).getQte();
		btn_addition.setText("Addition : " + addition + " Ar");	
	}
	
	// Paint de notre conteneur
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		g2.drawImage(imBg, 0, 0, 900, 600, this);  		 	    
	}
}