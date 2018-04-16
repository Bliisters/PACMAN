package logic;

import javax.swing.ImageIcon;

public class Inky extends Ghost {
	
	public Inky(int x, int y, ImageIcon im) {
		super(x,y,im);
	}

	public void changeDirection(int i){
		this.sprite=data.getSpriteInky(i);
	}
}
