package mist2meat.javatestgame.main;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Main {

	public static final int scrw = 800;
	public static final int scrh = 600;
	private static Vector2f scrCenter;
	
	public static void main(String[] args) throws SlickException {
		String osname = "windows";
		String os = System.getProperty("os.name");
		
		if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0){
			osname = "linux";
		}
		
		System.setProperty("org.lwjgl.librarypath", new File("lib/natives/"+osname).getAbsolutePath());
		
		scrCenter = new Vector2f(scrw/2,scrh/2);
		
		AppGameContainer agc = new AppGameContainer(new MainGame());
		agc.setTargetFrameRate(60);
		agc.setDisplayMode(scrw, scrh, false);
		agc.start();
	}
	
	public static Vector2f getScrCenter() {
		return scrCenter.copy();
	}

}
