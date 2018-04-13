package logic;

import data.Data;
import javax.swing.ImageIcon;

public abstract class Element {
	
	protected Data data = new Data();
	protected ImageIcon sprite;

	
	public Element(ImageIcon im) {
		this.sprite=im;
	}
	
	public ImageIcon getSprite() {
		return this.sprite;
	}
	

}
