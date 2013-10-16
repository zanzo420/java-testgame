package mist2meat.javatestgame.states;

import mist2meat.javatestgame.object.PlayerShip;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class DebugGameStateShipMovement extends GameState {

	private PlayerShip ship;
	
	@Override
	public void init() {
		ship = new PlayerShip(256,256);
	}

	@Override
	public void draw(GameContainer container, Graphics g) {
		ship.draw(g);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		ship.update();
	}
}
