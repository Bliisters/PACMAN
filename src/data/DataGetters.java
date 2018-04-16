package data;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

/**
 * Classe d'interface pour le package view
 *
 * @author Quentin FLEGEAU
 *
 * 
 */

public interface DataGetters {
	
	
	/**
     * Convert a text file to an int[][][] tab.
     * Each values are representing a different element : 
     * 
     * 00 -> Background
	 * 01 -> Wall
	 * 02 -> Gomme
	 * 03 -> Super Gomme
	 * 04 -> Cherry
	 * 05 -> PacMan
	 * 06 -> Blinky
	 * 07 -> Pinky
	 * 08 -> Inky
	 * 09 -> Clyde
     * 
     * @param the value of the current level
     *
     * @return an int tab representing the position of the Tiles 
     */
	public int[][] getTableau(int i);
	
	
	/**
     * Give the game tab width
     *
     * @return an int representing the width of the game tab
     */
	public int getMapiWidth(int i);
	
	
	/**
     * Give the game tab height
     *
     * @return an int representing the height of the game tab
     */
	public int getMapiHeight(int i);
	
	
	
	
	/**
     * Give the sprite
     * 
     * 0 -> Basic Left
	 * 1 -> Basic Right
	 * 2 -> Basic Up
	 * 3 -> Basic Down
     * 
     * @param the value of the sprite specified in the doc
     *
     * @return the ImageIcon of PacMan
     */
	public ImageIcon getSpritePacMan(int i);
	
	
	/**
     * Give the sprite
     * 
     * @param the value of the sprite specified in the doc
     * 
     * 0 -> Basic Left
	 * 1 -> Basic Right
	 * 2 -> Basic Up
	 * 3 -> Basic Down
	 * 4 -> Killed Left
	 * 5 -> Killed Right
	 * 6 -> Killed Up
	 * 7 -> Killed Down
	 * 8 -> Danger White
	 * 9 -> Danger Blue
     *
     * @return the ImageIcon of Blinky
     */
	public ImageIcon getSpriteBlinky(int i);
	
	
	/**
     * Give the sprite
     * 
     * 0 -> Basic Left
	 * 1 -> Basic Right
	 * 2 -> Basic Up
	 * 3 -> Basic Down
	 * 4 -> Killed Left
	 * 5 -> Killed Right
	 * 6 -> Killed Up
	 * 7 -> Killed Down
	 * 8 -> Danger White
	 * 9 -> Danger Blue
     * 
     * @param the value of the sprite specified in the doc
     *
     * @return the ImageIcon of Pinky
     */
	public ImageIcon getSpritePinky(int i);
	
	
	/**
     * Give the sprite
     * 
     * @param the value of the sprite specified in the doc
     * 
     * 
	 * 0 -> Basic Left
	 * 1 -> Basic Right
	 * 2 -> Basic Up
	 * 3 -> Basic Down
	 * 4 -> Killed Left
	 * 5 -> Killed Right
	 * 6 -> Killed Up
	 * 7 -> Killed Down
	 * 8 -> Danger White
	 * 9 -> Danger Blue
     *
     * @return the ImageIcon of Inky
     */
	public ImageIcon getSpriteInky(int i);
	
	
	/**
     * Give the sprite
     * 
     * @param the value of the sprite specified in the doc
     * 
     * 0 -> Basic Left
	 * 1 -> Basic Right
	 * 2 -> Basic Up
	 * 3 -> Basic Down
	 * 4 -> Killed Left
	 * 5 -> Killed Right
	 * 6 -> Killed Up
	 * 7 -> Killed Down
	 * 8 -> Danger White
	 * 9 -> Danger Blue
     *
     * @return the ImageIcon of Clyde
     */
	public ImageIcon getSpriteClyde(int i);
	
	
	/**
     * Give the sprite
     * 
     * @param the value of the sprite specified in the doc
     * 0 -> Background
	 * 1 -> Wall
	 * 2 -> Gomme
	 * 3 -> Super Gomme
	 * 4 -> Fruit
     *
     * @return the ImageIcon of the corresponding Tile
     */
	public ImageIcon getSpriteTile(int i);
	
	
	
	
	/**
     * Give the menu image
     * 
     * @param the value of the sprite specified in the doc
     * 0 -> iconPACMAN
	 * 1 -> jrBouton
	 * 2 -> fondJeux
	 * 3 -> titrePacman
	 * 4 -> pacmanGif
	 * 5 -> fantomeGIF
     *
     * @return the ImageIcon of the corresponding Tile
     */
	public Image getSpriteMenuImage(int i);
	
	/**
     * Give the menu image
     * 
     * @param the value of the sprite specified in the doc
     * 0 -> iconPACMAN
	 * 1 -> jrBouton
	 * 2 -> fondJeux
	 * 3 -> titrePacman
	 * 4 -> pacmanGif
	 * 5 -> fantomeGIF
     *
     * @return the ImageIcon of the corresponding Tile
     */
	public ImageIcon getSpriteMenu(int i);
	
	
	/** 
     * Give the name and highscore associated
     * 
     * @param the value of the current level
     *
     * @return a String tab [nom][score]
     */
	public String[][] getHighccores(int i);
	
	
	
	/**
     * Give the rules
     * 
     * @param the value of the current level
     *
     * @return a int tab of rules like LifePoints
     */
	public int[] getRules(int i);
	
	public int getNbPixelSprite();
	
	public int getNbLifeMax(int i);
	
	public File getMusicFile(int i);

}
