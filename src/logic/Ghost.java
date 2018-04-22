package logic;

import javax.swing.ImageIcon;

public abstract class Ghost extends Character {

	private int LastMoveInverse;	// Entier correspondant au sens inverse de l'actuel déplacement du ghost
	private boolean Mangeable;
	private boolean Estmange;
	
	public Ghost(int x, int y, ImageIcon im) {
		super(x,y,im);
		LastMoveInverse=5;
		Mangeable=false;
		Estmange=false;
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
	public void setMangeable(boolean M) {
		this.Mangeable=M;
	}
	public boolean getMangeable() {
		return this.Mangeable;
	}
	
	public void setEstMange(boolean B){
		this.Estmange=B;
	}
	public boolean getEstMange(){
		return this.Estmange;
	}
	



}