package bomberman;

import edu.princeton.cs.introcs.StdAudio;

public class Main {
	
	public static void main(String[] args){
		/* Gal�re!!!!
		 * StdAudio.play("title-screen.wav");
		 */
		Map map = new Map();
		Ig bomberman =new Ig();
		Joueur J1 = new Joueur("P1", 1, 1);
		bomberman.intialisation_ecran();
		bomberman.ecran_de_demarrage();
		bomberman.ecran_de_jeu(map);
		bomberman.ecran_fin(map);
	}

}


/*public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map();
		Joueur j1 = new Joueur("P1", 1.5f, 1.5f);
		j1.start();
		j1.moveUp(j1);
		j1.moveUp(j1);
		j1.moveRight(j1);
	}

}*/
