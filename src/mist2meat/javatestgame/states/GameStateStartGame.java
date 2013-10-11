package mist2meat.javatestgame.states;

import mist2meat.javatestgame.gui.Button;
import mist2meat.javatestgame.gui.Gui;
import mist2meat.javatestgame.gui.Label;
import mist2meat.javatestgame.gui.TextBox;
import mist2meat.javatestgame.main.MainGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateStartGame extends GameState {

	private Gui gui;
	
	@Override
	public void init() {
		gui = new Gui();
		
		gui.addElement(new Label(10,0,"Lore blah blah"));
		
		gui.addElement(new Label(10,100,"Enter character name"));
		
		gui.addElement(new TextBox(10, 150, 100, 26));
		
		gui.addElement(new Button(10, 200, 100, 26, "Continue", new Runnable() {
			public void run() {
				MainGame.setGameState(new GameStateTutorial()); //TODO: way to skip tutorial
			}
		}));
	}
	
	@Override
	public void draw(GameContainer container, Graphics g) {
		gui.draw(g);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		gui.update(container);
	}
}
