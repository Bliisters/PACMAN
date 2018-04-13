package view;

/**
 * Classe d'interface graphique pour le menu d'acceuil
 *
 * @author Quentin FLEGEAU
 *
 * 
 */

//On importe tout ce qui va être utile pour la classe.
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

//Cette classe gère la page d'acceuil. Elle extends JFrame puisque c'est une fenêtre.
public class Accueil extends JFrame implements ActionListener {
	
	//////////////////////////////////////////////////////////////////////
	//																	//
	//					INITIALISATION									//
	//																	//
	//////////////////////////////////////////////////////////////////////

	//On initialise toutes les variables.
	
	private static final long serialVersionUID = 1L;
	
	LogicGetters logicget = new LogicGetters();

	Audio son=new Audio();
    
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
	
	JLabel labelScore1;
	JLabel logo;
	JLabel logoAnime;
	JLabel logoAnime_2;
	JLabel logoAnime_PACMAN;
	JLabel pseudoLabel;

	Dimension dimFenetre = new Dimension(1280,720);

    JTextField pseudo = new JTextField(20);  
    
	//////////////////////////////////////////////////////////////////////
	//																	//
	//					CONTRUCTEUR										//
	//																	//
	//////////////////////////////////////////////////////////////////////

    
	public Accueil (){

		son.start();

		//Réglage des paramètre de la fenêtre : nom, taille, ...
		this.setTitle("PAC-MAN");
		this.setPreferredSize(dimFenetre);
		this.setMinimumSize(dimFenetre);
		this.setMaximumSize(dimFenetre);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setIconImage(new ImageIcon("images/iconPACMAN.png").getImage());
		
		//Création des boutons
		boutJouer = new Bouton("Jouer", 400,40,logicget.getSpriteMenuImage(1));
		boutScore = new Bouton("Highscores", 400,40,logicget.getSpriteMenuImage(1));
		boutRetour = new Bouton("Retour",400,40,logicget.getSpriteMenuImage(1));
		boutAnnuler = new Bouton("Annuler",400,40,logicget.getSpriteMenuImage(1));
		boutValidation = new Bouton("Valider", 400,40,logicget.getSpriteMenuImage(1));

		//Création des JPanel ou plus pécisement des Panneaux.
		container = new JPanel();
		panPrincipal = new Panneau(logicget.getSpriteMenuImage(2));
		panJouer = new Panneau(logicget.getSpriteMenuImage(2));
		panScore = new Panneau(logicget.getSpriteMenuImage(2));
		panScore = new Panneau(logicget.getSpriteMenuImage(2));
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
		
		//On défnit le container comme page qui sera affichée.
		this.setContentPane(container);
		cl.first(container);
		
		//Ajout d'actionListener sur les boutons. Grâce à ça on peut détecté les clics.
		boutRetour.addActionListener(this);
		boutAnnuler.addActionListener(this);
		boutValidation.addActionListener(this);
		boutJouer.addActionListener(this);
		boutScore.addActionListener(this);
		
		//Création des JLabels pour les images. 
		logo = new JLabel(logicget.getSpriteMenu(3));
		logo.setSize(408, 232);
		logoAnime = new JLabel(logicget.getSpriteMenu(4));
		logoAnime.setSize(340, 325);
		logoAnime_2 = new JLabel(logicget.getSpriteMenu(5));
		logoAnime_2.setSize(340, 325);
		logoAnime_PACMAN = new JLabel(logicget.getSpriteMenu(6));
		logoAnime_PACMAN.setSize(15, 15);
		
		//Création des JLabels pour les textes fixes.
		pseudoLabel= new JLabel("Entrez votre pseudo :");
		pseudoLabel.setForeground(Color.BLACK);
		labelScore1= new JLabel("1. : TIBO");
		labelScore1.setForeground(Color.WHITE);
		
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
		
		//Parametrage du panneau créerCompte.
		panJouer.setLayout(null);
		int longueurLabel=150;
		int hauteur=25;
		int longueurTextField=250;
		panJouer.add(fondPseudo);
		fondPseudo.setBounds(this.getWidth()/2-((longueurTextField+longueurLabel+10)/2), 450, longueurTextField+longueurLabel+10, hauteur+10);
		fondPseudo.setLayout(null);
		fondPseudo.add(pseudoLabel);
		pseudoLabel.setBounds(5, 5, longueurLabel, hauteur);
		fondPseudo.add(pseudo);
		pseudo.setBounds(longueurLabel+5, 5, longueurTextField, hauteur);
		panJouer.add(boutValidation);
		boutValidation.setBounds(640, 625, boutValidation.getLongueur(), boutValidation.getHauteur());
		panJouer.add(boutAnnuler);
		boutAnnuler.setBounds(140, 625, boutAnnuler.getLongueur(), boutAnnuler.getHauteur());
		
		//Parametrage du panneau panScore.
		panScore.setLayout(null);
		int longueurScore=500;
		int HauteurScore=250;
		int espacement=30;
		fondScore.setLayout(null);
		panScore.add(fondScore);
		fondScore.setBounds(this.getWidth()/2-longueurScore/2, this.getHeight()/2-HauteurScore/2, longueurScore, HauteurScore);
		fondScore.add(labelScore1);
		labelScore1.setBounds(espacement,espacement,longueurScore-2*espacement,espacement);
		panScore.add(boutRetour);
		boutRetour.setBounds(this.getWidth()/2-boutRetour.getLongueur()/2, 625, boutRetour.getLongueur(), boutRetour.getHauteur());	
		
	}
	
	//////////////////////////////////////////////////////////////////////
	//																	//
	//					METHODES										//
	//																	//
	//////////////////////////////////////////////////////////////////////

	
	@SuppressWarnings("deprecation")
	
	
	//Cette méthode permet de réaliser des action différentes en fonction du bouton pressé.
	public void actionPerformed(ActionEvent arg0) {

		//Affichage du Panneau CréerCompte.
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

		//Affichage du Panneau Acceuil.
		if ((arg0.getSource() == (boutRetour)) || (arg0.getSource() == (boutAnnuler) )){
			
			panPrincipal.add(logo);
			logo.setBounds((this.getWidth()/2)-(logo.getWidth()/2), 25, logo.getWidth(), logo.getHeight());
			panPrincipal.add(logoAnime);
			logoAnime.setBounds(0, 200, logoAnime.getWidth(), logoAnime.getHeight());
			panPrincipal.add(logoAnime_2);
			logoAnime_2.setBounds((this.getWidth()-logoAnime_2.getWidth()), 200, logoAnime_2.getWidth(), logoAnime_2.getHeight());
			
			cl.first(container);
		}

		
		//Création du compte.
		if(arg0.getSource() == boutValidation){
			
			if(this.pseudo.getText().equals("")==false){
				new Game(1);
				//new Jeux();
				this.dispose();
				son.stop();
			}
			else{
				JOptionPane.showMessageDialog(null, "Veuillez entrer un pseudo !", "Information", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
