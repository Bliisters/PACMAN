package view;

import logic.LogicGetters;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.*;

public class Game extends JFrame{
	
	Mapi map;
	LogicGetters l;

	private static final long serialVersionUID = 1L;
	Dimension dimFenetre;
	int widthFenetre;
	int heightFenetre;
	
	JPanel panPrincipal;
	JPanel panGame;
	Panneau panStats;
	//aa
	JLabel logo;
	JLabel test;
	
	JLabel logoAnime_PACMAND,logoAnime_PACMANG,logoAnime_PACMANH,logoAnime_PACMANB;
	
	JLabel score;
	
	Theme son = new Theme();
	Listener listener;
	
	boolean key_right,key_left,key_down,key_up;
	boolean in_game;
	
	int nbCasesHeight;
	int nbCasesWidth;
	int nbPixelSprite;
	int espacement;
	int nbLife;
	int nbLifeMax;
	
	int x = 7;
	int y = 7;
	int dist=1;
	
	JLabel[][] Tableau;
	JLabel[][] TableauBase;
	ImageIcon[][] Tab;
	
	JLabel[] Life;
	
	Test testT;
	
	Font font;
	
	public String currentKey="";
	
	class KeyBoardListener extends KeyAdapter {

	    @Override
	    public void keyPressed(KeyEvent event) {
	        switch (event.getKeyCode()) {
	            case KeyEvent.VK_UP:
	            	currentKey="UP";;
	                break;
	            case KeyEvent.VK_DOWN:
	            	currentKey="DOWN";;
	                break;
	            case KeyEvent.VK_LEFT:
	            	currentKey="LEFT";;
	                break;
	            case KeyEvent.VK_RIGHT:
	            	currentKey="RIGHT";;
	                break;
	        }
	    }

	    @Override
	    public void keyReleased(KeyEvent event) {
	        switch (event.getKeyCode()) {
	            case KeyEvent.VK_UP:
	                //upPressed = false;
	                break;
	            case KeyEvent.VK_DOWN:
	                //downPressed = false;
	                break;
	            case KeyEvent.VK_LEFT:
	                //leftPressed = false;
	                break;
	            case KeyEvent.VK_RIGHT:
	                //rightPressed = false;
	                break;
	        }
	    }
	}

	
	public Game(int level){
		
		l=new LogicGetters();
		
		map = new Mapi();
		
		testT=new Test();
		Tab=map.getTableau("");
		
		son.start();
		
		this.in_game=true;
		
		//nbCases=15;
		nbCasesWidth=l.getNbCasesWidth(level);
		nbCasesHeight=l.getNbCasesHeight(level);
		//nbPixelSprite=32;
		nbPixelSprite=testT.getNbPixelSprite();
		nbLife=testT.getNbLife();
		nbLifeMax=testT.getNbLifeMax();
		espacement=10;
		
		this.TableauBase=new JLabel[nbCasesHeight][nbCasesWidth];
		this.Tableau=new JLabel[nbCasesHeight][nbCasesWidth];
		this.Life= new JLabel[nbLifeMax];
		
		logo = new JLabel(new ImageIcon("images/titrePacmanGame.png"));
		logo.setSize(408, 94);
		test = new JLabel(new ImageIcon("images/test.png"));
		test.setSize(512, 512);
		
		int widthFenetreLogo=logo.getWidth();
		int widthFenetreGame=2*espacement+nbPixelSprite*nbCasesWidth;
		if(widthFenetreLogo>widthFenetreGame){widthFenetre=widthFenetreLogo;}
		else{widthFenetre=widthFenetreGame;}
		
		//widthFenetre=3*espacement+nbPixelSprite*nbCases+logo.getWidth();
		//heightFenetre=nbPixelSprite*nbCases+2*espacement;
		heightFenetre=nbPixelSprite*nbCasesHeight+4*espacement+50+logo.getHeight();
		dimFenetre=new Dimension(widthFenetre+5,heightFenetre+35);	
		
		this.setTitle("PAC-MAN");
		this.setPreferredSize(dimFenetre);
		this.setMinimumSize(dimFenetre);
		this.setMaximumSize(dimFenetre);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setFocusable(true);
		this.setIconImage(new ImageIcon("images/iconPACMAN.png").getImage());
		
		key_right=false;
		key_left=false;
		key_up=false;
		key_down=false;
		
		logoAnime_PACMAND = new JLabel(new ImageIcon("images/pacmanGIFDv2.gif"));
		logoAnime_PACMANG = new JLabel(new ImageIcon("images/pacmanGIFGv2.gif"));
		logoAnime_PACMANH = new JLabel(new ImageIcon("images/pacmanGIFHv2.gif"));
		logoAnime_PACMANB = new JLabel(new ImageIcon("images/pacmanGIFBv2.gif"));
		
		logoAnime_PACMANB.setSize(nbPixelSprite,nbPixelSprite);
		logoAnime_PACMANH.setSize(nbPixelSprite,nbPixelSprite);
		logoAnime_PACMAND.setSize(nbPixelSprite,nbPixelSprite);
		logoAnime_PACMANG.setSize(nbPixelSprite,nbPixelSprite);
		
		Listener listener=new Listener(this);
		this.addKeyListener(listener);
		
		panPrincipal=new JPanel();
		panPrincipal.setSize(widthFenetre,heightFenetre);
		panPrincipal.setBackground(Color.black);
		
		this.setLayout(null);
		this.add(panPrincipal);
		panPrincipal.setBounds(0, 0, panPrincipal.getWidth(), panPrincipal.getHeight());
		panPrincipal.setLayout(null);
		
		panGame=new JPanel();
		panGame.setBackground(Color.black);
		panGame.setSize(nbPixelSprite*nbCasesWidth,nbPixelSprite*nbCasesHeight);
		panStats=new Panneau("images/fondBoutonGris.jpg");
		//panStats.setSize(panPrincipal.getWidth()-panGame.getWidth()-3*espacement,(panPrincipal.getHeight())-(3*espacement)-(logo.getHeight()));
		panStats.setSize(panPrincipal.getWidth()-2*espacement,panPrincipal.getHeight()-(panGame.getHeight()+logo.getHeight()+4*espacement));
		
		panPrincipal.add(logo);
		//logo.setBounds(espacement, espacement, logo.getWidth(), logo.getHeight());
		logo.setBounds((panPrincipal.getWidth()/2)-(logo.getWidth()/2),espacement, logo.getWidth(), logo.getHeight());
		
		panPrincipal.add(panStats);
		//panStats.setBounds(espacement, logo.getHeight()+2*espacement, panStats.getWidth(), panStats.getHeight());
		panStats.setBounds(espacement,(3*espacement)+logo.getHeight()+panGame.getHeight(), panStats.getWidth(), panStats.getHeight());
		panStats.setLayout(null);
		score = new JLabel("Score : "+map.getScore());
		score.setSize(panStats.getWidth()-2*espacement-((nbLifeMax-1)*(nbPixelSprite+espacement)), panStats.getHeight()-2*espacement);
		panStats.add(score);
		score.setBounds(espacement,espacement,score.getWidth(),score.getHeight());
		font = new Font("Arial",Font.BOLD,20);
		score.setFont(font);
		
		panPrincipal.add(panGame);
		//panGame.setBounds(panPrincipal.getWidth()-espacement-panGame.getWidth(),espacement,panGame.getWidth(),panGame.getHeight());
		panGame.setBounds(espacement,2*espacement+logo.getHeight(),panGame.getWidth(),panGame.getHeight());
		panGame.setLayout(null);
		//panGame.add(test);
		//test.setBounds(0, 0, test.getWidth(), test.getHeight());
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				if(x==i&&y==j){
					//this.TableauBase[i][j]=logoAnime_PACMAND;
					this.TableauBase[i][j]=new JLabel(Tab[i][j]);
					this.TableauBase[i][j].setSize(nbPixelSprite,nbPixelSprite);
				}
				else{
					this.TableauBase[i][j]=new JLabel(Tab[i][j]);
					this.TableauBase[i][j].setSize(nbPixelSprite,nbPixelSprite);
				}
			}
		}
		
		this.Tableau=this.TableauBase;
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				panGame.add(this.TableauBase[i][j]);
				this.TableauBase[i][j].setBounds(j*nbPixelSprite, i*nbPixelSprite, Tableau[i][j].getWidth(), Tableau[i][j].getHeight());
			}
		}
		
		for(int i = 0; i <= nbLifeMax-1; i++){
			Life[i]=new JLabel(testT.getSprite(1));
			Life[i].setSize(nbPixelSprite,nbPixelSprite);
		}
		for(int i = 0; i <= nbLife-2; i++){
			panStats.add(Life[i]);
			Life[i].setBounds(panStats.getWidth()-((i+1)*espacement+(i+1)*Life[i].getWidth()),espacement , Life[i].getWidth(), Life[i].getHeight());
			System.out.println(i);
		}
	}
	
	public void move(String currentKey){
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=map.getTableau(currentKey);
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		//this.listener.move();
	}
	
	public void moveUP() throws InterruptedException{
		
		this.key_up=true;
		this.key_down=false;
		this.key_right=false;
		this.key_left=false;
		
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=map.getTableau("UP");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		/*this.reset();
		
		panGame.remove(logoAnime_PACMAND);
		panGame.remove(logoAnime_PACMANB);
		panGame.remove(logoAnime_PACMANG);
		panGame.remove(logoAnime_PACMANH);
		
		y=y-dist;
		
		panGame.add(logoAnime_PACMANH);
		logoAnime_PACMANH.setBounds(x*nbPixelSprite, y*nbPixelSprite, logoAnime_PACMANH.getWidth(), logoAnime_PACMANH.getHeight());
		
		this.Tableau[x][y]=logoAnime_PACMANH;
		
		this.getContentPane().repaint();
		
		this.refresh();*/
	}
	
	public void moveDown() throws InterruptedException{
		
		this.key_up=false;
		this.key_down=true;
		this.key_right=false;
		this.key_left=false;
		
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=map.getTableau("DOWN");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		/*this.reset();
		
		panGame.remove(logoAnime_PACMAND);
		panGame.remove(logoAnime_PACMANH);
		panGame.remove(logoAnime_PACMANG);
		panGame.remove(logoAnime_PACMANB);

		y=y+dist;
		
		this.Tableau[x][y]=logoAnime_PACMANB;
		panGame.add(logoAnime_PACMANB);
		logoAnime_PACMANB.setBounds(x*nbPixelSprite, y*nbPixelSprite, logoAnime_PACMANB.getWidth(), logoAnime_PACMANB.getHeight());
		
		this.getContentPane().repaint();
		
		this.refresh();*/
	}
	
	public void moveLeft() throws InterruptedException{
		
		this.key_up=false;
		this.key_down=false;
		this.key_right=false;
		this.key_left=true;
		
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=map.getTableau("LEFT");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		/*this.reset();
		
		this.key_up=false;
		this.key_down=false;
		this.key_right=false;
		this.key_left=true;
		
		panGame.remove(logoAnime_PACMAND);
		panGame.remove(logoAnime_PACMANH);
		panGame.remove(logoAnime_PACMANB);
		panGame.remove(logoAnime_PACMANG);

		x=x-dist;

		panGame.add(logoAnime_PACMANG);
		logoAnime_PACMANG.setBounds(x*nbPixelSprite, y*nbPixelSprite, logoAnime_PACMANG.getWidth(), logoAnime_PACMANG.getHeight());
		
		this.Tableau[x][y]=logoAnime_PACMANG;
		
		this.getContentPane().repaint();
		
		this.refresh();*/
	}
	
	public void moveRight() throws InterruptedException{
		
		this.key_up=false;
		this.key_down=false;
		this.key_right=true;
		this.key_left=false;
		
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=map.getTableau("RIGHT");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		/*this.reset();
		
		this.key_up=false;
		this.key_down=false;
		this.key_right=true;
		this.key_left=false;
	
		panGame.remove(logoAnime_PACMANB);
		panGame.remove(logoAnime_PACMANH);
		panGame.remove(logoAnime_PACMANG);
		panGame.remove(logoAnime_PACMAND);

		x=x+dist;
;
		panGame.add(logoAnime_PACMAND);
		logoAnime_PACMAND.setBounds(x*nbPixelSprite, y*nbPixelSprite, logoAnime_PACMAND.getWidth(), logoAnime_PACMAND.getHeight());
		
		this.Tableau[x][y]=logoAnime_PACMAND;
		
		this.getContentPane().repaint();
		
		this.refresh();*/
	}
	
	public void refresh(){
		
		panGame.removeAll();
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				panGame.add(this.Tableau[i][j]);
				this.TableauBase[i][j].setBounds(j*nbPixelSprite, i*nbPixelSprite, Tableau[i][j].getWidth(), Tableau[i][j].getHeight());
			}
		}
		
		this.refreshScore();
		
	}
	
	public void reset(){
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				this.TableauBase[i][j]=new JLabel(Tab[i][j]);
				this.TableauBase[i][j].setSize(nbPixelSprite,nbPixelSprite);
			}
		}
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				this.Tableau[i][j]=this.TableauBase[i][j];
			}
		}
	}
	
	public void refreshScore(){
		panStats.remove(score);
		score = new JLabel("Score : "+map.getScore());
		score.setSize(panStats.getWidth()-2*espacement-((nbLifeMax-1)*(nbPixelSprite+espacement)), panStats.getHeight()-2*espacement);
		panStats.add(score);
		score.setBounds(espacement,espacement,score.getWidth(),score.getHeight());
		score.setFont(font);
	}
}
