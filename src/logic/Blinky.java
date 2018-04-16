package logic;

import javax.swing.ImageIcon;

public class Blinky extends Ghost {

		public Blinky(int x, int y, ImageIcon im) {
			super(x,y,im);
		}
		
		
		public void changeDirection(int i){
			this.sprite=data.getSpriteBlinky(i);
		}
}
