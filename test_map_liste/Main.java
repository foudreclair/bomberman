package test_map_liste;

public class Main {
	
	public static void main(String[] args){
		map_list map = new map_list();
		IG bomberman =new IG();
		bomberman.intialisation_ecran();
		bomberman.ecran_de_demarrage();
		bomberman.ecran_de_jeu(map.getMap());
	}

}
