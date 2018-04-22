package logic;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public interface Logic {
	
	public int getNbLevel();
	
	public void saveScore(int level, int score, String pseudo);
	
	public int getNbCasesWidth(int i);
	
	public int getNbCasesHeight(int i);
	
	public ImageIcon getSpriteTiles(int i);
	
	public String[][] getHighscore();
	
	public int getRules(int i);
	
	public Image getSpriteMenuImage(int i);
	
	public ImageIcon getSpriteMenu(int i);
	
	public ImageIcon[][] getTableau(String key);
	
	public int getNbPixelSprite();
	
	public int getNbLife();
	
	public int getNbLifeMax(int i);
	
	public int getScore();
	
	public File getMusicFile(int i);
	
	public boolean checkFinish();
	
	public boolean checkMort();
	
}
