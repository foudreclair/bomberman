package bomberman;


import edu.princeton.cs.introcs.StdAudio;

public class Main {
	
	public static void main(String[] args){
		/* Gal�re!!!!
		 * StdAudio.play("title-screen.wav");
		 */
		Map map = new Map();
		Ig bomberman =new Ig();
		bomberman.intialisation_ecran();
		bomberman.ecran_de_demarrage();
		bomberman.ecran_de_jeu(map);
		bomberman.ecran_fin(map);
	}

}

