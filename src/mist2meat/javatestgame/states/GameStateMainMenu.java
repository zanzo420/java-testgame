package mist2meat.javatestgame.states;

import mist2meat.javatestgame.gui.Button;
import mist2meat.javatestgame.gui.Gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateMainMenu extends GameState {

	private Gui gui;
	
	@Override
	public void init() {
		gui = new Gui();
		
		//build gui
		gui.addElement(new Button(10,100,100,26,"NAPPI?!",new Runnable() {
			public void run() {
				System.out.println("klikked");
			}
		}));
	}
	
	@Override
	public void draw(GameContainer container, Graphics g) {
		g.drawString("MAIN MENU", container.getWidth()/2, 10);
		gui.draw(g);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		gui.update(container);
	}
}
