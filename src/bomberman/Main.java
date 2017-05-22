package bomberman;

import edu.princeton.cs.introcs.StdAudio;

public class Main {
	
	public static void main(String[] args){
		
		Map map = new Map();
		Ig bomberman =new Ig();
		Joueur J1 = new Joueur("P1", 1, 1);
		bomberman.intialisation_ecran();
		bomberman.ecran_de_demarrage();
		StdAudio.close();
		bomberman.ecran_de_jeu(map);
		bomberman.ecran_fin(map);
	}

}

