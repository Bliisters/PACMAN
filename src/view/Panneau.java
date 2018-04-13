package view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Panneau extends JPanel {
	


	private static final long serialVersionUID = 1L;
	private Component[] comp;
	private Image img;
	private String location;
	
	public Panneau(Image img ,Component...components){
		super();
		for(Component component : components){
			this.add(component);
			}
		
		this.img = img;
	}
	
	public Panneau(String loc ,Component...components){
		super();
		for(Component component : components){
			this.add(component);
			}
		
		this.location=loc;
		
		try {
			this.img = ImageIO.read( new File(location));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public boolean containsComponent(Object comp){
		this.comp = this.getComponents();
		boolean cont = false;
		for (int i=0; i < this.comp.length && !cont; i++){
			if(comp.equals(this.comp[i])){
				cont = true;
			}
		}
		return cont;
	}
	public void paintComponent (Graphics g){
		
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}

