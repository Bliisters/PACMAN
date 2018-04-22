package view;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import data.Data;

public class Listener extends Thread implements KeyListener  {
	
	Game game;
	String currentKey;
	Gestion g;
	Data d;
	
	public Listener(Game game)
	{
		this.game=game;
		this.currentKey=new String();
		this.currentKey="";
		g=new Gestion(this, game);
		g.start();
		d=new Data();
		
	}
	
	
	public String getKey(){
		return this.currentKey;
	}
	
	@SuppressWarnings("deprecation")
	public void keyPressed(KeyEvent arg0) {
		 if((arg0.getKeyCode()==KeyEvent.VK_UP))
		 {
			this.currentKey="UP";
		 }
		 if((arg0.getKeyCode()==KeyEvent.VK_DOWN))
		 {
			this.currentKey="DOWN";
		 }
	 	 if((arg0.getKeyCode()==KeyEvent.VK_LEFT))
	 	 {
	 		this.currentKey="LEFT";
	 	 }
	  	if((arg0.getKeyCode()==KeyEvent.VK_RIGHT))
	  	{
	  		this.currentKey="RIGHT";
	  	}
	  	
	  	if((arg0.getKeyCode()==KeyEvent.VK_N)){
	  		if(game.checkWin()){
	  			g.stop();
	  			int test=(game.getLevel());
	  			if(d.getNbLevel()>=test){
	  				game.dispose();
	  				new Accueil();
	  			}
	  			else{game.newLevel();}
	  		}
	  	}
	  	
	  	if((arg0.getKeyCode()==KeyEvent.VK_R)){
	  		if(game.checkGameOver()){
	  			g.stop();
		  		game.restartLevel();
	  		}
	  	}
	  	
	  	if((arg0.getKeyCode()==KeyEvent.VK_ESCAPE)){
	  		if(game.checkWin()||game.checkGameOver()){
	  			g.stop();
		  		game.dispose();
	  		}
	  	}
	  	
	  	if((arg0.getKeyCode()==KeyEvent.VK_M)){
	  		if(game.checkWin()||game.checkGameOver()){
	  			g.stop();
	  			game.saveScore();
		  		game.dispose();
		  		new Accueil();
	  		}
	  	}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	public void setKey (String s){
		this.currentKey=s;
	}
}
	
