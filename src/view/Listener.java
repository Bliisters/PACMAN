package view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener extends Thread implements KeyListener  {
	
	Game game;
	String currentKey;
	
	public Listener(Game game)
	{
		this.game=game;
		this.currentKey=new String();
		this.currentKey="";
		
	}
	
	
	public String getKey(){
		return this.currentKey;
	}
	
	public void keyPressed(KeyEvent arg0) {
		//Avance
		 if((arg0.getKeyCode()==KeyEvent.VK_UP))
		 {
			this.currentKey="UP";
			try {
				game.moveUP();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		 //Recule
		 if((arg0.getKeyCode()==KeyEvent.VK_DOWN))
		 {
			this.currentKey="DOWN";
			try {
				game.moveDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 	 if((arg0.getKeyCode()==KeyEvent.VK_LEFT))
	 	 {
	 		this.currentKey="LEFT";
	 		try {
				game.moveLeft();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 	 }
	  	if((arg0.getKeyCode()==KeyEvent.VK_RIGHT))
	  	{
	  		this.currentKey="RIGHT";
	  		try {
				game.moveRight();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	  	}
	  	
	  	if((arg0.getKeyCode()==KeyEvent.VK_N)){
	  		if(game.checkWin()){
		  		game.newLevel();
	  		}
	  	}
	  	
	}
	  	

	public void keyReleased(KeyEvent arg0) {
		
		if((arg0.getKeyCode()==KeyEvent.VK_UP))
		 { 
		 }
		 if((arg0.getKeyCode()==KeyEvent.VK_DOWN))
		 {
		 }
	 	 if((arg0.getKeyCode()==KeyEvent.VK_LEFT))
	 	 {
	 	 }
	  	if((arg0.getKeyCode()==KeyEvent.VK_RIGHT))
	  	{
	  	}
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
}
	
