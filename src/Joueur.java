import edu.princeton.cs.introcs.StdDraw;

public class Joueur {
	private String nom;
	private int vie;
	private int nbBombes;
	private int typeBombes;
	private int x;
	private int y;
	
	

/**
 * @author foudre
 * @param nom, x , y
 * Passer en paramètres le nom, la position x et la position y
 */
	
	
	public Joueur(String nom, int x, int y) {
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.vie = 3;
		this.nbBombes = 3;
		this.typeBombes = 1;
		
		StdDraw.picture(x, y, "images/bomberman.png");
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getNbBombes() {
		return nbBombes;
	}
	public void setNbBombes(int nbBombes) {
		this.nbBombes = nbBombes;
	}
	public int getTypeBombes() {
		return typeBombes;
	}
	public void setTypeBombes(int typeBombes) {
		this.typeBombes = typeBombes;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}