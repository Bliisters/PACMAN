package view;

public class Gestion extends Thread {
	
	Listener list;
	Game game;
	String key;
	
	public Gestion(Listener l, Game g){
		this.list=l;
		this.game=g;
	}
	
	public void run(){
		while(game.checkWin()==false){
			
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			key=list.getKey();
			
			if(key.equals("UP")){try {
				game.moveUP();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
			if(key.equals("DOWN")){try {
				game.moveDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
			if(key.equals("RIGHT")){try {
				game.moveRight();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
			if(key.equals("LEFT")){try {
				game.moveLeft();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
			
			if(game.checkMort()){
		  		list.setKey("INIT");
		  		key=list.getKey();
		  	}
			
			if(key.equals("INIT")){try {
				game.moveInit();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
			
			System.out.println(key);
			
		}
	}

}
