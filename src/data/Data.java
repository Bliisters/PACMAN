package data;


import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Data implements DataGetters{
	
	File sauvegardeScore;
    ObjectInputStream ois;
    ObjectOutputStream oos;
	
	public Data(){
		
		sauvegardeScore=new File("files/score.txt");
		
	}
	
	@Override
	public int getMapiWidth(int i){
		
		String map = "files/maps/map"+Integer.toString(i)+".txt";
		BufferedReader br;
		int res = -1;
		
		try {
			br = new BufferedReader(new FileReader(map));
			res= Integer.parseInt(br.readLine());
			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return res;
	}
	
	@Override
	public int getMapiHeight(int i){
		
		String map = "files/maps/map"+Integer.toString(i)+".txt";
		BufferedReader br;
		int res = -1;
		
		try {
			br = new BufferedReader(new FileReader(map));
			br.readLine();
			res= Integer.parseInt(br.readLine());
			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return res;
	}
	
	@Override
	public int[][] getTableau(int i){
		
		String map = "files/maps/map"+Integer.toString(i)+".txt";
		int[][] mapy = new int[getMapiHeight(i)][getMapiWidth(i)];
		String line;
		BufferedReader br;
		int lineCounter = 0;
		
		try {
			
			br = new BufferedReader(new FileReader(map));
			br.readLine();
			br.readLine();
			
			while ((line = br.readLine()) != null) {
				
				for(int j=0; j<getMapiWidth(i);j++) {
				/*
					
					if (line.split("-")[j].equals("05")) {
						mapy[j][lineCounter][0] = 0;
						mapy[j][lineCounter][1] = 5;
					}
					
					else if (line.split("-")[j].equals("06")) {
						mapy[j][lineCounter][0] = 0;
						mapy[j][lineCounter][2] = 6;
					}
					
					else if (line.split("-")[j].equals("07")) {
						mapy[j][lineCounter][0] = 0; 
						mapy[j][lineCounter][3] = 7;
					}
					
					else if (line.split("-")[j].equals("08")) {
						mapy[j][lineCounter][0] = 0;
						mapy[j][lineCounter][4] = 8;
					}
					
					else if (line.split("-")[j].equals("09")) {
						mapy[j][lineCounter][0] = 0;
						mapy[j][lineCounter][5] = 9;
					}
					
					else */mapy[lineCounter][j] = Integer.parseInt(line.split("-")[j]);
					
				}
				lineCounter++;
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mapy; 
	}

	@Override
	public ImageIcon getSpritePacMan(int i) {
		switch (i)
		{
		  case 2:
			  return new ImageIcon("images/characters/pacman/pacmanGIFHv2.gif");
		  case 3:
			  return new ImageIcon("images/characters/pacman/pacmanGIFBv2.gif");
		  case 1:
			  return new ImageIcon("images/characters/pacman/pacmanGIFDv2.gif");
		  case 0:
			  return new ImageIcon("images/characters/pacman/pacmanGIFGv2.gif");
		  default:
			  return new ImageIcon("images/characters/pacman/pacmanGIFDv2.gif");             
		}
	}

	@Override
	public ImageIcon getSpriteBlinky(int i) {
		switch (i)
		{
		  case 2:
			  return new ImageIcon("images/characters/blinky/blinky_up.gif");
		  case 3:
			  return new ImageIcon("images/characters/blinky/blinky_down.gif");
		  case 1:
			  return new ImageIcon("images/characters/blinky/blinky_right.gif");
		  case 0:
			  return new ImageIcon("images/characters/blinky/blinky_left.gif");
		  case 6:
			  return new ImageIcon("images/characters/blinky/blinky_killed_up.png");
		  case 7:
			  return new ImageIcon("images/characters/blinky/blinky_killed_down.png");
		  case 5:
			  return new ImageIcon("images/characters/blinky/blinky_killed_right.png");
		  case 4:
			  return new ImageIcon("images/characters/blinky/blinky_killed_left.png");
		  case 8:
			  return new ImageIcon("images/characters/blinky/blinky_danger_white.gif");
		  case 9:
			  return new ImageIcon("images/characters/blinky/blinky_danger_blue.gif");
		  default:
			  return new ImageIcon("images/characters/blinky/blinky_left.gif");           
		}
	}

	@Override
	public ImageIcon getSpritePinky(int i) {
		switch (i)
		{
		  case 2:
			  return new ImageIcon("images/characters/pinky/pinky_up.gif");
		  case 3:
			  return new ImageIcon("images/characters/pinky/pinky_down.gif");
		  case 1:
			  return new ImageIcon("images/characters/pinky/pinky_right.gif");
		  case 0:
			  return new ImageIcon("images/characters/pinky/pinky_left.gif");
		  case 6:
			  return new ImageIcon("images/characters/pinky/pinky_killed_up.png");
		  case 7:
			  return new ImageIcon("images/characters/pinky/pinky_killed_down.png");
		  case 5:
			  return new ImageIcon("images/characters/pinky/pinky_killed_right.png");
		  case 4:
			  return new ImageIcon("images/characters/pinky/pinky_killed_left.png");
		  case 8:
			  return new ImageIcon("images/characters/pinky/pinky_danger_white.gif");
		  case 9:
			  return new ImageIcon("images/characters/pinky/pinky_danger_blue.gif");
		  default:
			  return new ImageIcon("images/characters/pinky/pinky_left.gif");           
		}
	}

	@Override
	public ImageIcon getSpriteInky(int i) {
		switch (i)
		{
		  case 2:
			  return new ImageIcon("images/characters/inky/inky_up.gif");
		  case 3:
			  return new ImageIcon("images/characters/inky/inky_down.gif");
		  case 1:
			  return new ImageIcon("images/characters/inky/inky_right.gif");
		  case 0:
			  return new ImageIcon("images/characters/inky/inky_left.gif");
		  case 6:
			  return new ImageIcon("images/characters/inky/inky_killed_up.png");
		  case 7:
			  return new ImageIcon("images/characters/inky/inky_killed_down.png");
		  case 5:
			  return new ImageIcon("images/characters/inky/inky_killed_right.png");
		  case 4:
			  return new ImageIcon("images/characters/inky/inky_killed_left.png");
		  case 8:
			  return new ImageIcon("images/characters/inky/inky_danger_white.gif");
		  case 9:
			  return new ImageIcon("images/characters/inky/inky_danger_blue.gif");
		  default:
			  return new ImageIcon("images/characters/inky/inky_left.gif");           
		}
	}

	@Override
	public ImageIcon getSpriteClyde(int i) {
		switch (i)
		{
		  case 2:
			  return new ImageIcon("images/characters/clyde/clyde_up.gif");
		  case 3:
			  return new ImageIcon("images/characters/clyde/clyde_down.gif");
		  case 1:
			  return new ImageIcon("images/characters/clyde/clyde_right.gif");
		  case 0:
			  return new ImageIcon("images/characters/clyde/clyde_left.gif");
		  case 6:
			  return new ImageIcon("images/characters/clyde/clyde_killed_up.png");
		  case 7:
			  return new ImageIcon("images/characters/clyde/clyde_killed_down.png");
		  case 5:
			  return new ImageIcon("images/characters/clyde/clyde_killed_right.png");
		  case 4:
			  return new ImageIcon("images/characters/clyde/clyde_killed_left.png");
		  case 8:
			  return new ImageIcon("images/characters/clyde/clyde_danger_white.gif");
		  case 9:
			  return new ImageIcon("images/characters/clyde/clyde_danger_blue.gif");
		  default:
			  return new ImageIcon("images/characters/clyde/clyde_left.gif");           
		}
	}

	@Override
	public ImageIcon getSpriteTile(int i) {
		switch (i)
		{
		  case 0:
			  return new ImageIcon("images/mapElement/spriteBackground.png");
		  case 1:
			  return new ImageIcon("images/mapElement/spriteWall.png");
		  case 2:
			  return new ImageIcon("images/mapElement/spriteGomme.png");
		  case 3:
			  return new ImageIcon("images/mapElement/spriteBigGomme.png");
		  case 4:
			  return new ImageIcon("images/mapElement/spriteCherry.png");
		  default:
			  return new ImageIcon("images/mapElement/spriteBackground.png");             
		}
	}

	
	@Override
	public Image getSpriteMenuImage(int i) {
		Image img = null;
		switch (i)
		{
		  case 0:
			  //return new Image("images/menuIcons/iconPACMAN.png");
			  try {
					img = ImageIO.read( new File("images/menuIcons/iconPACMAN.png"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  			  
		  case 1:
			  //return new Image("images/menuIcons/jrBouton.png");
			  try {
					img = ImageIO.read( new File("images/menuIcons/jrBouton.png"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  
		  case 2:
			  //return new Image("images/menuIcons/fondJeux.jpg");
			  try {
					img = ImageIO.read( new File("images/menuIcons/fondJeux.jpg"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  
		  case 3:
			  //return new Image("images/menuIcons/titrePacman.png");
			  try {
					img = ImageIO.read( new File("images/menuIcons/titrePacman.png"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  
		  case 4:
			  //return new Image("images/menuIcons/pacmanGIF.gif");
			  try {
					img = ImageIO.read( new File("images/menuIcons/pacmanGIF.gif"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  
		  case 5:
			  //return new Image("images/menuIcons/fantomeGIF.gif"); 
			  try {
					img = ImageIO.read( new File("images/menuIcons/fantomeGIF.gif"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  
		  case 6:
			  //return new Image("images/menuIcons/pacmanGIF2.gif");
			  try {
					img = ImageIO.read( new File("images/menuIcons/pacmanGIF2.gif"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  
		  default :
			  //return new Image("images/menuIcons/iconPACMAN.png");
			  try {
					img = ImageIO.read( new File("images/menuIcons/iconPACMAN.png"));
			  }
			  catch (IOException e) {
					e.printStackTrace();
			  }
			  return img;
			  
		}
	}

	@Override
	public int[] getRules(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon getSpriteMenu(int i) {
		
		switch (i)
		{
		  case 0:
			  return new ImageIcon("images/menuIcons/pacmanLife.png");
			
			  			  
		  case 1:
			  return new ImageIcon("images/menuIcons/jrBouton.png");
			  
			  
		  case 2:
			  return new ImageIcon("images/menuIcons/fondJeux.jpg");
			 
			  
		  case 3:
			  return new ImageIcon("images/menuIcons/titrePacman.png");
			  
			  
		  case 31:
			  return new ImageIcon("images/menuIcons/titrePacmanGame.png");
			  
			  
		  case 4:
			  return new ImageIcon("images/menuIcons/pacmanGIF.gif");
			 
			  
		  case 5:
			  return new ImageIcon("images/menuIcons/fantomeGIF.gif"); 
			  
			  
		  case 6:
			  return new ImageIcon("images/menuIcons/pacmanGIF2.gif");
			  
			  
		  case 100:
			  return new ImageIcon("images/menuIcons/winScreen.png");
			  
		
		  case 101:
			  return new ImageIcon("images/menuIcons/deathScreen.png");
			 
			  
		  default :
			  return new ImageIcon("images/menuIcons/pacmanLife.png");
			 
			  
		}
	}

	@Override
	public int getNbPixelSprite() {
		return 32;
	}

	@Override
	public int getNbLifeMax(int i) {
		return 3;
	}

	@Override
	public File getMusicFile(int i) {
		
		switch (i)
		{
		  case 0:
			  return new File("music/themePACMAN.wav");
			
			  			  
		  case 1:
			  return new File("music/themeGAME.wav");
			  
			  
		  case 2:
			  return new File("music/themeGAME.wav");
			  
			  
		  default :
			  return new File("music/themeGAME.wav");
			  
		}
		
	}
	

	@Override
	public void saveScore(int level, int score, String pseudo) {
		
		String scoreString[][]=new String[this.getNbLevel()*2][3];
		int maxLevel=this.getNbLevel()*2;
		
		for (int i=0;i<=maxLevel-1;i++){
			for (int j=0;j<=2;j++){
				scoreString[i][j]="0";
			}
		}
		
		try {      
		      try {
		    	  
		    	ois = new ObjectInputStream(
			              new BufferedInputStream(
			                new FileInputStream(sauvegardeScore)));

		    	scoreString=(String[][])ois.readObject();

		      } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		      } 
			
		      ois.close();
		      
		      } catch (FileNotFoundException e) {
		          e.printStackTrace();
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		
		sauvegardeScore.delete();
		System.out.println(scoreString[(level-1)*2][2]);
		if(score>Integer.parseInt(scoreString[(level-1)*2][2])){
			scoreString[(level-1)*2][0]=Integer.toString(level);
			scoreString[(level-1)*2][1]=pseudo;
			scoreString[(level-1)*2][2]=Integer.toString(score);
		}
		
		scoreString[(level-1)*2+1][0]=Integer.toString(level);
		scoreString[(level-1)*2+1][1]=pseudo;
		scoreString[(level-1)*2+1][2]=Integer.toString(score);
		

		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(sauvegardeScore)));
			oos.writeObject(scoreString);
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}     	
	}

	@Override
	public String[][] getHighScores() {
		
		String scoreString[][]=new String[this.getNbLevel()*2][3];
		int maxLevel=this.getNbLevel()*2;
		
		for (int i=0;i<=maxLevel-1;i++){
			for (int j=0;j<=2;j++){
				scoreString[i][j]="0";
			}
		}
		
		try {      
		      try {
		    	  
		    	ois = new ObjectInputStream(
			              new BufferedInputStream(
			                new FileInputStream(sauvegardeScore)));

		    	scoreString=(String[][])ois.readObject();

		      } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		      } 
			
		      ois.close();
		      
		      } catch (FileNotFoundException e) {
		          e.printStackTrace();
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		return scoreString;		
	}
	
	public int getNbLevel(){
		return 3;
	}
}