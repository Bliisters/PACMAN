package logic;

import javax.swing.ImageIcon;

public abstract class Character extends Element {

	protected int x;
	protected int y;
	
	protected int iniX;
	protected int iniY;
	
	
	public Character(int x, int y, ImageIcon im) {
		super(im);
		this.x=x;
		this.y=y;
		this.iniX=x;
		this.iniY=y;
	}
	
	
	public int getPosx(){
		return this.x;
	}
	public int getPosy(){
		return this.y;
	}
	
	public int getPosIniX(){
		return this.iniX;
	}
	public int getPosIniY(){
		return this.iniY;
	}
	
	public void setPos(int x,int y) {
		this.x=x;
		this.y=y;
	}

}