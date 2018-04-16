package logic;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import data.Data;

public class LogicGetters implements Logic{
	
	Data d;
	Mapi m;
	
	public ImageIcon[][] getTableau(String key){
		return m.getTableau(key);
	}
	
	public LogicGetters(int level){
		d = new Data();
		m = new Mapi(level);
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

	@Override
	public int getNbPixelSprite() {
		return d.getNbPixelSprite();
	}

	@Override
	public int getNbLife() {
		return m.getNbLife();
	}

	@Override
	public int getNbLifeMax(int i) {
		return d.getNbLifeMax(i);
	}
	
	public int getScore(){
		return m.getScore();
	}

	@Override
	public File getMusicFile(int i) {
		return d.getMusicFile(i);
	}

	@Override
	public boolean checkFinish() {
		return m.checkFinish();
	}

	@Override
	public boolean checkMort() {
		return m.checkMort();
	}

}
