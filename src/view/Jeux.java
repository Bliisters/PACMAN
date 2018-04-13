package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jeux extends JFrame{
	
	private static final long serialVersionUID = 1L;
	Dimension dimFenetre = new Dimension(1280,720);
	JPanel test;
	JLabel logoAnime_PACMAND,logoAnime_PACMANG,logoAnime_PACMANH,logoAnime_PACMANB;
	int x = 0;
	int y = 0;
	int dist=10;
	
	Theme son = new Theme();
	
	Listener listener;
	
	boolean key_right,key_left,key_down,key_up;
	
	public Jeux(){
		
		son.start();
		
		this.setTitle("PAC-MAN");
		this.setPreferredSize(dimFenetre);
		this.setMinimumSize(dimFenetre);
		this.setMaximumSize(dimFenetre);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setFocusable(true);
		this.setIconImage(new ImageIcon("images/iconPACMAN.png").getImage());
		
		key_right=false;
		key_left=false;
		key_up=false;
		key_down=false;
		
		test = new JPanel();
		test.setPreferredSize(dimFenetre);
		test.setBackground(Color.black);
		
		logoAnime_PACMAND = new JLabel(new ImageIcon("images/pacmanGIFD.gif"));
		logoAnime_PACMANG = new JLabel(new ImageIcon("images/pacmanGIFG.gif"));
		logoAnime_PACMANH = new JLabel(new ImageIcon("images/pacmanGIFH.gif"));
		logoAnime_PACMANB = new JLabel(new ImageIcon("images/pacmanGIFB.gif"));
		
		this.setLayout(null);
		this.add(test);
		test.setBounds(0, 0, 1280, 720);
		test.setLayout(null);
		//test.add(logoAnime_PACMAND);
		//logoAnime_PACMAND.setBounds(x, y, 15, 15);
		//logoAnime_PACMANH.setBounds(x, y, 15, 15);
		//logoAnime_PACMANG.setBounds(x, y, 15, 15);
		//logoAnime_PACMANB.setBounds(x, y, 15, 15);
		logoAnime_PACMANB.setSize(15,15);
		logoAnime_PACMANH.setSize(15,15);
		logoAnime_PACMAND.setSize(15,15);
		logoAnime_PACMANG.setSize(15,15);
		
		Listener listener=new Listener(this);
		this.addKeyListener(listener);
		
		
		/*if(key_down) { 
			y=y+10;
			test.remove(logoAnime_PACMAN);
			test.add(logoAnime_PACMAN);
			logoAnime_PACMAN.setBounds(x, y, logoAnime_PACMAN.getWidth(), logoAnime_PACMAN.getHeight());
		}

            
        if (key_up) {
            y=y-10;
			test.remove(logoAnime_PACMAN);
			test.add(logoAnime_PACMAN);
			logoAnime_PACMAN.setBounds(x, y, logoAnime_PACMAN.getWidth(), logoAnime_PACMAN.getHeight());
        }

           
        if (key_right) {
            x=x+10;
			test.remove(logoAnime_PACMAN);
			test.add(logoAnime_PACMAN);
			logoAnime_PACMAN.setBounds(x, y, logoAnime_PACMAN.getWidth(), logoAnime_PACMAN.getHeight());
         }

        if (key_left) {
            x=x-10;
			test.remove(logoAnime_PACMAN);
			test.add(logoAnime_PACMAN);
			logoAnime_PACMAN.setBounds(x, y, logoAnime_PACMAN.getWidth(), logoAnime_PACMAN.getHeight());
		}*/
	}
	
	public void moveUP() throws InterruptedException{
		this.key_up=true;
		
		test.remove(logoAnime_PACMAND);
		test.remove(logoAnime_PACMANB);
		test.remove(logoAnime_PACMANG);
		test.remove(logoAnime_PACMANH);
		//Thread.sleep(100);
		//logoAnime_PACMAN=null;
		y=y-dist;
		//logoAnime_PACMAND = new JLabel(new ImageIcon("images/pacmanGIFH.gif"));
		//logoAnime_PACMAND.setSize(15, 15);
		test.add(logoAnime_PACMANH);
		logoAnime_PACMANH.setBounds(x, y, logoAnime_PACMANH.getWidth(), logoAnime_PACMANH.getHeight());
		this.remove(test);
		this.add(test);
		test.setBounds(0, 0, 1280, 720);
		//Thread.sleep(10);
		//System.out.println("test");
		this.refresh();
	}
	public void moveDown() throws InterruptedException{
		this.key_down=true;
		
		test.remove(logoAnime_PACMAND);
		test.remove(logoAnime_PACMANH);
		test.remove(logoAnime_PACMANG);
		test.remove(logoAnime_PACMANB);
		//Thread.sleep(100);
		//test.remove(logoAnime_PACMAN);
		y=y+dist;
		//logoAnime_PACMAN = new JLabel(new ImageIcon("images/pacmanGIFB.gif"));
		//logoAnime_PACMAN.setSize(15, 15);
		test.add(logoAnime_PACMANB);
		logoAnime_PACMANB.setBounds(x, y, logoAnime_PACMANB.getWidth(), logoAnime_PACMANB.getHeight());
		this.remove(test);
		this.add(test);
		test.setBounds(0, 0, 1280, 720);
		//Thread.sleep(10);
		//System.out.println("test");
		this.refresh();
	}
	public void moveLeft() throws InterruptedException{
		
		
		test.remove(logoAnime_PACMAND);
		test.remove(logoAnime_PACMANH);
		test.remove(logoAnime_PACMANB);
		test.remove(logoAnime_PACMANG);
		
		
		//test.remove(logoAnime_PACMAN);
		x=x-dist;
		//logoAnime_PACMAN = new JLabel(new ImageIcon("images/pacmanGIFG.gif"));
		//logoAnime_PACMAN.setSize(15, 15);
		test.add(logoAnime_PACMANG);
		logoAnime_PACMANG.setBounds(x, y, logoAnime_PACMANG.getWidth(), logoAnime_PACMANG.getHeight());
		//test.remove(logoAnime_PACMAND);
		//Thread.sleep(10);
		//System.out.println("test");
		this.remove(test);
		this.add(test);
		test.setBounds(0, 0, 1280, 720);
		this.key_left=true;
		this.refresh();
	}
	public void moveRight() throws InterruptedException{
		this.key_right=true;
		
		test.remove(logoAnime_PACMANB);
		test.remove(logoAnime_PACMANH);
		test.remove(logoAnime_PACMANG);
		test.remove(logoAnime_PACMAND);
		
		//test.remove(logoAnime_PACMAN);
		x=x+dist;
		//logoAnime_PACMAN = new JLabel(new ImageIcon("images/pacmanGIFD.gif"));
		//logoAnime_PACMAN.setSize(15, 15);
		test.add(logoAnime_PACMAND);
		logoAnime_PACMAND.setBounds(x, y, logoAnime_PACMAND.getWidth(), logoAnime_PACMAND.getHeight());
		//test.remove(logoAnime_PACMANG);
		//Thread.sleep(100);
		//System.out.println("test");
		this.remove(test);
		this.add(test);
		test.setBounds(0, 0, 1280, 720);
		this.refresh();
	}
	public void resetUP(){
		/*this.key_up=false;
		test.remove(logoAnime_PACMAND);
		test.remove(logoAnime_PACMANB);
		test.remove(logoAnime_PACMANG);*/
	}
	public void resetDown(){
		/*this.key_down=false;
		test.remove(logoAnime_PACMAND);
		test.remove(logoAnime_PACMANH);
		test.remove(logoAnime_PACMANG);*/
	}
	public void resetLeft(){
		/*this.key_left=false;
		test.remove(logoAnime_PACMAND);
		test.remove(logoAnime_PACMANH);
		test.remove(logoAnime_PACMANB);*/
	}
	public void resetRight(){
		/*this.key_right=false;
		test.remove(logoAnime_PACMANB);
		test.remove(logoAnime_PACMANH);
		test.remove(logoAnime_PACMANG);*/
	}
	public void refresh(){
		this.getContentPane().repaint();
	}
	
}

