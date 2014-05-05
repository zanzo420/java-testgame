package mist2meat.javatestgame.states.debug;

import mist2meat.javatestgame.effects.BackgroundStarsEffect;
import mist2meat.javatestgame.states.GameState;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

public class DebugGameStateTilemap extends GameState {
	private TiledMap map;
	private int x,y;
	private BackgroundStarsEffect stareffect;
	
	@Override
	public void init() {
		stareffect = new BackgroundStarsEffect();
		stareffect.setVelocity(new Vector2f(1,0));
		try {
			map = new TiledMap("res/tilemaps/debug.tmx", "res/tilesets");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(GameContainer container, Graphics g) {
		stareffect.draw(g);
		map.render(x,y);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		stareffect.update();
		if(Mouse.isButtonDown(0)){
			x += Mouse.getDX();
			y -= Mouse.getDY();
		}
	}
}
