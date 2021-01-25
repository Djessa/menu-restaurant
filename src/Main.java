import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * Classe principale de notre application
 * 
 * @author Djessa
 *
 */
public class Main {

	public static void main(String[] args) {
		// Création de la fenetre de l'application
		JFrame fenetre = new JFrame("Restaurant Malagasy");
		// Boite de  message
		JOptionPane message = new JOptionPane();
		// Conteneur de l'application
		AllMenu allMenu = new AllMenu();
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(900, 600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setContentPane(allMenu);
		fenetre.setVisible(true);
		message.showMessageDialog(null, "Bonjour et bienvenue", "Restaurant Malagasy", JOptionPane.INFORMATION_MESSAGE);

	}

}