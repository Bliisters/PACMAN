package view;

import logic.LogicGetters;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame{
	
	LogicGetters l;
	
	CardLayout cl;

	private static final long serialVersionUID = 1L;
	Dimension dimFenetre;
	int widthFenetre;
	int heightFenetre;

	JPanel container;
	JPanel panPrincipal;
	JPanel panGame;
	JPanel panWin;
	Panneau panStats;

	JLabel logo;
	JLabel score;
	
	Audio son;
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
	
	Font font;
	
	public String currentKey="";
	
	
	public Game(int level){
		
		l=new LogicGetters();
		
		cl = new CardLayout();
		
		son = new Audio(level);
		
		Tab=l.getTableau("INIT");
		
		son.start();
		
		this.in_game=true;
		
		nbCasesWidth=l.getNbCasesWidth(level);
		nbCasesHeight=l.getNbCasesHeight(level);
		nbPixelSprite=l.getNbPixelSprite();
		nbLife=l.getNbLife();
		nbLifeMax=l.getNbLifeMax(level);
		espacement=10;
		
		this.TableauBase=new JLabel[nbCasesHeight][nbCasesWidth];
		this.Tableau=new JLabel[nbCasesHeight][nbCasesWidth];
		this.Life= new JLabel[nbLifeMax];
		
		logo = new JLabel(l.getSpriteMenu(31));
		logo.setSize(408, 94);
		
		int widthFenetreLogo=logo.getWidth();
		int widthFenetreGame=2*espacement+nbPixelSprite*nbCasesWidth;
		if(widthFenetreLogo>widthFenetreGame){widthFenetre=widthFenetreLogo;}
		else{widthFenetre=widthFenetreGame;}
		
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
		this.setIconImage(l.getSpriteMenuImage(0));
		
		key_right=false;
		key_left=false;
		key_up=false;
		key_down=false;
		
		listener=new Listener(this);
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
		panStats.setSize(panPrincipal.getWidth()-2*espacement,panPrincipal.getHeight()-(panGame.getHeight()+logo.getHeight()+4*espacement));
		panWin=new JPanel();
		panWin.setBackground(Color.black);
		panWin.setSize(nbPixelSprite*nbCasesWidth,nbPixelSprite*nbCasesHeight);
		
		container = new JPanel();
		container.setLayout(cl);
		container.add(panGame,"GAME");
		container.add(panWin,"WIN");
		cl.first(container);
		
		panPrincipal.add(logo);
		logo.setBounds((panPrincipal.getWidth()/2)-(logo.getWidth()/2),espacement, logo.getWidth(), logo.getHeight());
		
		panPrincipal.add(panStats);
		panStats.setBounds(espacement,(3*espacement)+logo.getHeight()+panGame.getHeight(), panStats.getWidth(), panStats.getHeight());
		panStats.setLayout(null);
		score = new JLabel("Score : "+l.getScore());
		score.setSize(panStats.getWidth()-2*espacement-((nbLifeMax-1)*(nbPixelSprite+espacement)), panStats.getHeight()-2*espacement);
		panStats.add(score);
		score.setBounds(espacement,espacement,score.getWidth(),score.getHeight());
		font = new Font("Arial",Font.BOLD,20);
		score.setFont(font);
		
		int taille=200;
		JLabel Win = new JLabel(l.getSpriteMenu(100));
		panWin.add(Win);
		Win.setBounds((panGame.getWidth()/2-taille/2),(panGame.getHeight()/2-taille/2),taille,taille);
		
		panPrincipal.add(container);
		container.setBounds(espacement,2*espacement+logo.getHeight(),panGame.getWidth(),panGame.getHeight());
		panGame.setLayout(null);
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				if(x==i&&y==j){
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
			Life[i]=new JLabel(l.getSpriteMenu(0));
			Life[i].setSize(nbPixelSprite,nbPixelSprite);
		}
		for(int i = 0; i <= nbLife-2; i++){
			panStats.add(Life[i]);
			Life[i].setBounds(panStats.getWidth()-((i+1)*espacement+(i+1)*Life[i].getWidth()),espacement , Life[i].getWidth(), Life[i].getHeight());
			System.out.println(i);
		}
		
		this.setContentPane(panPrincipal);
		
	}
	
	public String getKey(){
		return this.listener.getKey();
	}
	
	public void moveUP() throws InterruptedException{
		
		this.key_up=true;
		this.key_down=false;
		this.key_right=false;
		this.key_left=false;
		
		panGame.removeAll();
		Tab=l.getTableau("UP");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		if(l.checkFinish()){
			cl.show(container, "WIN");
		}
		
	}
	
	public void moveDown() throws InterruptedException{
		
		this.key_up=false;
		this.key_down=true;
		this.key_right=false;
		this.key_left=false;
		
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=l.getTableau("DOWN");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		if(l.checkFinish()){
			cl.show(container, "WIN");
		}
	}
	
	public void moveLeft() throws InterruptedException{
		
		this.key_up=false;
		this.key_down=false;
		this.key_right=false;
		this.key_left=true;
		
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=l.getTableau("LEFT");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		if(l.checkFinish()){
			cl.show(container, "WIN");
		}
	}
	
	public void moveRight() throws InterruptedException{
		
		this.key_up=false;
		this.key_down=false;
		this.key_right=true;
		this.key_left=false;
		
		panGame.removeAll();
		this.getContentPane().repaint();
		Tab=l.getTableau("RIGHT");
		this.reset();
		this.refresh();
		this.getContentPane().repaint();
		
		if(l.checkFinish()){
			cl.show(container, "WIN");
		}
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
		this.refreshLife();
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
		score = new JLabel("Score : "+l.getScore());
		score.setSize(panStats.getWidth()-2*espacement-((nbLifeMax-1)*(nbPixelSprite+espacement)), panStats.getHeight()-2*espacement);
		panStats.add(score);
		score.setBounds(espacement,espacement,score.getWidth(),score.getHeight());
		score.setFont(font);
	}
	
	public void refreshLife(){
		nbLife=l.getNbLife();
		panStats.remove(Life[nbLife-1]);		
	}
}
