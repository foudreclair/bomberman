package bomberman;


import java.sql.Timestamp;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class Bombe {
	
	private int x;
	private int y;
	private int tailleFlamme;
	private int typeFlamme;
	private int delai;
	private Joueur joueur;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	public Bombe(int x, int y, Joueur joueur) {
		this.x = x;
		this.y = y;
		this.tailleFlamme = joueur.getTailleFlamme();
		this.delai = joueur.getDelai();
		this.typeFlamme = 0;
		this.joueur = joueur;
	}

	public boolean exploser(Bombe b, Map mapcurrent, Joueur J1, Joueur J2, ArrayList<Bonus> nbBonus) {
		int[][] map = mapcurrent.getMap();
		boolean exploser = false;
		double randombonnus = Math.random() ;
		// Current Timestamp
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		if (currentTimeStamp.getTime() - b.timestamp.getTime() > delai) {
			// Explosion sur l'axe des X positifs
			for (int i = 1; i <= tailleFlamme; i++) {
				if (map[y][x + i] == 0) {
					break;
				}
				if (map[y][x + i] == 2) {
					StdDraw.picture(b.getX() + i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
				}
				if (map[y][x + i] == 1) {
					StdDraw.picture(b.getX() + i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
					mapcurrent.setMap(y, x + i, 2);
					/*On vérifie si on a un bonus
		        	20% de chance d'obtenir un bonnus*/
					if(randombonnus<=0.2){
						int randomBonus = (int)(Math.random() * 6); 
						nbBonus.add(new Bonus(b.getX() + i, b.getY(), randomBonus));
						mapcurrent.setMap(b.getY(), b.getX()+i, 4);
					}
					break;
				}
				//On vérifie la position du joueur
				if(b.getX()+i == J1.getX() && b.getY() == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if(b.getX()+i == J2.getX() && b.getY() == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
			}

			// Explosion sur l'axe des X négatifs
			for (int i = 1; i <= tailleFlamme; i++) {
				if (map[y][x - i] == 0) {
					break;
				}
				if (map[y][x - i] == 2) {
					StdDraw.picture(b.getX() - i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
				}
				if (map[y][x - i] == 1) {
					StdDraw.picture(b.getX() - i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
					mapcurrent.setMap(y, x - i, 2);
					if(randombonnus<=0.2){
						int randomBonus = (int)(Math.random() * 6); 
						nbBonus.add(new Bonus(b.getX() - i, b.getY(), randomBonus));
						mapcurrent.setMap(b.getY(), b.getX()-i, 4);
					}
					break;
				}
				//On vérifie la position du joueur
				if(b.getX()-i == J1.getX() && b.getY() == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if(b.getX()-i == J2.getX() && b.getY() == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
			}
			// Explosion sur l'axe des Y positifs
			for (int j = 1; j <= tailleFlamme; j++) {
				if (map[y + j][x] == 0) {
					break;
				}
				if (map[y + j][x] == 1) {
					StdDraw.picture(b.getX() + 0.5, b.getY() + j + 0.5, "images/explosion_vert.png");
					mapcurrent.setMap(y + j, x, 2);
					if(randombonnus<=0.2){
						int randomBonus = (int)(Math.random() * 6); 
						nbBonus.add(new Bonus(b.getX(), b.getY()+j, randomBonus));
						mapcurrent.setMap(b.getY()+j, b.getX(), 4);
					}
					break;
				}
				if (map[y + j][x] == 2) {
					StdDraw.picture(b.getX() + 0.5, b.getY() + j + 0.5, "images/explosion_vert.png");

				}
				//On vérifie la position du joueur
				if(b.getX() == J1.getX() && b.getY()+j == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if(b.getX() == J2.getX() && b.getY()+j == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
			}
			// Explosion sur l'axe des Y négatifs
			for (int j = 1; j <= tailleFlamme; j++) {
				if (map[y - j][x] == 0) {
					break;
				}
				if (map[y - j][x] == 1) {
					StdDraw.picture(b.getX() + 0.5, b.getY() - j + 0.5, "images/explosion_vert.png");
					mapcurrent.setMap(y - j, x, 2);
					if(randombonnus<=0.2){
						int randomBonus = (int)(Math.random() * 6); 
						nbBonus.add(new Bonus(b.getX(), b.getY()-j, randomBonus));
						mapcurrent.setMap(b.getY()-j, b.getX(), 4);
					}
					break;
				}
				if (map[y - j][x] == 2) {
					StdDraw.picture(b.getX() + 0.5, b.getY() - j + 0.5, "images/explosion_vert.png");
				}
				//On vérifie la position du joueur
				if(b.getX() == J1.getX() && b.getY()-j == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if(b.getX() == J2.getX() && b.getY()-j == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}

			}
			
			//On vérifie la position du joueur a la postion de la bombe
			if(b.getX() == J1.getX() && b.getY() == J1.getY()) {
				J1.setVie(J1.getVie() - 1);
			}
			if(b.getX() == J2.getX() && b.getY() == J2.getY()) {
				J2.setVie(J2.getVie() - 1);
			}
			exploser = true;			
		}
		return exploser;
	}


	public int getTailleFlamme() {
		return tailleFlamme;
	}

	public void setTailleFlamme(int tailleFlamme) {
		if(this.tailleFlamme < 10 && this.tailleFlamme >= 1 ) {
			this.tailleFlamme = tailleFlamme;
		}
	}

	public int getTypeFlamme() {
		return typeFlamme;
	}

	public void setTypeFlamme(int typeFlamme) {
		this.typeFlamme = typeFlamme;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
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

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
