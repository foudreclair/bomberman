package bomberman;

import edu.princeton.cs.introcs.StdDraw;

public class Bombe {
	private int tailleFlamme;
	private int typeFlamme;
	private int delais;
	private int x;
	private int y;

	public Bombe(int x, int y) {
		this.x = x;
		this.y = y;
		this.delais = 3;
		this.typeFlamme = 0;
		this.tailleFlamme = 3;
	}

	public void exploser(Bombe bombe) {
		// Explosion !!
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

}
