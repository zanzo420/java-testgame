package mist2meat.javatestgame.effects;

import java.util.ArrayList;

import mist2meat.javatestgame.main.Main;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class BackgroundStarsEffect extends BaseEffect {
	
	private ArrayList<Star> stars;
	private Vector2f velocity;
	
	private final int layers = 4;
	private final int starsPerLayer = 200;

	@Override
	public void init() {
		stars = new ArrayList<Star>();
		
		for(int layer = 1; layer <= layers; layer++){
			for(int i = 1; i <= starsPerLayer; i++) {
				stars.add(new Star(layer));
			}
		}
		
		velocity = new Vector2f(0,0);
	}
	
	public void draw(Graphics g) {
		for(Star star : stars) {
			star.draw(g);
		}
	}
	
	@Override
	public void update() {
		for(Star star : stars) {
			star.update(velocity.copy());
		}
	}
	
	public void setVelocity(Vector2f vel) {
		velocity = vel.negate();
	}
	
	public class Star {
		
		private Vector2f pos;
		private int layer;
		
		public Star(int layer) {
			this.layer = layer;
			
			Vector2f vec = new Vector2f(1,0);
			vec.setTheta(Math.random() * 360);
			pos = Main.getScrCenter().add(vec.getNormal().scale((float) (-Math.random()*Main.scrw)));
		}

		public void update(Vector2f velocity) {
			pos.add(velocity.scale(1f/layer));
			
			if(pos.distance(Main.getScrCenter()) > Main.scrw){
				reset();
			}
		}
		
		private void reset() {
			Vector2f vel = velocity.copy();
			vel.setTheta(vel.getTheta() + (Math.random()-0.5)*Main.scrw);
			pos = Main.getScrCenter().add(vel.getNormal().scale(-Main.scrw));
		}

		public void draw(Graphics g) {
			g.setColor(Color.white.scaleCopy(1f/layer));
			g.drawRect(pos.x, pos.y, 1, 1);
		}
		
	}
}
