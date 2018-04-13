package logic;

import javax.swing.ImageIcon;

public class Pacman extends Character {

	

	public Pacman(int x, int y, ImageIcon im) {
		super(x,y,im);
	}
	

	public void changeDirection(int i){
		this.sprite=data.getSpritePacMan(i);
	}
}