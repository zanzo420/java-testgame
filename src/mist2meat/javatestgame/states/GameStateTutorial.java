package mist2meat.javatestgame.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateTutorial extends GameState {

	@Override
	public void init() {
		//TODO: teaches basic mechanics (controlling ship, docking to stations, exploring, etc)
	}
	
	@Override
	public void draw(GameContainer container, Graphics g) {
		g.drawString("*insert tutorial here*", 10, 100);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		
	}
}
