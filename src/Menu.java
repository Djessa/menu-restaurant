import javax.swing.JButton;
import javax.swing.JLabel;
/**
 * Une classe pour representer un menu sur le conteneur de l'applicaiton
 * 
 * @author Djessa
 *
 */
public class Menu {
	private  String nom;
	private int prix;
	private int qte;
	private JLabel label;
	private JLabel choix;
	private JButton btn;
	private JButton btnRetour;
	private int posY;
	
	public Menu(String m_nom, String m_prix, int m_qte) {
		nom = m_nom;
		prix = Integer.parseInt(m_prix);
		qte = m_qte;
	}
	public Menu(String m_nom, int m_prix, int m_qte) {
		nom = m_nom;
		prix =  m_prix;
		qte = m_qte;
	}
	// nom manager
	public String getNom() {
		return nom;
	}
	public void setNom(String m_nom) {
		nom = m_nom;
	}
	// label manager
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel m_label) {
		label = m_label;
	}
	// choix manager
	public JLabel getChoix() {
		return choix;
	}
	public void setChoix(JLabel m_choix) {
		choix = m_choix;
	}
	// qte manager
	public int getQte() {
		return qte;
	}
	public void setQte(int m_qte) {
		qte = m_qte;
	}
	public void increment() {
		qte = qte + 1;
	}
	public void decrement() {
		qte = qte -1;
	}
	// postY manager
	public void setPosY(int pos) {
		if(pos >= 220)
			posY = pos;
	}
	public int getPosY() {
		return posY;
	}
	// prix manager
	public int getPrix() {
		return prix;
	}
	public void setPrix(int p_prix){
		prix = p_prix;
	}
	// btnmanager
	public JButton getBtn() {
		return btn;
	}
	public void setBtn(JButton m_btn) {
		btn = m_btn;
	}
	// btnRetour manager
	public JButton getBtnRetour() {
		return btnRetour;
	}
	public void setBtnRetour(JButton m_btnRetour) {
		btnRetour = m_btnRetour;
	}
}

