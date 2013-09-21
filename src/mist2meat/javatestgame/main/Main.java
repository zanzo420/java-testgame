package mist2meat.javatestgame.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		AppGameContainer agc = new AppGameContainer(new MainGame("Test"));
		agc.setTargetFrameRate(60);
		agc.setDisplayMode(800, 600, false);
		agc.start();
	}

}
