package test_map_liste;
import java.awt.Font;

import edu.princeton.cs.introcs.*;

public class IG {
//Déclaration de la taille de la map
	
//N est un nombre arbitrairement choisie pour faire une fenêtre de la bonne dimension
public int N=50;
//l est la longeur
public int l=21;
//L est la largeur
public int L=17;
	public void intialisation_ecran(){
		
		StdDraw.setCanvasSize(l*N,L*N);
		//On défini le nombre de case en graduant notre fenêtre
		StdDraw.setXscale(0,l);
		StdDraw.setYscale(0,L);
		StdDraw.clear(StdDraw.GRAY);	
	}
	
	public void ecran_de_demarrage(){
		Font font =new Font("Arial",Font.BOLD,40);
		StdDraw.enableDoubleBuffering();
		
		while(true){
			StdDraw.setPenColor();
			StdDraw.setFont(font);
			StdDraw.text(11, 8, "JB t'es pas beau :) <3");
			if(StdDraw.mousePressed()){
				break;
			}
			StdDraw.show();
		}
	}
	
	public void ecran_de_jeu(int[][] map){
		//Colorisation de la map
		for(int y=0; y<L; y++){
			for(int x=0; x<l; x++){
				if(map[y][x] == 0){
					StdDraw.setPenColor(StdDraw.GRAY);
					StdDraw.filledSquare(x+0.5, y+0.5, 0.5);
				}
				else if(map[y][x]==1){
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledSquare(x+0.5, y+0.5, 0.5);
				}
				else if(map[y][x]==2){
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.filledSquare(x+0.5, y+0.5, 0.5);
				}
				
			}
			
		}
		
		/*Test d'écriture
		 * 
		 * Font font =new Font("DialogInput", Font.CENTER_BASELINE, 70);
		StdDraw.setPenColor();
		StdDraw.setFont(font);
		StdDraw.text(11, 8, "Test");
		while(true){
			StdDraw.show();
			StdDraw.pause(300);
			if(StdDraw.mousePressed()){
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.filledSquare(13.5, 8.5, 0.5);
			}
			
		}	*/
		
	}
}
