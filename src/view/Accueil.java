package view;

/**
 * Classe d'interface graphique pour le menu d'acceuil
 *
 * @author Quentin FLEGEAU
 *
 * 
 */

//On importe tout ce qui va �tre utile pour la classe.
import java.awt.*;
import logic.LogicGetters;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//////////////////////////////////////////////////////////////////////
//																	//
//							ACCEUIL									//
//																	//
//////////////////////////////////////////////////////////////////////

//Cette classe g�re la page d'acceuil. Elle extends JFrame puisque c'est une fen�tre.
public class Accueil extends JFrame implements ActionListener {
	
	//////////////////////////////////////////////////////////////////////
	//																	//
	//					INITIALISATION									//
	//																	//
	//////////////////////////////////////////////////////////////////////

	//On initialise toutes les variables.
	
	private static final long serialVersionUID = 1L;
	
	LogicGetters l = new LogicGetters(1);

	Audio son;
    
	CardLayout cl;
	Bouton boutJouer;
	Bouton boutScore;
	Bouton boutRetour;
	Bouton boutAnnuler;
	Bouton boutValidation;

	JPanel container;
	JPanel fondPseudo;
	JPanel fondScore;
	
	Panneau panPrincipal;
	Panneau panJouer;
	Panneau panScore;

	JLabel logo;
	JLabel logoAnime;
	JLabel logoAnime_2;
	JLabel logoAnime_PACMAN;
	JLabel pseudoLabel;
	JLabel levelLabel;

	Dimension dimFenetre = new Dimension(1280,720);

    JTextField pseudo = new JTextField(20);  
    
    JComboBox <Integer> choiceLevel = new JComboBox <Integer> ();
    
	//////////////////////////////////////////////////////////////////////
	//																	//
	//					CONTRUCTEUR										//
	//																	//
	//////////////////////////////////////////////////////////////////////

    
	public Accueil (){
		
		for(int i=1; i<=4; i++){
			choiceLevel.addItem(i);
		}
		
		son=new Audio(0);

		son.start();

		//R�glage des param�tre de la fen�tre : nom, taille, ...
		this.setTitle("PAC-MAN");
		this.setPreferredSize(dimFenetre);
		this.setMinimumSize(dimFenetre);
		this.setMaximumSize(dimFenetre);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setIconImage(l.getSpriteMenuImage(0));
		
		//Cr�ation des boutons
		boutJouer = new Bouton("Jouer", 400,40,l.getSpriteMenuImage(1));
		boutScore = new Bouton("Highscores", 400,40,l.getSpriteMenuImage(1));
		boutRetour = new Bouton("Retour",400,40,l.getSpriteMenuImage(1));
		boutAnnuler = new Bouton("Annuler",400,40,l.getSpriteMenuImage(1));
		boutValidation = new Bouton("Valider", 400,40,l.getSpriteMenuImage(1));

		//Cr�ation des JPanel ou plus p�cisement des Panneaux.
		container = new JPanel();
		panPrincipal = new Panneau(l.getSpriteMenuImage(2));
		panJouer = new Panneau(l.getSpriteMenuImage(2));
		panScore = new Panneau(l.getSpriteMenuImage(2));
		panScore = new Panneau(l.getSpriteMenuImage(2));
		fondPseudo= new JPanel();
		fondPseudo.setBackground(Color.yellow);
		fondScore= new JPanel();
		fondScore.setBackground(Color.BLACK);
		
		//Ajout d'un cardLayout.
		cl = new CardLayout();
		container.setLayout(cl);
		container.add(panPrincipal, "");
		container.add(panJouer, boutJouer.getStr());
		container.add(panScore, boutScore.getStr());
		
		//On d�fnit le container comme page qui sera affich�e.
		this.setContentPane(container);
		cl.first(container);
		
		//Ajout d'actionListener sur les boutons. Gr�ce � �a on peut d�tect� les clics.
		boutRetour.addActionListener(this);
		boutAnnuler.addActionListener(this);
		boutValidation.addActionListener(this);
		boutJouer.addActionListener(this);
		boutScore.addActionListener(this);
		
		//Cr�ation des JLabels pour les images. 
		logo = new JLabel(l.getSpriteMenu(3));
		logo.setSize(408, 232);
		logoAnime = new JLabel(l.getSpriteMenu(4));
		logoAnime.setSize(340, 325);
		logoAnime_2 = new JLabel(l.getSpriteMenu(5));
		logoAnime_2.setSize(340, 325);
		logoAnime_PACMAN = new JLabel(l.getSpriteMenu(6));
		logoAnime_PACMAN.setSize(15, 15);
		
		//Cr�ation des JLabels pour les textes fixes.
		pseudoLabel= new JLabel("Entrez votre pseudo :");
		pseudoLabel.setForeground(Color.BLACK);
		levelLabel= new JLabel("S�lection du level :");
		levelLabel.setForeground(Color.BLACK);
		
		//Parametrage du panneau panPrincipal.
		panPrincipal.setLayout(null);
	    panPrincipal.add(boutJouer);
	    boutJouer.setBounds((this.getWidth()/2)-(boutJouer.getLongueur()/2), 450, boutJouer.getLongueur(), boutJouer.getHauteur());
		panPrincipal.add(boutScore);
		boutScore.setBounds((this.getWidth()/2)-(boutScore.getLongueur()/2), 550, boutScore.getLongueur(), boutScore.getHauteur());
		panPrincipal.add(logo);
		logo.setBounds((this.getWidth()/2)-(logo.getWidth()/2), 25, logo.getWidth(), logo.getHeight());
		panPrincipal.add(logoAnime);
		logoAnime.setBounds(0, 200, logoAnime.getWidth(), logoAnime.getHeight());
		panPrincipal.add(logoAnime_2);
		logoAnime_2.setBounds((this.getWidth()-logoAnime_2.getWidth()), 200, logoAnime_2.getWidth(), logoAnime_2.getHeight());
		
		//Parametrage du panneau cr�erCompte.
		panJouer.setLayout(null);
		int longueurLabel=150;
		int hauteur=25;
		int longueurTextField=250;
		int longueurChoiceLevel=50;
		int espacementH = 20;
		panJouer.add(fondPseudo);
		fondPseudo.setBounds(this.getWidth()/2-((longueurTextField+longueurLabel+10)/2), 450, longueurTextField+longueurLabel+10, 2*hauteur+10+espacementH);
		fondPseudo.setLayout(null);
		fondPseudo.add(pseudoLabel);
		pseudoLabel.setBounds(5, 5, longueurLabel, hauteur);
		fondPseudo.add(pseudo);
		pseudo.setBounds(longueurLabel+5, 5, longueurTextField, hauteur);
		panJouer.add(boutValidation);
		boutValidation.setBounds(640, 625, boutValidation.getLongueur(), boutValidation.getHauteur());
		panJouer.add(boutAnnuler);
		boutAnnuler.setBounds(140, 625, boutAnnuler.getLongueur(), boutAnnuler.getHauteur());
		fondPseudo.add(choiceLevel);
		choiceLevel.setSize(longueurChoiceLevel,hauteur);
		choiceLevel.setBounds(fondPseudo.getWidth()-5-longueurChoiceLevel,5+espacementH+pseudoLabel.getHeight(),choiceLevel.getWidth(),choiceLevel.getHeight());
		fondPseudo.add(levelLabel);
		levelLabel.setSize(longueurLabel,hauteur);
		levelLabel.setBounds(5, 5+espacementH+pseudoLabel.getHeight(),levelLabel.getWidth() , levelLabel.getHeight());
		
		//Parametrage du panneau panScore.
		panScore.setLayout(null);
		int longueurScore=500;
		int HauteurScore=250;
		fondScore.setLayout(null);
		panScore.add(fondScore);
		fondScore.setBounds(this.getWidth()/2-longueurScore/2, this.getHeight()/2-HauteurScore/2, longueurScore, HauteurScore);
		this.setScore();
		panScore.add(boutRetour);
		boutRetour.setBounds(this.getWidth()/2-boutRetour.getLongueur()/2, 625, boutRetour.getLongueur(), boutRetour.getHauteur());	
		
	}
	
	//////////////////////////////////////////////////////////////////////
	//																	//
	//					METHODES										//
	//																	//
	//////////////////////////////////////////////////////////////////////

	
	public void setScore(){
		
		int espacementVertical=15;
		int espacementHorizontal=5;
		int espacementInterScore=10;
		int hauteurLabel=20;
		
		String tabScore[][]=new String[l.getNbLevel()*2][3];
		tabScore=l.getHighscore();
		int maxLevel=l.getNbLevel()*2;
		
		for (int i=0;i<=maxLevel-1;i++){
			String score=new String();
			if(i%2==0){
				score=("HighScore -> Level : "+tabScore[i][0]+", Pseudo : "+tabScore[i][1]+", Score  : "+tabScore[i][2]+".\n");
			}
			else{
				score=("Last Score -> Level : "+tabScore[i][0]+", Pseudo : "+tabScore[i][1]+", Score  : "+tabScore[i][2]+".\n");
			}
			JLabel scoreLabel=new JLabel(score);
			scoreLabel.setForeground(Color.WHITE);
			scoreLabel.setSize(fondScore.getWidth()-2*espacementHorizontal,hauteurLabel);
			fondScore.add(scoreLabel);
			scoreLabel.setBounds(espacementHorizontal, espacementVertical+(i*espacementInterScore)+(i*hauteurLabel), scoreLabel.getWidth(), scoreLabel.getHeight());
		}
		
	}
	
	
	@SuppressWarnings("deprecation")
	
	
	//Cette m�thode permet de r�aliser des action diff�rentes en fonction du bouton press�.
	public void actionPerformed(ActionEvent arg0) {

		//Affichage du Panneau Cr�erCompte.
		if(arg0.getSource() == boutJouer){
			
			panJouer.add(logo);
			logo.setBounds((this.getWidth()/2)-(logo.getWidth()/2), 25, logo.getWidth(), logo.getHeight());
			panJouer.add(logoAnime);
			logoAnime.setBounds(0, 200, logoAnime.getWidth(), logoAnime.getHeight());
			panJouer.add(logoAnime_2);
			logoAnime_2.setBounds((this.getWidth()-logoAnime_2.getWidth()), 200, logoAnime_2.getWidth(), logoAnime_2.getHeight());
			
			cl.show(container, boutJouer.getStr());
		} 
		
		//Affichage du Panneau panScore.
		if(arg0.getSource() == boutScore){
			
			panScore.add(logo);
			logo.setBounds((this.getWidth()/2)-(logo.getWidth()/2), 25, logo.getWidth(), logo.getHeight());
			panScore.add(logoAnime);
			logoAnime.setBounds(0, 200, logoAnime.getWidth(), logoAnime.getHeight());
			panScore.add(logoAnime_2);
			logoAnime_2.setBounds((this.getWidth()-logoAnime_2.getWidth()), 200, logoAnime_2.getWidth(), logoAnime_2.getHeight());
			
			cl.show(container, boutScore.getStr());
		}

		//Affichage du Panneau Accueil.
		if ((arg0.getSource() == (boutRetour)) || (arg0.getSource() == (boutAnnuler) )){
			
			panPrincipal.add(logo);
			logo.setBounds((this.getWidth()/2)-(logo.getWidth()/2), 25, logo.getWidth(), logo.getHeight());
			panPrincipal.add(logoAnime);
			logoAnime.setBounds(0, 200, logoAnime.getWidth(), logoAnime.getHeight());
			panPrincipal.add(logoAnime_2);
			logoAnime_2.setBounds((this.getWidth()-logoAnime_2.getWidth()), 200, logoAnime_2.getWidth(), logoAnime_2.getHeight());
			
			cl.first(container);
		}

		
		//Cr�ation du compte.
		if(arg0.getSource() == boutValidation){
			
			if(this.pseudo.getText().equals("")==false){
				new Game((int)this.choiceLevel.getSelectedItem(),this.pseudo.getText());
				this.dispose();
				son.stop();
			}
			else{
				JOptionPane.showMessageDialog(null, "Veuillez entrer un pseudo !", "Information", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
