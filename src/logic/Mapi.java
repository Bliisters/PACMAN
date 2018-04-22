package logic;

import javax.swing.ImageIcon;

import data.Data;

//nouvelletentativee

public class Mapi {
	
	private Data data = new Data();
	private int level;
	int mapWidth;
	int mapHeight;
	
	private int nbgommes=0;
	private int cmptGhosts = 1;
	private int cmptMange =10;
	private Element[][][] map;
	private Pacman pacman;
	private Blinky Blinky;
	private Inky Inky;
	private Pinky Pinky;
	private Clyde Clyde;
	private int score=0;
	private int vie=3;
	Background background = new Background(data.getSpriteTile(0));
	Block bloc= new Block(data.getSpriteTile(1));
	Gomme gomme = new Gomme(data.getSpriteTile(2));
	Supergomme supergomme = new Supergomme(data.getSpriteTile(3));
	Fruit fruit = new Fruit(data.getSpriteTile(4));
	
	boolean mort;
	
	public Mapi(int level) {
		
		this.mort=false;
		this.level=level;
		mapWidth = data.getMapiWidth(this.level);
		mapHeight = data.getMapiHeight(this.level);
		map = new Element[mapHeight][mapWidth][2];
		
		int[][] ini=data.getTableau(level);
			//System.out.println(ini.length+"  "+ini[0].length+"  "+map.length+"  "+map[0].length);
		for(int i=0;i<mapHeight;i++) {
			for(int j=0;j<mapWidth;j++){
				map[i][j][1]=null;
				if(ini[i][j]==0) {
					/**background**/
					map[i][j][0]=background;
				}
				else if(ini[i][j]==1) {
					/**Block**/
					map[i][j][0]=bloc;
				}
				else if(ini[i][j]==2) {
					/**gomme**/
					map[i][j][0]=gomme;
					this.nbgommes=this.nbgommes+1;
				}
				else if(ini[i][j]==3) {
					/**supergomme**/
					map[i][j][0]=supergomme;
					this.nbgommes=this.nbgommes+1;
				}
				else if(ini[i][j]==4) {
					/**fruit**/
					map[i][j][0]=fruit;
				}
				else if(ini[i][j]==5) {
					/**PAC-MAN !!!!**/
					pacman=new Pacman(i,j,data.getSpritePacMan(1));
					map[i][j][0]=pacman;
				}
				else if(ini[i][j]==6) {
					/**Blinky !!!! **/
					Blinky = new Blinky(i,j,data.getSpriteBlinky(1));
					map[i][j][1]=Blinky;
					map[i][j][0]=background;
				}
				else if(ini[i][j]==7) {
					/**Inky !!!! **/
					Inky = new Inky(i,j,data.getSpriteInky(1));
					map[i][j][1]=Inky;
					map[i][j][0]=background;
				}
				else if(ini[i][j]==8) {
					/**Pinky !!!! **/
					Pinky = new Pinky(i,j,data.getSpritePinky(1));
					map[i][j][1]=Pinky;
					map[i][j][0]=background;
				}
				else if(ini[i][j]==9) {
					/**Clyde !!!! **/
					Clyde = new Clyde(i,j,data.getSpriteClyde(1));
					map[i][j][1]=Clyde;
					map[i][j][0]=background;
				}
				
			}
		}
			
	}
	
	public ImageIcon[][] getTableau(String key){
		ImageIcon[][] im= new ImageIcon[mapHeight][mapWidth];  
		boolean MangeAll = false;
		boolean choc1=false;
		boolean choc2=false;
		boolean choc3=false;
		boolean choc4=false;
		//System.out.println(key);
		if(key.equals("INIT")){System.out.println(this.mort);}
		else{
			boolean v=movePACMAN(key);
			if(!v) {
				movePACMAN(this.pacman.getLastMove());
			}
			choc1 = moveBlinky(this.Blinky);
			choc2 = moveInky(this.Inky);
			choc3 = movePinky(this.Pinky);
			choc4 = moveClyde(this.Clyde);
			
			if(this.cmptMange<10) {
				this.cmptMange=this.cmptMange+1;
			}
			else {
				this.Blinky.setMangeable(false);
				this.Inky.setMangeable(false);
				this.Pinky.setMangeable(false);
				this.Clyde.setMangeable(false);
			}
		}
			if(choc1 || choc2 || choc3 ||choc4 || this.mort==true || key.equals("INIT")) {	//retour au d�part si Pacman touche un fantome
				if(((choc1 && this.Blinky.getMangeable()==false) || (choc2 && this.Inky.getMangeable()==false) || (choc3 && this.Pinky.getMangeable()==false) || (choc4 && this.Clyde.getMangeable()==false))&& this.mort==false) {
					this.vie=this.vie-1;
					MangeAll = true;
				}
				else if(this.mort==true) {}
				else {
					if(choc1) {
						this.cmptGhosts=this.cmptGhosts+1;
						this.Blinky.setMangeable(false);
						this.Blinky.setEstMange(true);
					}
					if(choc2) {
						this.cmptGhosts=this.cmptGhosts+1;
						this.Inky.setMangeable(false);
						this.Inky.setEstMange(true);
					}
					if(choc3) {
						this.cmptGhosts=this.cmptGhosts+1;
						this.Pinky.setMangeable(false);
						this.Pinky.setEstMange(true);
					}
					if(choc4) {
						this.cmptGhosts=this.cmptGhosts+1;
						this.Clyde.setMangeable(false);
						this.Clyde.setEstMange(true);
					}
					score=score+(this.cmptGhosts*200);				
				}
				
				reInit(this.mort);
				this.mort=false;
			}
		
		this.mort=MangeAll;
		if(this.mort) {
			for(int i=0;i<mapHeight;i++) {
				for(int j=0 ;j<mapWidth;j++) {
					if(map[i][j][0]==this.pacman) {
						//System.out.println(i+"    "+j);
						im[i][j]=data.getSpritePacMan(666);
					}
					else {
						im[i][j]=map[i][j][0].getSprite();
					}
				}
			}
		}
		else {
			for(int i=0;i<mapHeight;i++) {
				for(int j=0 ;j<mapWidth;j++) {
					if(map[i][j][1]==null) {
						//System.out.println(i+"    "+j);
						im[i][j]=map[i][j][0].getSprite();
					}
					else {
						im[i][j]=map[i][j][1].getSprite();
					}
				}
			}
		}
		//System.out.println(this.mort);
		return im;
	}
	
	
	
	private boolean movePACMAN(String k) {
		int x = this.pacman.getPosx();
		int y = this.pacman.getPosy();
		boolean verif=false;
		if(k.equals("UP")) {
			if (possiblemove(x-1,y)) {
				move(x,y,x-1,y);
				pacman.changeDirection(2);
				this.pacman.setLastMove("UP");
				verif=true;
			}
		}
		if(k.equals("DOWN")) {
			if (possiblemove(x+1,y)) {
				move(x,y,x+1,y);
				pacman.changeDirection(3);
				this.pacman.setLastMove("DOWN");
				verif=true;
			}
		}
		if(k.equals("LEFT")) {
			if (possiblemove(x,y-1)) {
				move(x,y,x,y-1);
				pacman.changeDirection(0);
				this.pacman.setLastMove("LEFT");
				verif=true;
			}
		}
		if(k.equals("RIGHT")) {
			if (possiblemove(x,y+1)) {
				move(x,y,x,y+1);
				pacman.changeDirection(1);
				this.pacman.setLastMove("RIGHT");
				verif=true;
			}
		}
		
		return verif;
	}

		
		private boolean possiblemove(int x,int y) {
			if (this.map[x][y][0].equals(this.bloc)) {
				return false;
			}
			else {
				return true;
			}
		}
		
		private void move(int x, int y, int dx, int dy) {
			if(this.map[dx][dy][0].equals(background)) {
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
			}
			if(this.map[dx][dy][0].equals(gomme)) {
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
				this.score=this.score+10;
				this.nbgommes=this.nbgommes-1;
			}
			if(this.map[dx][dy][0].equals(supergomme)) {
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
				this.score=this.score+50;
				this.nbgommes=this.nbgommes-1;
				this.cmptGhosts=1;
				this.cmptMange=0;
				this.Blinky.setMangeable(true);
				this.Inky.setMangeable(true);
				this.Pinky.setMangeable(true);
				this.Clyde.setMangeable(true);
			}
			if(this.map[dx][dy][0].equals(fruit)) {
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
				this.score=this.score+100;
			}
			
		}
		
		public int getScore(){
			return this.score;
		}
		
		public boolean moveGhost(Ghost F) {
			int x = F.getPosx();
			int y = F.getPosy();
			int L = F.getLastMove();
			int x1=0;
			int y1=0;
			int C=0;
			boolean choc=false;

			
			if(possiblemove(x,y-1)==false && possiblemove(x,y+1)==false && possiblemove(x+1,y)==false) {L=3;}			//Mouvement si impasse
			else if(possiblemove(x,y-1)==false && possiblemove(x,y+1)==false && possiblemove(x-1,y)==false) {L=2;}
			else if(possiblemove(x,y+1)==false && possiblemove(x-1,y)==false && possiblemove(x+1,y)==false) {L=1;}
			else if(possiblemove(x,y-1)==false && possiblemove(x-1,y)==false && possiblemove(x+1,y)==false) {L=0;}
			
			while(possiblemove(x1,y1)==false) {
				C=(int)(Math.random()*4);	
				while(C==4 || C==L){
					C=(int)(Math.random()*4);
				}				
				
				//move left
				if(C==0 ) {x1=x; y1=y-1;}
				
				//right
				else if(C==1) {x1=x; y1=y+1;}
					
				//UP
				else if(C==2) {x1=x-1; y1=y;}
				
				//DOWN
				else if(C==3) {x1=x+1; y1=y;}
				
			}
			if(F.getMangeable()==true && this.cmptMange<7) {
				F.changeDirection(9);
			}
			else if(F.getMangeable()==true && this.cmptMange>=7){
				F.changeDirection(8);
			}
			else { F.changeDirection(C); }
			
			this.map[x1][y1][1]=F;
			F.setLastMove(C);
			F.setPos(x1, y1);
			if(this.map[x][y][0]==this.pacman || this.map[x1][y1][0]==this.pacman) {
				choc=true;
			}
			if(this.map[x][y][1]==F) {
				this.map[x][y][1]=null;
			}
			return choc;			
		}
		
		
		public boolean followPM(Ghost F,int dx, int dy) {
			int x = F.getPosx();
			int y = F.getPosy();
			int L = F.getLastMove();
			int x1=0;
			int y1=0;
			int C=0;
			int pmx = dx;
			int pmy = dy;
			boolean choc=false;

			
			if(possiblemove(x,y-1)==false && possiblemove(x,y+1)==false && possiblemove(x+1,y)==false) {L=3;}			//Mouvement si impasse
			else if(possiblemove(x,y-1)==false && possiblemove(x,y+1)==false && possiblemove(x-1,y)==false) {L=2;}
			else if(possiblemove(x,y+1)==false && possiblemove(x-1,y)==false && possiblemove(x+1,y)==false) {L=1;}
			else if(possiblemove(x,y-1)==false && possiblemove(x-1,y)==false && possiblemove(x+1,y)==false) {L=0;}
			
			double[] dist = {(Math.sqrt(Math.pow(pmx-x, 2.0)+Math.pow(pmy-y+1,2))),
					(Math.sqrt(Math.pow(pmx-x, 2)+Math.pow(pmy-y-1,2))),
					(Math.sqrt(Math.pow(pmx-x+1, 2)+Math.pow(pmy-y,2))),
					(Math.sqrt(Math.pow(pmx-x-1, 2)+Math.pow(pmy-y ,2)))};

			if (L<5)dist[L] = 99;
			
			
			while(possiblemove(x1,y1)==false) {			
				//System.out.println(dist[0]+"   "+dist[1]+"   "+dist[2]+"   "+dist[3]);
				//System.out.println(Blinky.getPosx()+"   "+Blinky.getPosy()+"   "+pacman.getPosx()+"   "+pacman.getPosy());
				//move left
				if(dist[0]<=dist[1] && dist[0]<= dist[2] && dist[0]<=dist[3]) {
					x1=x; y1=y-1;dist[0]=99;/*System.out.println("Pacman est � gauche")*/;C=0;}
				
				//right
				else if(dist[1]<= dist[2] && dist[1]<=dist[3]) {
					x1=x; y1=y+1;dist[1]=99;/*System.out.println("Pacman est � droite")*/;C=1;}
					
				//UP
				else if(dist[2]<=dist[3]) {
					x1=x-1; y1=y; dist[2] = 99;/*System.out.println("Pacman est en haut")*/;C=2;}
				
				//DOWN
				else{x1=x+1; y1=y; dist[3] = 99;/*System.out.println("Pacman est en bas")*/;C=3;  }
				
			}
			
			if(F.getMangeable()==true && this.cmptMange<7) {
				F.changeDirection(9);
			}
			else if(F.getMangeable()==true && this.cmptMange>=7){
				F.changeDirection(8);
			}
			else if(F.getEstMange()) {
				if(F.getPosIniX()==x1 && F.getPosIniY()==y1) {
					F.setEstMange(false);
					F.changeDirection(0);
				}
				else {
					F.changeDirection(C+4);
				}
				
			}
			else { F.changeDirection(C); }
			
			this.map[x1][y1][1]=F;
			F.setLastMove(C);
			F.setPos(x1, y1);
			if(this.map[x][y][0]==this.pacman || this.map[x1][y1][0]==this.pacman) {
				choc=true;
			}
			if(this.map[x][y][1]==F) {
				this.map[x][y][1]=null;
			}
			return choc;			
		}
		
		
		public boolean runAway(Ghost F) {
			int x = F.getPosx();
			int y = F.getPosy();
			int L = F.getLastMove();
			int x1=0;
			int y1=0;
			int C=0;
			int pmx = this.pacman.getPosx();
			int pmy = this.pacman.getPosy();
			boolean choc=false;

			
			if(possiblemove(x,y-1)==false && possiblemove(x,y+1)==false && possiblemove(x+1,y)==false) {L=3;}			//Mouvement si impasse
			else if(possiblemove(x,y-1)==false && possiblemove(x,y+1)==false && possiblemove(x-1,y)==false) {L=2;}
			else if(possiblemove(x,y+1)==false && possiblemove(x-1,y)==false && possiblemove(x+1,y)==false) {L=1;}
			else if(possiblemove(x,y-1)==false && possiblemove(x-1,y)==false && possiblemove(x+1,y)==false) {L=0;}
			
			double[] dist = {(Math.sqrt(Math.pow(pmx-x, 2.0)+Math.pow(pmy-y-1,2))),
					(Math.sqrt(Math.pow(pmx-x, 2)+Math.pow(pmy-y+1,2))),
					(Math.sqrt(Math.pow(pmx-x-1, 2)+Math.pow(pmy-y,2))),
					(Math.sqrt(Math.pow(pmx-x+1, 2)+Math.pow(pmy-y ,2)))};

			if (L<5)dist[L] = 99; ////
			
			
			while(possiblemove(x1,y1)==false) {			
				//System.out.println(dist[0]+"   "+dist[1]+"   "+dist[2]+"   "+dist[3]);
				//System.out.println(Blinky.getPosx()+"   "+Blinky.getPosy()+"   "+pacman.getPosx()+"   "+pacman.getPosy());
				//move left
				if(dist[0]<=dist[1] && dist[0]<= dist[2] && dist[0]<=dist[3]) {
					x1=x; y1=y-1;dist[0]=99;/*System.out.println("Pacman est � gauche")*/;C=0;}
				
				//right
				else if(dist[1]<= dist[2] && dist[1]<=dist[3]) {
					x1=x; y1=y+1;dist[1]=99;/*System.out.println("Pacman est � droite")*/;C=1;}
					
				//UP
				else if(dist[2]<=dist[3]) {
					x1=x-1; y1=y; dist[2] = 99;/*System.out.println("Pacman est en haut")*/;C=2;}
				
				//DOWN
				else{x1=x+1; y1=y; dist[3] = 99;/*System.out.println("Pacman est en bas")*/;C=3;  }
				
			}
			
			if(F.getMangeable()==true && this.cmptMange<7) {
				F.changeDirection(9);
			}
			else if(F.getMangeable()==true && this.cmptMange>=7){
				F.changeDirection(8);
			}
			else { F.changeDirection(C); }
			
			this.map[x1][y1][1]=F;
			F.setLastMove(C);
			F.setPos(x1, y1);
			if(this.map[x][y][0]==this.pacman || this.map[x1][y1][0]==this.pacman) {
				choc=true;
			}
			if(this.map[x][y][1]==F) {
				this.map[x][y][1]=null;
			}
			return choc;			
		}
		
		
		public boolean moveBlinky(Ghost blinky) {
			if (blinky.getMangeable() == true)
				return runAway(blinky);
			else if(blinky.getEstMange()) {
				return followPM(blinky,blinky.getPosIniX(),blinky.getPosIniY());
			}
			else 
				return followPM(blinky,this.pacman.getPosx(),this.pacman.getPosy());
		}
		
		
		public boolean movePinky(Ghost pinky) {
			if (pinky.getMangeable() == true)
				return runAway(pinky);
			else if(pinky.getEstMange()) {
				return followPM(pinky,pinky.getPosIniX(),pinky.getPosIniY());
			}
			else {
				int alea = (int)(Math.random()*3);
				if(alea > 0)
					return followPM(pinky,this.pacman.getPosx(),this.pacman.getPosy());
				else
					return moveGhost(pinky);
			}
		}
		
		public boolean moveInky(Ghost inky) {
			if (inky.getMangeable() == true)
				return runAway(inky);
			
			else if(inky.getEstMange()) {
				return followPM(inky,inky.getPosIniX(),inky.getPosIniY());
			}
			else 
				return moveGhost(inky);
		}
		
		public boolean moveClyde(Ghost clyde) {
			if (clyde.getMangeable() == true)
				return runAway(clyde);
			
			else if(clyde.getEstMange()) {
				return followPM(clyde,clyde.getPosIniX(),clyde.getPosIniY());
			}
			else {
				int alea = (int)(Math.random()*3);
				if(alea > 0)
					return followPM(clyde,this.pacman.getPosx(),this.pacman.getPosy());
				else
					return runAway(clyde);
			}
		}
		
		
		public void reInit(boolean P) {
			//PAC-MAN : 
			if(P) {
				this.map[this.pacman.getPosx()][this.pacman.getPosy()][0]=background;
				this.map[this.pacman.getPosIniX()][this.pacman.getPosIniY()][0]=this.pacman;
				this.pacman.setPos(this.pacman.getPosIniX(), this.pacman.getPosIniY());
			}
			
			//Blinky
			if(P) {
				this.map[this.Blinky.getPosx()][this.Blinky.getPosy()][1]=null;
				this.map[this.Blinky.getPosIniX()][this.Blinky.getPosIniY()][1]=this.Blinky;
				this.Blinky.setPos(this.Blinky.getPosIniX(), this.Blinky.getPosIniY());
				this.Blinky.changeDirection(0);
			}
			
			
			//Inky
			if(P) {
				this.map[this.Inky.getPosx()][this.Inky.getPosy()][1]=null;
				this.map[this.Inky.getPosIniX()][this.Inky.getPosIniY()][1]=this.Inky;
				this.Inky.setPos(this.Inky.getPosIniX(), this.Inky.getPosIniY());
				this.Inky.changeDirection(0);
			}
			//Pinky
			if(P) {
				this.map[this.Pinky.getPosx()][this.Pinky.getPosy()][1]=null;
				this.map[this.Pinky.getPosIniX()][this.Pinky.getPosIniY()][1]=this.Pinky;
				this.Pinky.setPos(this.Pinky.getPosIniX(), this.Pinky.getPosIniY());
				this.Pinky.changeDirection(0);
			}
			//Clyde
			if(P) {
				this.map[this.Clyde.getPosx()][this.Clyde.getPosy()][1]=null;
				this.map[this.Clyde.getPosIniX()][this.Clyde.getPosIniY()][1]=this.Clyde;
				this.Clyde.setPos(this.Clyde.getPosIniX(), this.Clyde.getPosIniY());
				this.Clyde.changeDirection(0);
			}
		}
		
		public int getNbLife(){
			return this.vie;
		}
		public boolean checkFinish(){
			if(this.nbgommes>0){return false;}
			else{return true;}
		}
		
		public boolean checkMort(){
			return this.mort;
		}
}