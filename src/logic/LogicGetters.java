package logic;
import java.awt.Image;

import javax.swing.ImageIcon;

import data.Data;

public class LogicGetters implements Logic{
	
	Data d;
	
	public LogicGetters(){
		d = new Data();
	}

	@Override
	public int getNbCasesWidth(int i) {
		return d.getMapiWidth(i);
	}

	@Override
	public int getNbCasesHeight(int i) {
		return d.getMapiHeight(i);
	}

	@Override
	public ImageIcon getSpriteTiles(int i) {
		return d.getSpriteTile(i);
	}

	@Override
	public int getHighscore(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRules(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Image getSpriteMenuImage(int i) {
		return d.getSpriteMenuImage(i);
	}

	@Override
	public ImageIcon getSpriteMenu(int i) {
		return d.getSpriteMenu(i);
	}

}
