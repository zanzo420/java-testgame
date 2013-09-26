package mist2meat.javatestgame.states;

import mist2meat.javatestgame.input.Input;
import mist2meat.javatestgame.noise.PerlinNoise;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateNoiseTest extends GameState {

	private int x,y,width,height;
	private float[][] noise;
	
	@Override
	public void init() {
		width = 800;
		height = 600;
		
		x = 0;
		y = 0;

		noise = new float[width][height];
		refreshNoise();
	}
	
	private void refreshNoise() {
		noise = new float[width][height];
		
		int frequency = 4;
		int octaves = 6;
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				noise[i][j] = PerlinNoise.noise((x+i), (y+j), octaves, frequency);
			}
		}
	}

	@Override
	public void draw(GameContainer container, Graphics g) {
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				float noiseval = noise[x][y];
				Color c = Color.white;
				
				c.a = noiseval;
				
				g.setColor(c);
				g.fillRect(x,y,1,1);
			}
		}
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		if(Input.getMouse1()){			
			x -= Mouse.getDX();
			y += Mouse.getDY();
			refreshNoise();
		}
	}
}
