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
	JPanel panLose;
	Panneau panStats;

	JLabel logo;
	JLabel score;
	JLabel scoreWin;
	
	Audio son;
	Listener listener;

	boolean in_game;
	
	int nbCasesHeight;
	int nbCasesWidth;
	int nbPixelSprite;
	int espacement;
	int nbLife;
	int nbLifeMax;
	
	
	JLabel[][] Tableau;
	ImageIcon[][] Tab;
	
	JLabel[] Life;
	
	Font font;
	
	int level;
	
	public String currentKey="";
	
	String pseudo;	
	
	public Game(int level, String pseudo){
		
		this.pseudo=pseudo;
		
		this.level=level;
		
		l=new LogicGetters(level);
		
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
		panLose=new JPanel();
		panLose.setBackground(Color.black);
		panLose.setSize(nbPixelSprite*nbCasesWidth,nbPixelSprite*nbCasesHeight);
		
		container = new JPanel();
		container.setLayout(cl);
		container.add(panGame,"GAME");
		container.add(panWin,"WIN");
		container.add(panLose,"LOSE");
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
		
		panWin.setLayout(null);
		int taille=300;
		JLabel Win = new JLabel(l.getSpriteMenu(100));
		panWin.add(Win);
		Win.setSize(300,300);
		Win.setBounds((panGame.getWidth()/2-taille/2),(panGame.getHeight()/2-taille/2),Win.getWidth(),Win.getHeight());
		
		panLose.setLayout(null);
		taille=300;
		JLabel Lose = new JLabel(l.getSpriteMenu(101));
		panLose.add(Lose);
		Lose.setSize(300,300);
		Lose.setBounds((panGame.getWidth()/2-taille/2),(panGame.getHeight()/2-taille/2),Lose.getWidth(),Lose.getHeight());
		
		panPrincipal.add(container);
		container.setBounds(espacement,2*espacement+logo.getHeight(),panGame.getWidth(),panGame.getHeight());
		panGame.setLayout(null);
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				this.Tableau[i][j]=new JLabel(Tab[i][j]);
				this.Tableau[i][j].setSize(nbPixelSprite,nbPixelSprite);
			}
		}
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				panGame.add(this.Tableau[i][j]);
				this.Tableau[i][j].setBounds(j*nbPixelSprite, i*nbPixelSprite, Tableau[i][j].getWidth(), Tableau[i][j].getHeight());
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
		
		panGame.setDoubleBuffered(true);
		
	}
	
	public String getKey(){
		return this.listener.getKey();
	}
	
	public void moveUP() throws InterruptedException{

		Tab=l.getTableau("UP");
		this.refresh();

	}
	
	public void moveDown() throws InterruptedException{

		Tab=l.getTableau("DOWN");
		this.refresh();
		
	}
	
	public void moveLeft() throws InterruptedException{
		
		Tab=l.getTableau("LEFT");
		this.refresh();

	}
	
	public void moveRight() throws InterruptedException{

		Tab=l.getTableau("RIGHT");
		this.refresh();

	}
	
	public void moveInit() throws InterruptedException{

		Tab=l.getTableau("INIT");
		this.refresh();
		
	}
	
	public void refresh(){
		
		panGame.removeAll();
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				this.Tableau[i][j]=new JLabel(Tab[i][j]);
				this.Tableau[i][j].setSize(nbPixelSprite,nbPixelSprite);
			}
		}
		
		for(int i = 0; i <= nbCasesHeight-1; i++){
			for(int j = 0; j <= nbCasesWidth-1; j++){
				panGame.add(this.Tableau[i][j]);
				this.Tableau[i][j].setBounds(j*nbPixelSprite, i*nbPixelSprite, Tableau[i][j].getWidth(), Tableau[i][j].getHeight());
			}
		}
		this.refreshScore();
		this.refreshLife();
		
		this.checkFinish();
		this.checkLife();
		
		this.getContentPane().repaint();
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
		if(nbLife>0){
			panStats.remove(Life[nbLife-1]);
		}	
	}
	
	@SuppressWarnings("deprecation")
	public void newLevel(){
		listener.stop();
		this.saveScore();
		this.dispose();
		new Game(level+1,pseudo);
	}

	@SuppressWarnings("deprecation")
	public void restartLevel(){
		listener.stop();
		this.saveScore();
		this.dispose();
		new Game(level,pseudo);
	}
	
	
	public boolean checkWin(){
		return l.checkFinish();
	}
	
	public boolean checkMort(){
		return l.checkMort();
	}
	
	@SuppressWarnings("deprecation")
	public void checkFinish(){
		if(l.checkFinish()){
			
			cl.show(container, "WIN");
			this.son.stop();
			this.stopGame();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void checkLife(){
		if(l.getNbLife()<=0){
			
			cl.show(container, "LOSE");
			this.son.stop();
			this.stopGame();
		}
	}
	
	public boolean checkGameOver(){
		if(l.getNbLife()<=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void saveScore(){
		l.saveScore(level, l.getScore(), pseudo);
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public void stopGame(){
		listener.stopGame();
	}

}
