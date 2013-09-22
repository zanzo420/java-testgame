package mist2meat.javatestgame.main;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	/**
	 * @param args
	 * @throws SlickException 
	 */
	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath", new File("lib/native/windows").getAbsolutePath());
		
		AppGameContainer agc = new AppGameContainer(new MainGame());
		agc.setTargetFrameRate(60);
		agc.setDisplayMode(800, 600, false);
		agc.start();
	}

}
