package view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JButton;

public class Bouton extends JButton{
	


	private static final long serialVersionUID = 1L;
	private String str;
	private Image img;
	private int longueur;
	private int hauteur;
	
	public Bouton(String str,int l, int h, Image img){
		super(str);
		this.str = str;
		this.img = img;
		this.longueur = l;
		this.hauteur = h;
	}
	
	
	public int getLongueur(){
		return this.longueur;
	}
	
	
	public int getHauteur(){
		return this.hauteur;
	}
	
	
	public String getStr(){
		return this.str;
	}
	
	
	public void paintComponent (Graphics g){
		int x = this.getWidth()/ 2 - (this.getWidth()/3 + this.getStr().length());
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2d.setColor(Color.BLACK);
		g2d.drawString(this.str, this.getWidth()/4 + x , (this.getHeight() / 2) + 4);
		
	}
	
	
}