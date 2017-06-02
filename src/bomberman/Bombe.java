package bomberman;

import java.sql.Timestamp;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class Bombe {

	private int x;
	private int y;
	private int delai;
	private Joueur joueur;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	public Bombe(int x, int y, Joueur joueur) {
		this.x = x;
		this.y = y;
		this.delai = joueur.getDelai();
		this.joueur = joueur;
	}

	public boolean exploser(Bombe b, Map mapcurrent, Joueur J1, Joueur J2, ArrayList<Bonus> nbBonus,
			ArrayList<Bombe> nbBombes) {
		int[][] map = mapcurrent.getMap();
		boolean exploser = false;
		double randombonnus = Math.random();
		// Current Timestamp
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		if (currentTimeStamp.getTime() - b.timestamp.getTime() > delai) {
			// Explosion sur l'axe des X positifs
			for (int i = 1; i <= joueur.getTailleFlamme(); i++) {
				if (map[y][x + i] == 0) {
					break;
				}
				if (map[y][x + i] == 2) {
					StdDraw.picture(b.getX() + i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
				}
				// On vérifie si une autre bombe est présente
				if (map[y][x + i] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX() + i) && (nbBombes.get(k).getY() == b.getY())) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}
				if (map[y][x + i] == 1) {
					StdDraw.picture(b.getX() + i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
					mapcurrent.setMap(y, x + i, 2);
					/*
					 * On vérifie si on a un bonus 20% de chance d'obtenir un
					 * bonnus
					 */
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX() + i, b.getY(), randomBonus));
						switch (randomBonus) {
						case 0:
							// flamme blue
							mapcurrent.setMap(b.getY(), b.getX() + i, 4);
							break;
						case 1:
							// flamme jaune
							mapcurrent.setMap(b.getY(), b.getX() + i, 5);
							break;
						case 2:
							// flamme rouge
							mapcurrent.setMap(b.getY(), b.getX() + i, 6);
							break;
						case 3:
							// vie +1
							mapcurrent.setMap(b.getY(), b.getX() + i, 7);
							break;
						case 4:
							// bombe +1
							mapcurrent.setMap(b.getY(), b.getX() + i, 8);
							break;
						case 5:
							// bombe -1
							mapcurrent.setMap(b.getY(), b.getX() + i, 9);
							break;
						case 6: 
							mapcurrent.setMap(b.getY(), b.getX() + i, 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY(), b.getX() + i, 11);
							break;
						default:
							mapcurrent.setMap(b.getY(), b.getX() + i, 5);
							break;
						}
					}
					break;
				}
				// On vérifie la position du joueur
				if (b.getX() + i == J1.getX() && b.getY() == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() + i == J2.getX() && b.getY() == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}

			}

			// Explosion sur l'axe des X négatifs
			for (int i = 1; i <= joueur.getTailleFlamme(); i++) {
				if (map[y][x - i] == 0) {
					break;
				}
				if (map[y][x - i] == 2) {
					StdDraw.picture(b.getX() - i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
				}
				if (map[y][x - i] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX() - i) && (nbBombes.get(k).getY() == b.getY())) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}
				if (map[y][x - i] == 1) {
					StdDraw.picture(b.getX() - i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
					mapcurrent.setMap(y, x - i, 2);
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX() - i, b.getY(), randomBonus));
						switch (randomBonus) {
						case 0:
							mapcurrent.setMap(b.getY(), b.getX() - i, 4);
							break;
						case 1:
							mapcurrent.setMap(b.getY(), b.getX() - i, 5);
							break;
						case 2:
							mapcurrent.setMap(b.getY(), b.getX() - i, 6);
							break;
						case 3:
							mapcurrent.setMap(b.getY(), b.getX() - i, 7);
							break;
						case 4:
							mapcurrent.setMap(b.getY(), b.getX() - i, 8);
							break;
						case 5:
							mapcurrent.setMap(b.getY(), b.getX() - i, 9);
							break;
						case 6:
							mapcurrent.setMap(b.getY(), b.getX() - i, 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY(), b.getX() - i, 11);
							break;
						default:
							mapcurrent.setMap(b.getY(), b.getX() - i, 4);
							break;
						}
					}
					break;
				}
				// On vérifie la position du joueur
				if (b.getX() - i == J1.getX() && b.getY() == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() - i == J2.getX() && b.getY() == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
			}
			// Explosion sur l'axe des Y positifs
			for (int j = 1; j <= joueur.getTailleFlamme(); j++) {
				if (map[y + j][x] == 0) {
					break;
				}
				if (map[y + j][x] == 1) {
					StdDraw.picture(b.getX() + 0.5, b.getY() + j + 0.5, "images/explosion_vert.png");
					mapcurrent.setMap(y + j, x, 2);
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX(), b.getY() + j, randomBonus));
						switch (randomBonus) {
						case 0:
							mapcurrent.setMap(b.getY() + j, b.getX(), 4);
							break;
						case 1:
							mapcurrent.setMap(b.getY() + j, b.getX(), 5);
							break;
						case 2:
							mapcurrent.setMap(b.getY() + j, b.getX(), 6);
							break;
						case 3:
							mapcurrent.setMap(b.getY() + j, b.getX(), 7);
							break;
						case 4:
							mapcurrent.setMap(b.getY() + j, b.getX(), 8);
							break;
						case 5:
							mapcurrent.setMap(b.getY() + j, b.getX(), 9);
							break;
						case 6:
							mapcurrent.setMap(b.getY() + j, b.getX(), 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY()+ j, b.getX(), 11);
							break;
						default:
							mapcurrent.setMap(b.getY() + j, b.getX(), 4);
							break;
						}
					}
					break;
				}
				if (map[y + j][x] == 2) {
					StdDraw.picture(b.getX() + 0.5, b.getY() + j + 0.5, "images/explosion_vert.png");

				}
				// On vérifie si une autre bombe est présente
				if (map[y + j][x] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX()) && (nbBombes.get(k).getY() == b.getY() + j)) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}
				// On vérifie la position du joueur
				if (b.getX() == J1.getX() && b.getY() + j == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() == J2.getX() && b.getY() + j == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
			}
			// Explosion sur l'axe des Y négatifs
			for (int j = 1; j <= joueur.getTailleFlamme(); j++) {
				if (map[y - j][x] == 0) {
					break;
				}
				if (map[y - j][x] == 1) {
					StdDraw.picture(b.getX() + 0.5, b.getY() - j + 0.5, "images/explosion_vert.png");
					mapcurrent.setMap(y - j, x, 2);
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX(), b.getY() - j, randomBonus));
						switch (randomBonus) {
						case 0:
							mapcurrent.setMap(b.getY() - j, b.getX(), 4);
							break;
						case 1:
							mapcurrent.setMap(b.getY() - j, b.getX(), 5);
							break;
						case 2:
							mapcurrent.setMap(b.getY() - j, b.getX(), 6);
							break;
						case 3:
							mapcurrent.setMap(b.getY() - j, b.getX(), 7);
							break;
						case 4:
							mapcurrent.setMap(b.getY() - j, b.getX(), 8);
							break;
						case 5:
							mapcurrent.setMap(b.getY() - j, b.getX(), 9);
							break;
						case 6:
							mapcurrent.setMap(b.getY() - j, b.getX(), 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY() - j, b.getX(), 11);
							break;
						default:
							mapcurrent.setMap(b.getY() - j, b.getX() + j, 4);
							break;
						}
					}
					break;
				}
				if (map[y - j][x] == 2) {
					StdDraw.picture(b.getX() + 0.5, b.getY() - j + 0.5, "images/explosion_vert.png");
				}
				// On vérifie si une autre bombe est présente
				if (map[y - j][x] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX()) && (nbBombes.get(k).getY() == b.getY() - j)) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}
				// On vérifie la position du joueur
				if (b.getX() == J1.getX() && b.getY() - j == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() == J2.getX() && b.getY() - j == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}

			}

			// On vérifie la position du joueur a la postion de la bombe
			if (b.getX() == J1.getX() && b.getY() == J1.getY()) {
				J1.setVie(J1.getVie() - 1);
			}
			if (b.getX() == J2.getX() && b.getY() == J2.getY()) {
				J2.setVie(J2.getVie() - 1);
			}
			exploser = true;
		}
		return exploser;
	}

	public boolean exploserRouge(Bombe b, Map mapcurrent, Joueur J1, Joueur J2, ArrayList<Bonus> nbBonus,
			ArrayList<Bombe> nbBombes) {
		int[][] map = mapcurrent.getMap();
		boolean exploser = false;
		double randombonnus = Math.random();
		// Current Timestamp
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		if (currentTimeStamp.getTime() - b.timestamp.getTime() > delai) {
			// Explosion sur l'axe des X positifs
			for (int i = 1; i <= joueur.getTailleFlamme(); i++) {
				if (map[y][x + i] == 0) {
					break;
				}
				if (map[y][x + i] == 2) {
					StdDraw.picture(b.getX() + i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
				}
				// On vérifie si une autre bombe est présente
				if (map[y][x + i] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX() + i) && (nbBombes.get(k).getY() == b.getY())) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}
				if (map[y][x + i] == 1) {
					StdDraw.picture(b.getX() + i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");
					mapcurrent.setMap(y, x + i, 2);
					/*
					 * On vérifie si on a un bonus 20% de chance d'obtenir un
					 * bonnus
					 */
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX() + i, b.getY(), randomBonus));
						switch (randomBonus) {
						case 0:
							// flamme blue
							mapcurrent.setMap(b.getY(), b.getX() + i, 4);
							break;
						case 1:
							// flamme jaune
							mapcurrent.setMap(b.getY(), b.getX() + i, 5);
							break;
						case 2:
							// flamme rouge
							mapcurrent.setMap(b.getY(), b.getX() + i, 6);
							break;
						case 3:
							// vie +1
							mapcurrent.setMap(b.getY(), b.getX() + i, 7);
							break;
						case 4:
							// bombe +1
							mapcurrent.setMap(b.getY(), b.getX() + i, 8);
							break;
						case 5:
							// bombe -1
							mapcurrent.setMap(b.getY(), b.getX() + i, 9);
							break;
						case 6:
							mapcurrent.setMap(b.getY(), b.getX() + i, 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY(), b.getX() + i, 11);
							break;
						default:
							mapcurrent.setMap(b.getY(), b.getX() + i, 5);
							break;
						}
					}
					break;
				}

			}

			// Explosion sur l'axe des X négatifs
			for (int i = 1; i <= joueur.getTailleFlamme(); i++) {
				if (map[y][x - i] == 0) {
					break;
				}
				if (map[y][x - i] == 2) {
				}
				if (map[y][x - i] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX() - i) && (nbBombes.get(k).getY() == b.getY())) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}
				if (map[y][x - i] == 1) {
					mapcurrent.setMap(y, x - i, 2);
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX() - i, b.getY(), randomBonus));
						switch (randomBonus) {
						case 0:
							mapcurrent.setMap(b.getY(), b.getX() - i, 4);
							break;
						case 1:
							mapcurrent.setMap(b.getY(), b.getX() - i, 5);
							break;
						case 2:
							mapcurrent.setMap(b.getY(), b.getX() - i, 6);
							break;
						case 3:
							mapcurrent.setMap(b.getY(), b.getX() - i, 7);
							break;
						case 4:
							mapcurrent.setMap(b.getY(), b.getX() - i, 8);
							break;
						case 5:
							mapcurrent.setMap(b.getY(), b.getX() - i, 9);
							break;
						case 6:
							mapcurrent.setMap(b.getY(), b.getX() - i, 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY(), b.getX() - i, 11);
							break;
						default:
							mapcurrent.setMap(b.getY(), b.getX() - i, 4);
							break;
						}
					}
					break;
				}

			}
			// Explosion sur l'axe des Y positifs
			for (int j = 1; j <= joueur.getTailleFlamme(); j++) {
				if (map[y + j][x] == 0) {
					break;
				}
				if (map[y + j][x] == 1) {
					mapcurrent.setMap(y + j, x, 2);
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX(), b.getY() + j, randomBonus));
						switch (randomBonus) {
						case 0:
							mapcurrent.setMap(b.getY() + j, b.getX(), 4);
							break;
						case 1:
							mapcurrent.setMap(b.getY() + j, b.getX(), 5);
							break;
						case 2:
							mapcurrent.setMap(b.getY() + j, b.getX(), 6);
							break;
						case 3:
							mapcurrent.setMap(b.getY() + j, b.getX(), 7);
							break;
						case 4:
							mapcurrent.setMap(b.getY() + j, b.getX(), 8);
							break;
						case 5:
							mapcurrent.setMap(b.getY() + j, b.getX(), 9);
							break;
						case 6:
							mapcurrent.setMap(b.getY() + j, b.getX(), 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY() + j, b.getX(), 11);
							break;
						default:
							mapcurrent.setMap(b.getY() + j, b.getX(), 4);
							break;
						}
					}
					break;
				}
				if (map[y + j][x] == 2) {

				}
				// On vérifie si une autre bombe est présente
				if (map[y + j][x] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX()) && (nbBombes.get(k).getY() == b.getY() + j)) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}
			}
			// Explosion sur l'axe des Y négatifs
			for (int j = 1; j <= joueur.getTailleFlamme(); j++) {
				if (map[y - j][x] == 0) {
					break;
				}
				if (map[y - j][x] == 1) {
					mapcurrent.setMap(y - j, x, 2);
					if (randombonnus <= 0.2) {
						int randomBonus = (int) (Math.random() * 8);
						nbBonus.add(new Bonus(b.getX(), b.getY() - j, randomBonus));
						switch (randomBonus) {
						case 0:
							mapcurrent.setMap(b.getY() - j, b.getX(), 4);
							break;
						case 1:
							mapcurrent.setMap(b.getY() - j, b.getX(), 5);
							break;
						case 2:
							mapcurrent.setMap(b.getY() - j, b.getX(), 6);
							break;
						case 3:
							mapcurrent.setMap(b.getY() - j, b.getX(), 7);
							break;
						case 4:
							mapcurrent.setMap(b.getY() - j, b.getX(), 8);
							break;
						case 5:
							mapcurrent.setMap(b.getY() - j, b.getX(), 9);
							break;
						case 6:
							mapcurrent.setMap(b.getY() - j, b.getX(), 10);
							break;
						case 7: 
							mapcurrent.setMap(b.getY() - j, b.getX(), 11);
							break;
						default:
							mapcurrent.setMap(b.getY() - j, b.getX() + j, 4);
							break;
						}
					}
					break;
				}
				if (map[y - j][x] == 2) {
				}
				// On vérifie si une autre bombe est présente
				if (map[y - j][x] == 3) {
					for (int k = 0; k < nbBombes.size(); k++) {
						if ((nbBombes.get(k).getX() == b.getX()) && (nbBombes.get(k).getY() == b.getY() - j)) {
							nbBombes.get(k).setDelai(0);
						}
					}
				}

			}

			// On vérifie la position du joueur a la postion de la bombe et aux
			// autres
			for (int i = 0; i <= joueur.getTailleFlamme(); i++) {
				StdDraw.picture(b.getX() + 0.5, b.getY() + i + 0.5, "images/explosion_vert.png");
				StdDraw.picture(b.getX() + 0.5, b.getY() - i + 0.5, "images/explosion_vert.png");
				StdDraw.picture(b.getX() + i + 0.5, b.getY()+ 0.5, "images/explosion_hori.png");
				StdDraw.picture(b.getX() - i + 0.5, b.getY() + 0.5, "images/explosion_hori.png");

				if (b.getX() + i == J1.getX() && b.getY() == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() + i == J2.getX() && b.getY() == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
				if (b.getX() - i == J1.getX() && b.getY() == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() - i == J2.getX() && b.getY() == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
				if (b.getX() == J1.getX() && b.getY() + i == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() == J2.getX() && b.getY() + i == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
				if (b.getX() == J1.getX() && b.getY() - i == J1.getY()) {
					J1.setVie(J1.getVie() - 1);
				}
				if (b.getX() == J2.getX() && b.getY() - i == J2.getY()) {
					J2.setVie(J2.getVie() - 1);
				}
			}
			if (b.getX() == J1.getX() && b.getY() == J1.getY()) {
				J1.setVie(J1.getVie() - 1);
			}
			if (b.getX() == J2.getX() && b.getY() == J2.getY()) {
				J2.setVie(J2.getVie() - 1);
			}
			exploser = true;
		}
		return exploser;
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
