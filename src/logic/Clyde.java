package logic;

import javax.swing.ImageIcon;

public class Clyde extends Ghost {
	
	public Clyde(int x, int y, ImageIcon im) {
		super(x,y,im);
	}
	
	public void changeDirection(int i){
		
		this.sprite=data.getSpriteClyde(i);
	}

}
