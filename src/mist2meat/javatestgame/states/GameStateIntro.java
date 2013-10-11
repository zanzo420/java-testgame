package mist2meat.javatestgame.states;

import mist2meat.javatestgame.main.MainGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateIntro extends GameState {

	private long t;
	private long lifetime = 4000;
	private Color color;
	
	@Override
	public void init() {
		color = new Color(255,255,255);
		t = System.currentTimeMillis();
	}
	
	@Override
	public void draw(GameContainer container, Graphics g) {
		float passed = (System.currentTimeMillis() - t);
		if(System.currentTimeMillis() > t + (lifetime/2)) {
			color.a = 1 - ((passed / (lifetime/2f)) - 1);
		}else{
			color.a = passed / (lifetime/2f);
		}
		
		g.setColor(color);
		g.drawString("HELLO!", container.getWidth()/2, container.getHeight()/2);
		g.setColor(Color.white);
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		if(System.currentTimeMillis() > t + lifetime) {
			MainGame.setGameState(new GameStateMainMenu());
		}
	}
}
