package bomberman;


public class Joueur{
	
	private String nom;
	private int vie;
	//Nombres de bombes total
	private int nbbombes;
	//Nombre de bombes posés
	private int counterbombes;
	
	private int typebombes;
	private int tailleFlamme;
	private int delai;
	private int x;
	private int y;
	
	
	public Joueur(String nom,int x,int y){
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.vie =3;
		this.nbbombes = 3;
		this.typebombes = 1;
		this.tailleFlamme = 3;
		this.counterbombes = 0;
		this.setDelai(4000);	
	}
	
	//Deplacement
	public void moveRight(Joueur j, int[][] map){
		if(map[y][x+1]==2 ||map[y][x+1]>=4){
			j.x+=1;
			System.out.println("Le joueur " +j.nom+" se déplace a droite.");
		} 	
		else {
			System.out.println("Mouvement impossible.");
		}
	}
	public void moveLeft(Joueur j, int[][] map){
		if(map[y][x-1] ==2 || map[y][x-1]>=4){
			j.x-=1;
			System.out.println("Le joueur " +j.nom+" se déplace a gauche.");
		}else{
			System.out.println("Mouvement impossible.");
		}
	}
	public void moveUp(Joueur j, int[][] map){
		if(map[y+1][x]==2 || map[y+1][x]>=4){
			j.y+=1;
			System.out.println("Le joueur " +j.nom+" se déplace vers le haut.");
		}else{
			System.out.println("Mouvement impossible.");
		}
	}
	public void moveDown(Joueur j, int[][] map){
		if(map[y-1][x] ==2 || map[y-1][x]>=4){
			j.y-=1;
			System.out.println("Le joueur " +j.nom+" se déplace vers le bas.");
		}else{
			System.out.println("Mouvement impossible.");
		}
	}
	
	//Getters&Setters
	public String getNom(){
		return nom;
	}
	//Pour moi elle est inutile
	public void setNom(String nom){
		this.nom =nom;
	}
	public int getVie(){
		return vie;
	}
	public void setVie(int a){
		this.vie= a;
	}
	public int getNbbombes(){
		return nbbombes;
	}
	public void setNbbombes(int nbbombes){
		if(this.nbbombes <= 7 && this.nbbombes > 1) {
			this.nbbombes=nbbombes;
		}
		
	}
	public int getTypebombes(){
		return typebombes;
	}
	public void setTypebombes(int typebombes){
		this.typebombes= typebombes;
	}
	public int getX(){
		return x;
	}
	public void setX(int a){
		this.x=a;
	}
	public int getY(){
		return y;
	}
	public void setY(int a){
		this.y=a;
	}

	public int getTailleFlamme() {
		return tailleFlamme;
	}

	public void setTailleFlamme(int tailleFlamme) {
		if(this.tailleFlamme <= 10 && this.tailleFlamme >= 1) {
			this.tailleFlamme = tailleFlamme;
		}
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	public void reset() {
		this.nbbombes = 3;
		this.typebombes = 1;
		this.tailleFlamme = 3;
		this.setDelai(4000);	
	}

	public int getCounterbombes() {
		return counterbombes;
	}

	public void setCounterbombes(int counterbombes) {
		this.counterbombes = counterbombes;
	}
	
		
}