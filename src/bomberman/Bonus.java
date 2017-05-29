package bomberman;


public class Bonus {
	private int vie;
	private int nbBombes;
	private int typeBombes;
	private int tailleFlamme;
	private int delai;
	private int typeBonus;
	private int x;
	private int y;
	
	

	public Bonus(int x, int y, int typeBonus) {
		//Bonus flamme bleu
		if(typeBonus == 0) {
			this.tailleFlamme = this.tailleFlamme -1;
		}
		//Bonus flamme jaune
		if(typeBonus == 1) {
			this.tailleFlamme = this.tailleFlamme + 1;
		}
		//Bonus flamme rouge
		if(typeBonus == 2) {
			this.tailleFlamme = 10;
		}
		//Bonus vie
		if(typeBonus == 3) {
			this.setVie(1);
		}
		//Bombe plus
		if(typeBonus == 4) {
			this.nbBombes = 2;
		}
		//Bombe moins
		if(typeBonus == 5) {
			this.nbBombes = -2;
		}
		//Bombe rouge
		/*
		if(typeBonus == 6) {
			this.typeBombes = 2;
		}*/
		this.typeBonus = typeBonus;
		this.x = x;
		this.y = y;
	}
	
	public void ApplyBonus(Joueur joueur) {
		//Taille flamme
		joueur.setTailleFlamme(joueur.getTailleFlamme() + this.tailleFlamme);
		//Vie
		joueur.setVie(joueur.getVie() + this.vie);
		//Nombres de bombes !
		joueur.setNbbombes(joueur.getNbbombes() + this.nbBombes);
		//Type de bombes
	//	joueur.setTypebombes(this.typeBombes);
	}
	
	
	public int getNbBombes() {
		return nbBombes;
	}
	public void setNbBombes(int nbBombes) {
		this.nbBombes = nbBombes;
	}
	public int getTailleFlamme() {
		return tailleFlamme;
	}
	public void setTailleFlamme(int tailleFlamme) {
		this.tailleFlamme = tailleFlamme;
	}
	public int getDelai() {
		return delai;
	}
	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getTypeBonus() {
		return typeBonus;
	}

	public void setTypeBonus(int typeBonus) {
		this.typeBonus = typeBonus;
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

	public int getTypeBombes() {
		return typeBombes;
	}

	public void setTypeBombes(int typeBombes) {
		this.typeBombes = typeBombes;
	}
}
