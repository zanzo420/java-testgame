package mist2meat.javatestgame.states;

import mist2meat.javatestgame.gui.Button;
import mist2meat.javatestgame.gui.Gui;
import mist2meat.javatestgame.gui.Label;
import mist2meat.javatestgame.gui.TextBox;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateMainMenu extends GameState {

	private Gui curGui;
	
	private Gui mainGui,playGui,optionsGui,createUniverseGui;
	
	@Override
	public void init() {
		mainGui = new Gui();
		playGui = new Gui();
		createUniverseGui = new Gui();
		optionsGui = new Gui();
		
		//build main gui		
		mainGui.addElement(new Button(10,100,100,26,"Play Game",new Runnable() {
			public void run() {
				curGui = playGui;
			}
		}));
		
		mainGui.addElement(new Button(10,150,100,26,"Options",new Runnable() {
			public void run() {
				curGui = optionsGui;
			}
		}));
		
		mainGui.addElement(new Button(10,200,100,26,"Exit",new Runnable() {
			public void run() {
				System.exit(0);
			}
		}));
		
		//build play game gui
		playGui.addElement(new Button(10,100,150,30,"Create universe",new Runnable() {
			public void run() {
				curGui = createUniverseGui;
			}
		}));
		
		playGui.addElement(new Button(10,500,100,26,"Back",new Runnable() {
			public void run() {
				curGui = mainGui;
			}
		}));
		
		//build create universe gui
		createUniverseGui.addElement(new Label(10,100,"Create universe"));
		createUniverseGui.addElement(new Label(10,130,"Name:"));
		
		final TextBox namebox = new TextBox(10,160,100,26);
		createUniverseGui.addElement(namebox);
		
		createUniverseGui.addElement(new Button(10,300,100,26,"Create",new Runnable() {
			public void run() {
				if(namebox.getText().length() > 0){
					System.out.println("Creating universe: \""+namebox.getText()+"\"");
				}
			}
		}));
		
		createUniverseGui.addElement(new Button(10,500,100,26,"Back",new Runnable() {
			public void run() {
				curGui = playGui;
			}
		}));
		
		//build options gui
		optionsGui.addElement(new Button(10,100,100,26,"Back",new Runnable() {
			public void run() {
				curGui = mainGui;
			}
		}));
		
		curGui = mainGui;
	}
	
	@Override
	public void draw(GameContainer container, Graphics g) {
		curGui.draw(g);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		curGui.update(container);
	}
}
