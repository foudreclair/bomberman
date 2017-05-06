import edu.princeton.cs.introcs.StdDraw;

public class Map {
	
	public Map(){
		int N=50;
		StdDraw.setCanvasSize(21*N,17*N);
		//A scanner 
		//l: longeur
		int l=21;
		//L: Largeur
		int L=17;
		StdDraw.setXscale(0, l);
		StdDraw.setYscale(0,L);
		
		//Realisation du fond en mode full destrutible 
		for(int i=0;i<l;i++){
			for(int j=0;j<L;j++){
				if ((j%2)==0 && (i%2)==0){
					StdDraw.setPenColor(StdDraw.GRAY);
				}
				else if(i==0 || j==0 ||j==L-1 ||i==l-1){
					StdDraw.setPenColor(StdDraw.GRAY);
				}else if((i==1&&j==1)||(i==1&&j==2)||(i==1&&j==3)||(i==2&&j==1)||(i==2&&j==3)||(i==3&&j==1)||(i==3&&j==2)||(i==19&&j==15)||(i==19&&j==14)||(i==19&&j==13)||(i==18&&j==15)||(i==18&&j==13)||(i==17&&j==15)||(i==17&&j==14)){
					StdDraw.setPenColor(StdDraw.GREEN);
				}else{
				StdDraw.setPenColor(StdDraw.ORANGE);
				}
				
				StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
			}
		}
		StdDraw.show();	
	}
	//Test map V1
	/*
	for(int i=0; i<l; i++){
		for(int j=0;j<L;j++){
			if((i+j)%2==0){
				StdDraw.setPenColor(StdDraw.GRAY);
			}else{
				StdDraw.setPenColor(StdDraw.ORANGE);
			}
			StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
		}
	}*/
}
