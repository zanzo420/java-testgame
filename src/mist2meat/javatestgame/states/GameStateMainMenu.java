package mist2meat.javatestgame.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateMainMenu extends GameState {

	@Override
	public void draw(GameContainer container, Graphics g) {
		g.drawString("MAIN MENU", container.getWidth()/2, 10);
	}
}
