package view;

import javax.swing.ImageIcon;

public class Test {
	
	ImageIcon[][] Tableau;
	int taille=15;
	
	ImageIcon wall;
	ImageIcon background;
	
	public Test(){
		
		int[][] base = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
						{1,0,0,0,0,0,1,1,1,0,0,0,0,0,1},
						{1,0,1,0,1,0,0,1,0,0,1,0,1,0,1},
						{1,0,1,0,1,1,0,1,0,1,1,0,1,0,1},
						{1,0,1,0,0,1,0,1,0,1,0,0,1,0,1},
						{1,0,1,1,0,0,0,0,0,0,0,1,1,0,1},
						{1,0,0,0,0,1,1,0,1,1,0,0,0,0,1},
						{1,0,1,1,0,1,0,0,0,1,0,1,1,0,1},
						{1,0,1,0,0,1,1,1,1,1,0,0,1,0,1},
						{1,0,0,0,1,1,1,0,1,1,1,0,0,0,1},
						{1,0,1,0,1,0,0,0,0,0,1,0,1,0,1},
						{1,0,1,0,0,0,1,0,1,0,0,0,1,0,1},
						{1,0,1,1,0,1,1,0,1,1,0,1,1,0,1},
						{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
						{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},};
		
		wall=new ImageIcon("images/spriteWall.png");
		background=new ImageIcon("images/spriteBackground.png");
		
		this.Tableau=new ImageIcon[taille][taille];
		
		/*for(int i = 0; i <= taille-1; i++){
			Tableau[0][i]=wall;
			Tableau[taille-1][i]=wall;
		}
		
		for(int i = 0; i <= taille-1; i++){
			Tableau[i][0]=wall;
			Tableau[i][taille-1]=wall;
		}*/
		
		for(int i = 0; i <= taille-1; i++){
			for(int j = 0; j <= taille-1; j++){
				if(base[j][i]==0){Tableau[i][j]=background;}
				if(base[j][i]==1){Tableau[i][j]=wall;}
			}
		}
		
	}
	
	public ImageIcon[][] getTableau(){
		return this.Tableau;
	}
	
	public int getNbCases(){
		return taille;
	}
	
	public int getNbPixelSprite(){
		return 32;
	}
	
	public ImageIcon getSprite(int i){
		if(i==1){return new ImageIcon("images/pacmanLife.png");}
		else{return new ImageIcon("images/pacmanLife.png");}
	}
	
	public int getNbLife(){
		return 3;
	}
	
	public int getNbLifeMax(){
		return 3;
	}
	
	public String getScore(){
		return "1000";
	}
}
