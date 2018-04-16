package logic;

import javax.swing.ImageIcon;

import data.Data;



public class Mapi {
	
	private Data data = new Data();
	private int level = 1;
	int mapWidth = data.getMapiWidth(level);
	int mapHeight = data.getMapiHeight(level);
	
	private Element[][][] map = new Element[mapHeight][mapWidth][2];
	private Pacman pacman;
	private Blinky Blinky;
	private Inky	Inky;
	private Pinky Pinky;
	private Clyde Clyde;
	private int score=0;
	private int vie=3;
	Background background = new Background(data.getSpriteTile(0));
	Block bloc= new Block(data.getSpriteTile(1));
	Gomme gomme = new Gomme(data.getSpriteTile(2));
	Supergomme supergomme = new Supergomme(data.getSpriteTile(3));
	Fruit fruit = new Fruit(data.getSpriteTile(4));

	
	public Mapi() {
		int[][] ini=data.getTableau(level);
			System.out.println(ini.length+"  "+ini[0].length+"  "+map.length+"  "+map[0].length);
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
				}
				else if(ini[i][j]==3) {
					/**supergomme**/
					map[i][j][0]=supergomme;
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
		moveGhost(this.Blinky);
		moveGhost(this.Inky);
		moveGhost(this.Pinky);
		moveGhost(this.Clyde);
		boolean choc=movePACMAN(key);
		if(choc) {	//retour au départ si Pacman touche un fantome
			
			this.vie=this.vie-1;
			
			//PAC-MAN : 
			this.map[this.pacman.getPosx()][this.pacman.getPosy()][0]=background;
			this.map[this.pacman.getPosIniX()][this.pacman.getPosIniY()][0]=this.pacman;
			this.pacman.setPos(this.pacman.getPosIniX(), this.pacman.getPosIniY());
			
			//Blinky
			this.map[this.Blinky.getPosx()][this.Blinky.getPosy()][1]=null;
			this.map[this.Blinky.getPosIniX()][this.Blinky.getPosIniY()][1]=this.Blinky;
			this.Blinky.setPos(this.Blinky.getPosIniX(), this.Blinky.getPosIniY());
			
			//Inky
			this.map[this.Inky.getPosx()][this.Inky.getPosy()][1]=null;
			this.map[this.Inky.getPosIniX()][this.Inky.getPosIniY()][1]=this.Inky;
			this.Inky.setPos(this.Inky.getPosIniX(), this.Inky.getPosIniY());
			
			//Pinky
			this.map[this.Pinky.getPosx()][this.Pinky.getPosy()][1]=null;
			this.map[this.Pinky.getPosIniX()][this.Pinky.getPosIniY()][1]=this.Pinky;
			this.Pinky.setPos(this.Pinky.getPosIniX(), this.Pinky.getPosIniY());
			
			//Clyde
			this.map[this.Clyde.getPosx()][this.Clyde.getPosy()][1]=null;
			this.map[this.Clyde.getPosIniX()][this.Clyde.getPosIniY()][1]=this.Clyde;
			this.Clyde.setPos(this.Clyde.getPosIniX(), this.Clyde.getPosIniY());
		}
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
		return im;
	}
	private boolean movePACMAN(String k) {
		boolean choc=false;
		if(map[this.pacman.getPosx()][this.pacman.getPosy()][1]!=null) {choc=true;}
		if(k.equals("UP")) {
			moveUP();
		}
		if(k.equals("DOWN")) {
			moveDOWN();
		}
		if(k.equals("LEFT")) {
			moveLEFT();
		}
		if(k.equals("RIGHT")) {
			moveRIGHT();
		}
		if(map[this.pacman.getPosx()][this.pacman.getPosy()][1]!=null) {choc=true;}
		return choc;
	}
	public void moveLEFT() {
		int x = this.pacman.getPosx();
		int y = this.pacman.getPosy();
		if (possiblemove(x,y-1)) {
			move(x,y,x,y-1);
			pacman.changeDirection(0);
		}
	}
	
	public void moveRIGHT() {
		int x = this.pacman.getPosx();
		int y = this.pacman.getPosy();
		if (possiblemove(x,y+1)) {
			move(x,y,x,y+1);
			pacman.changeDirection(1);
		}
	}
	public void moveUP() {
		int x = this.pacman.getPosx();
		int y = this.pacman.getPosy();
		if (possiblemove(x-1,y)) {
			move(x,y,x-1,y);
			pacman.changeDirection(2);
		}
	}
		public void moveDOWN() {
			int x = this.pacman.getPosx();
			int y = this.pacman.getPosy();
			if (possiblemove(x+1,y)) {
				move(x,y,x+1,y);
				pacman.changeDirection(3);
			}

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
			}
			if(this.map[dx][dy][0].equals(supergomme)) {
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
				this.score=this.score+50;
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
		
		public void moveGhost(Ghost F) {
			int x = F.getPosx();
			int y = F.getPosy();
			int L = F.getLastMove();
			int x1=0;
			int y1=0;
			int C=0;

			
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
			F.changeDirection(C);
			this.map[x1][y1][1]=F;
			F.setLastMove(C);
			F.setPos(x1, y1);
			if(this.map[x][y][1]==F) {
				this.map[x][y][1]=null;
			}
						
		}
		
		public int getNbLife(){
			if(this.vie<1){return 1;}
			else{return this.vie;}
		}

}
