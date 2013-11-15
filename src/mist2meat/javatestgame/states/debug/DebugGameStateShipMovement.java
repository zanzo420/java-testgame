package mist2meat.javatestgame.states.debug;

import mist2meat.javatestgame.effects.BackgroundStarsEffect;
import mist2meat.javatestgame.main.Main;
import mist2meat.javatestgame.object.PlayerShip;
import mist2meat.javatestgame.states.GameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class DebugGameStateShipMovement extends GameState {

	private PlayerShip ship;
	private BackgroundStarsEffect stareffect;
	
	@Override
	public void init() {
		stareffect = new BackgroundStarsEffect();
		try {
			ship = new PlayerShip(256,256);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(GameContainer container, Graphics g) {
		stareffect.draw(g);
		ship.draw(g);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		ship.setPosition(Main.getScrCenter());
		ship.update();
		stareffect.setVelocity(ship.getVelocity());
		stareffect.update();
	}
}
