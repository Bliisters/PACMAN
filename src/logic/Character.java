package logic;

import javax.swing.ImageIcon;

public abstract class Character extends Element {

	protected int x;
	protected int y;
	
	
	public Character(int x, int y, ImageIcon im) {
		super(im);
		this.x=x;
		this.y=y;
	}
	
	
	public int getPosx(){
		return this.x;
	}
	public int getPosy(){
		return this.y;
	}
	
	public void setPos(int x,int y) {
		this.x=x;
		this.y=y;
	}

}