package bomberman;

import java.awt.Font;
import java.util.ArrayList;

import edu.princeton.cs.introcs.*;

public class Ig {

	// Déclaration de la taille de la map

	// N est un nombre arbitrairement choisie pour faire une fenêtre de la bonne
	// dimension
	public int N = 50;
	// l est la longeur
	public int l = 21;
	// L est la largeur
	public int L = 17;
	public ArrayList<Bombe> nbBombes = new ArrayList();
	public ArrayList<Bonus> nbBonus = new ArrayList();

	Joueur J1 = new Joueur("J1", 1, 1);
	Joueur J2 = new Joueur("J2", 19, 15);

	public void intialisation_ecran() {

		StdDraw.setCanvasSize(l * N, L * N);
		// On défini le nombre de case en graduant notre fenêtre
		StdDraw.setXscale(0, l);
		StdDraw.setYscale(0, L);
		StdDraw.clear(StdDraw.GRAY);

	}

	public void ecran_de_demarrage() {
		
		StdAudio.play("/01-title-screen.wav");
		//Le StdAudio.close(); ne fonctionne pas :(
		Font font_title = new Font("Arial", Font.BOLD, 50);
		Font font = new Font("Arial", Font.CENTER_BASELINE, 30);
		StdDraw.enableDoubleBuffering();
		int exit = 0;
		int control = 0;
		while (true) {
			
			StdDraw.clear(StdDraw.GRAY);
			StdDraw.setPenColor();
			StdDraw.setFont(font_title);
			StdDraw.text(11, 15, "BomberMan");
			StdDraw.setFont(font);
			StdDraw.text(11, 4, "New Game");
			StdDraw.text(11, 2, "Control");
			StdDraw.picture(11, 10, "images/bomberman.png");
			StdDraw.pause(80);
			// Creation des boutons sur la page d'accueil

			if (StdDraw.mouseX() >= 10 && StdDraw.mouseX() <= 12 && StdDraw.mouseY() > 3 && StdDraw.mouseY() < 5) {
				if (StdDraw.mousePressed()) {
					// Test
					// ecran_fin();
					break;
				}
			}
			/*
			 * tout tourne dans cette boucle
			 * 
			 * if(exit==1){ break; }
			 */
			// Permet d'afficher les controles des deux joueurs
			if (StdDraw.mouseX() >= 10 && StdDraw.mouseX() <= 12 && StdDraw.mouseY() > 1 && StdDraw.mouseY() < 4) {
				if (StdDraw.mousePressed()) {
					control = 1;

				}
			}
			while (control == 1) {
				StdDraw.clear(StdDraw.GRAY);
				StdDraw.text(3, 13, "Joueur 1");
				StdDraw.text(3, 11, "Z : Move Up");
				StdDraw.text(3, 10, "Q : Move Left");
				StdDraw.text(3, 9, "S : Move Down");
				StdDraw.text(3, 8, "D : Move Right");
				StdDraw.text(3, 6, "F : Use Bombe");
				StdDraw.picture(3, 3, "images/bomberman_player.png");
				StdDraw.text(17, 13, "Joueur 2");
				StdDraw.text(17, 11, "▲ : Move Up");
				StdDraw.text(17, 10, "◄ : Move Left");
				StdDraw.text(17, 9, "▼: Move Down");
				StdDraw.text(17, 8, "► : Move Right");
				StdDraw.text(17, 6, "0 : Use Bombe");
				StdDraw.picture(17, 3, "images/bomferman_player.png");
				StdDraw.text(11, 2, "Return");
				StdDraw.pause(80);
				if (StdDraw.mouseX() >= 10 && StdDraw.mouseX() <= 12 && StdDraw.mouseY() > 1 && StdDraw.mouseY() < 3) {
					if (StdDraw.mousePressed()) {

						control = 0;
					}
				}

			}
			
			StdDraw.show();
			// StdDraw.pause(100);
		}
	}

	public void ecran_de_jeu(Map mapcurrent) {
		/**
		 * Partie Audio
		**/
		StdAudio.close();
		//StdAudio.play("/02-stage-start.wav");
		//StdAudio.loop("/03-stage-theme.wav");
		while (J1.getVie() != 0 && J2.getVie() != 0) {
			int[][] map = mapcurrent.getMap();
			// Colorisation de la map
			StdDraw.enableDoubleBuffering();
			StdDraw.clear(StdDraw.GRAY);
			for (int y = 0; y < L; y++) {
				for (int x = 0; x < l; x++) {
					if (map[y][x] == 0) {
						StdDraw.setPenColor(StdDraw.GRAY);
						StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
					} else if (map[y][x] == 1) {
						StdDraw.setPenColor(StdDraw.ORANGE);
						StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
					} else if (map[y][x] == 2 || map[y][x] == 3) {
						StdDraw.setPenColor(StdDraw.GREEN);
						StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
					} else if(map[y][x] == 4) {
						StdDraw.setPenColor(StdDraw.GREEN);
						StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
						StdDraw.picture(x+ 0.5, y + 0.5, "images/bombup.png");

					}
				}
			}
			//On affiche les bonus et on les appliquent si le jouer passe dessuss
			if (nbBonus.size() != 0) {
				for (int i = 0; i < nbBonus.size(); i++) {
					//Changer le type en fonction du bonus avec des if...
					mapcurrent.setMap(nbBonus.get(i).getY(), nbBonus.get(i).getX(), 4);
					if(nbBonus.get(i).getX() == J1.getX() && nbBonus.get(i).getY() == J1.getY()) {
						System.out.println("BONUS" + nbBonus.get(i).getTypeBonus());
						nbBonus.get(i).ApplyBonus(J1);
						mapcurrent.setMap(nbBonus.get(i).getY(), nbBonus.get(i).getX(), 2);
				        nbBonus.remove(i);		     
					}
					else if(nbBonus.get(i).getX() == J2.getX() && nbBonus.get(i).getY() == J2.getY()) {
						nbBonus.get(i).ApplyBonus(J2);
						mapcurrent.setMap(nbBonus.get(i).getY(), nbBonus.get(i).getX(), 2);
				        nbBonus.remove(i);		     
					}
				}	
			}
			// keycodes d = 68, q=81, z=90, s=83, f=70
			if (StdDraw.isKeyPressed(68)) {
				J1.moveRight(J1, map);
			}
			if (StdDraw.isKeyPressed(81)) {
				J1.moveLeft(J1, map);
			}
			if (StdDraw.isKeyPressed(90)) {
				J1.moveUp(J1, map);
			}
			if (StdDraw.isKeyPressed(83)) {
				J1.moveDown(J1, map);
			}
			if (StdDraw.isKeyPressed(70)) {
				if (J1.getNbbombes() > 0 && map[J1.getY()][J1.getX()] != 3) {
					J1.setNbbombes(J1.getNbbombes() - 1);
					nbBombes.add(new Bombe(J1.getX(), J1.getY(), J1));
					System.out.println("Le joueur " + J1.getNom() + " pose une bombe");
				} else {
					System.out.println("Le joueur " + J1.getNom() + " n'a plus de bombes !");
				}
			}
			// keycodes J2 0 = 48
			if (StdDraw.isKeyPressed(39)) {
				J2.moveRight(J2, map);
			}
			if (StdDraw.isKeyPressed(37)) {
				J2.moveLeft(J2, map);
			}
			if (StdDraw.isKeyPressed(38)) {
				J2.moveUp(J2, map);
			}
			if (StdDraw.isKeyPressed(40)) {
				J2.moveDown(J2, map);
			}
			
			if (StdDraw.isKeyPressed(97)) {
				if (J2.getNbbombes() > 0 == true && map[J2.getY()][J2.getX()] != 3) {
					J2.setNbbombes(J2.getNbbombes() - 1);
					nbBombes.add(new Bombe(J2.getX(), J2.getY(), J2));
					System.out.println("Le joueur " + J2.getNom() + " pose une bombe");
				} else {
					System.out.println("Le joueur " + J2.getNom() + " n'a plus de bombes !");
				}
			}
			//On affiche les bombes et les explosent
			if (nbBombes.size() != 0) {
				for (int i = 0; i < nbBombes.size(); i++) {
					StdDraw.picture(nbBombes.get(i).getX() + 0.5, nbBombes.get(i).getY() + 0.5, "images/bomb0.png");
			        //On met le type de la map en type bombe
					mapcurrent.setMap(nbBombes.get(i).getY(), nbBombes.get(i).getX(), 3);
			        if(nbBombes.get(i).exploser(nbBombes.get(i), mapcurrent, J1, J2)== true) {
				        //Une fois que la bombe explose on change le type de la map
			        	mapcurrent.setMap(nbBombes.get(i).getY(), nbBombes.get(i).getX(), 2);
				        //On remet une bombe au joueur
			        	nbBombes.get(i).getJoueur().setNbbombes(nbBombes.get(i).getJoueur().getNbbombes() + 1);
						//On vérifie si on a un bonus
			        	// 20% de chance d'obtenir un bonnus
						double randombonnus = Math.random() ;
						if(randombonnus<=0.2){
							int randomBonus = (int)(Math.random() * 6); 
							nbBonus.add(new Bonus(nbBombes.get(i).getX(), nbBombes.get(i).getY(), randomBonus));
						}
			        	//Si oui on crée le bonus
			        	//on retire la bombe du tableau
			        	nbBombes.remove(i);
					}	
				}

			}
			StdDraw.pause(40);
			StdDraw.picture(J1.getX() + 0.5, J1.getY() + 0.5, "images/bomberman_player.png");
			StdDraw.picture(J2.getX() + 0.5, J2.getY() + 0.5, "images/bomferman_player.png");
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(2+0.5, 16+0.5, "Joueur 1 : "+J1.getNbbombes());
			StdDraw.text(17+0.5, 16+0.5, "Joueur 2 : "+J2.getNbbombes());

			
			StdDraw.show();
		}

	}

	public void ecran_fin(Map map) {
		StdAudio.play("/09-game-over.wav");
		while (true) {
			StdDraw.enableDoubleBuffering();
			StdDraw.clear(StdDraw.GRAY);
			if (J1.getVie() == 0) {
				StdDraw.text(11, 13, "Le joueur " + J2.getNom() + " a gagné !");
			}
			if (J2.getVie() == 0) {
				StdDraw.text(11, 13, "Le joueur " + J1.getNom() + " a gagné !");
			}
			StdDraw.picture(11, 9, "images/victory.png");
			StdDraw.text(11, 4, "Replay");
			StdDraw.text(11, 2, "Leave");
			StdDraw.pause(40);
			if (StdDraw.mouseX() >= 10 && StdDraw.mouseX() <= 12 && StdDraw.mouseY() > 3 && StdDraw.mouseY() < 5) {
				if (StdDraw.mousePressed()) {
					J1.setVie(3);
					J2.setVie(3);
					map.resetMap();
					ecran_de_jeu(map);
				}
			}
			if(StdDraw.mouseX()>=10&& StdDraw.mouseX()<=12&&StdDraw.mouseY()>1&&StdDraw.mouseY()<3){
				if(StdDraw.mousePressed()){
					System.exit(0);
				}
			}

			StdDraw.show();

		}
	}

}
