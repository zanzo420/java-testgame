package mist2meat.javatestgame.states.debug;

import mist2meat.javatestgame.object.PlayerShip;
import mist2meat.javatestgame.states.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class DebugGameStateShipMovement extends GameState {

	private PlayerShip ship;
	
	@Override
	public void init() {
		try {
			ship = new PlayerShip(256,256);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
