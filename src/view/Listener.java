package view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import logic.Mapi;

public class Listener extends Thread implements KeyListener  {
	
	Game game;
	Jeux jeux;
	String currentKey;
	Mapi map;
	
	public Listener(Game game)
	{
		this.game=game;
		this.currentKey=new String();
		this.currentKey="UP";
		Mapi map = new Mapi();
		this.run();
	}
	
	public Listener(Jeux jeux)
	{
		this.jeux=jeux;
	}
	
	public String getKey(){
		return this.currentKey;
	}
	
	public void move(){
		
	    try {
			this.currentThread().sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("test");
		game.move(this.currentKey);
	}
	
	public void keyPressed(KeyEvent arg0) {
		//Avance
		 if((arg0.getKeyCode()==KeyEvent.VK_UP))
		 {
			this.currentKey="UP";
			game.move(currentKey);
            /*try {
            	//jeux.moveUP();
				game.moveUP();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */
		 }
		 //Recule
		 if((arg0.getKeyCode()==KeyEvent.VK_DOWN))
		 {
			this.currentKey="DOWN";
			game.move(currentKey);
			/*try {
				//jeux.moveDown();
				game.moveDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		 }
		 //Tourne à gauche
	 	 if((arg0.getKeyCode()==KeyEvent.VK_LEFT))
	 	 {
	 		 this.currentKey="LEFT";
	 		game.move(currentKey);
             /*try {
            	//jeux.moveLeft();
				game.moveLeft();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	 	 }
	 	 //Tourne à droite
	  	if((arg0.getKeyCode()==KeyEvent.VK_RIGHT))
	  	{
	  		this.currentKey="RIGHT";
	  		game.move(currentKey);
            /*try {
            	//jeux.moveRight();
				game.moveRight();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	  	}
	}
	  	

	public void keyReleased(KeyEvent arg0) {
		
		/*if((arg0.getKeyCode()==KeyEvent.VK_UP))
		 {
           game.resetUP(); 
		 }
		 //Recule
		 if((arg0.getKeyCode()==KeyEvent.VK_DOWN))
		 {
			game.resetDown();
		 }
		 //Tourne à gauche
	 	 if((arg0.getKeyCode()==KeyEvent.VK_LEFT))
	 	 {
            game.resetLeft();
	 	 }
	 	 //Tourne à droite
	  	if((arg0.getKeyCode()==KeyEvent.VK_RIGHT))
	  	{
           game.resetRight();
	  	}*/
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public ImageIcon[][] getTab(){
		return map.getTableau("UP");
	}
}
	
