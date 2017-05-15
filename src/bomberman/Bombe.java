package bomberman;

import java.util.concurrent.CountDownLatch;

import edu.princeton.cs.introcs.StdDraw;

public class Bombe {
	private int tailleFlamme;
	private int typeFlamme;
	private int delais;
	private int x;
	private int y;
	private Joueur joueur;
	private CountDownLatch latch = new CountDownLatch(3);

	public Bombe(int x, int y) {
		this.x = x;
		this.y = y;
		this.delais = 3;
		this.typeFlamme = 0;
		this.tailleFlamme = 3;
	}

	public void exploser(Bombe b, int[][] map) {
		for(int i = 0;i<tailleFlamme;i++) {
			if(map[y][x+i]==2 || map[y][x+i]==1) {
				StdDraw.picture(b.getX()+i+0.5,b.getY()+0.5 , "images/explosion_hori.png");
			}
		}

	}
	
	public int getTailleFlamme() {
		return tailleFlamme;
	}

	public void setTailleFlamme(int tailleFlamme) {
		this.tailleFlamme = tailleFlamme;
	}

	public int getTypeFlamme() {
		return typeFlamme;
	}

	public void setTypeFlamme(int typeFlamme) {
		this.typeFlamme = typeFlamme;
	}

	public int getDelais() {
		return delais;
	}

	public void setDelais(int delais) {
		this.delais = delais;
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
