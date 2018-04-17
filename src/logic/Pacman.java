package logic;

import javax.swing.ImageIcon;

public class Pacman extends Character {

	private String LastMove="NULL";

	public Pacman(int x, int y, ImageIcon im) {
		super(x,y,im);
	}
	

	public void changeDirection(int i){
		this.sprite=data.getSpritePacMan(i);
	}
	
	public void setLastMove(String S) {
		this.LastMove=S;
	}
	
	public String getLastMove() {
		return this.LastMove;
	}
}