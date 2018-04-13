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
	private int score=0;
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
				
			}
		}
			
	}
	
	public ImageIcon[][] getTableau(String key){
		ImageIcon[][] im= new ImageIcon[mapHeight][mapWidth];  
		moveBlinky();
		movePACMAN(key);
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
	private void movePACMAN(String k) {
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
		
	}
	public void moveLEFT() {
		int x = this.pacman.getPosx();
		int y = this.pacman.getPosy();
		if (possiblemove(x,y-1)) {
			move(x,y,x,y-1);
			pacman.changeDirection(3);
		}
	}
	
	public void moveRIGHT() {
		int x = this.pacman.getPosx();
		int y = this.pacman.getPosy();
		if (possiblemove(x,y+1)) {
			move(x,y,x,y+1);
			pacman.changeDirection(2);
		}
	}
	public void moveUP() {
		int x = this.pacman.getPosx();
		int y = this.pacman.getPosy();
		if (possiblemove(x-1,y)) {
			move(x,y,x-1,y);
			pacman.changeDirection(0);
		}
	}
		public void moveDOWN() {
			int x = this.pacman.getPosx();
			int y = this.pacman.getPosy();
			if (possiblemove(x+1,y)) {
				move(x,y,x+1,y);
				pacman.changeDirection(1);
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
			System.out.println("rentré move");
			if(this.map[dx][dy][0].equals(background)) {
				System.out.println("rentré b"+score);
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
			}
			if(this.map[dx][dy][0].equals(gomme)) {
				System.out.println("rentré g");
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
				this.score=this.score+10;
			}
			if(this.map[dx][dy][0].equals(supergomme)) {
				System.out.println("rentré sg");
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
				this.score=this.score+50;
			}
			if(this.map[dx][dy][0].equals(fruit)) {
				System.out.println("rentré f");
				this.map[dx][dy][0]=pacman;
				this.pacman.setPos(dx, dy);
				this.map[x][y][0]=background;
				this.score=this.score+100;
			}
			
		}
		
		public int getScore(){
			return this.score;
		}
		
		public void moveBlinky() {
			int x = this.Blinky.getPosx();
			int y = this.Blinky.getPosy();
			int x1=0;
			int y1=0;
			while(possiblemove(x1,y1)==false) {
				
				int C=(int)(Math.random()*4);
				while(C==4){
					C=(int)(Math.random()*4);
				}
				
				//int C=1;
				//move left
				if(C==0) {
					x1=x;
					y1=y-1;
				}
				//right
				else if(C==1) {
					x1=x;
					y1=y+1;
				}
				//UP
				else if(C==2) {
					x1=x-1;
					y1=y;
				}
				//DOWN
				else if(C==3) {
					x1=x+1;
					y1=y;
				}
			}
			this.map[x1][y1][1]=Blinky;
			this.Blinky.setPos(x1, y1);
			this.map[x][y][1]=null;
			
			
		}

}
