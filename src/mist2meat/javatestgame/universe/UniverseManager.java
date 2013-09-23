package mist2meat.javatestgame.universe;

import java.io.File;
import java.util.ArrayList;

public class UniverseManager {

	public static ArrayList<String> getUniverses() {
		ArrayList<String> list = new ArrayList<String>();
		
		File dir = new File("save/universes");
		if(dir.isDirectory()){
			for(File file : dir.listFiles()){
				if(file.isDirectory()){
					list.add(file.getName());
				}
			}
		}
		
		return list;
	}
	
	public static void createUniverse(String name) {
		System.out.println("Creating universe: "+name);
		
		File dir = new File("save/universes/"+name);
		if(!dir.isDirectory()){
			dir.mkdirs();
		}
		
		//initialise file structure / generation
	}

	public static void loadUniverse(String name) {
		System.out.println("Loading universe: "+name);
	}
}
