package logic;

import javax.swing.ImageIcon;

public class Pinky extends Ghost {
	
	public Pinky(int x, int y, ImageIcon im) {
		super(x,y,im);
	}
	
	public void changeDirection(int i){
		this.sprite=data.getSpritePinky(i);
	}

}
