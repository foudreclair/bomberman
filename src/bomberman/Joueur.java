package bomberman;

import java.util.ArrayList;

import edu.princeton.cs.introcs.*;

public class Joueur{
	
	private String nom;
	private int vie;
	private int nbbombes;
	private int typebombes;
	private int longeurflame;
	private int x;
	private int y;
	
	
	public Joueur(String nom,int x,int y){
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.vie =3;
		this.nbbombes = 3;
		this.typebombes = 1;
		this.longeurflame =2;
	
	}
	//Check le nombre de bombe
	public boolean checkNbBombes(Joueur j) {
		if(j.getNbbombes() > 0) {
			j.setNbbombes(j.getNbbombes()-1);
			return true;
		}
		else {
			return false;
		}
	}
	
	//Deplacement
	public void moveRight(Joueur j, int[][] map){
		if(map[y][x+1]==2){
			j.x+=1;
			System.out.println("Le joueur " +j.nom+" se d�place a droite.");
		} 	
		else {
			System.out.println("Mouvement impossible.");
		}
	}
	public void moveLeft(Joueur j, int[][] map){
		if(map[y][x-1] ==2){
			j.x-=1;
			System.out.println("Le joueur " +j.nom+" se d�place a gauche.");
		}else{
			System.out.println("Mouvement impossible.");
		}
	}
	public void moveUp(Joueur j, int[][] map){
		if(map[y+1][x]==2){
			j.y+=1;
			System.out.println("Le joueur " +j.nom+" se d�place vers le haut.");
		}else{
			System.out.println("Mouvement impossible.");
		}
	}
	public void moveDown(Joueur j, int[][] map){
		if(map[y-1][x] ==2){
			j.y-=1;
			System.out.println("Le joueur " +j.nom+" se d�place vers le bas.");
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
		this.nbbombes=nbbombes;
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
	
}