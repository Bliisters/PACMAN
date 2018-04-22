package logic;

import javax.swing.ImageIcon;

public class Blinky extends Ghost {
	
		private int[] lastPos;

		public Blinky(int x, int y, ImageIcon im) {
			super(x,y,im);
			this.lastPos = new int[]{this.iniX, this.iniY};
		}
		
		
		public void changeDirection(int i){
			this.sprite=data.getSpriteBlinky(i);
		}
		
		public int[] getLastPos() {
			return this.lastPos;
		}
}
