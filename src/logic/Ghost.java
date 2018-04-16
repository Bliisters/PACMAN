package logic;

import javax.swing.ImageIcon;

public abstract class Ghost extends Character {

	private int LastMoveInverse;	// Entier correspondant au sens inverse de l'actuel déplacement du ghost
	
	public Ghost(int x, int y, ImageIcon im) {
		super(x,y,im);
		LastMoveInverse=5;
	}
	
	public void setLastMove(int L) {
		if(L==0) {
			this.LastMoveInverse=1;
		}
		if(L==1) {
			this.LastMoveInverse=0;
		}
		if(L==2) {
			this.LastMoveInverse=3;
		}
		if(L==3) {
			this.LastMoveInverse=2;
		}
	}
	public int getLastMove() {
		return this.LastMoveInverse;
	}

	public void changeDirection(int c) {
		// TODO Auto-generated method stub
		
	}



}
