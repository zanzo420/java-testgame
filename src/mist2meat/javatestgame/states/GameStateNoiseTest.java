package mist2meat.javatestgame.states;

import mist2meat.javatestgame.noise.PerlinNoise;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GameStateNoiseTest extends GameState {

	int width,height;
	float[][] noise;
	
	@Override
	public void init() {
		width = 800;
		height = 600;
		
		int octaves = 4;
		float persistance = 0.1f;
		float amplitude = 1f;
		float frequency = 0.1f;
		
		noise = PerlinNoise.generateNoise(width, height, octaves, persistance, amplitude, frequency);
	}

	@Override
	public void draw(GameContainer container, Graphics g) {
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				float noiseval = noise[x][y];
				if(noiseval <= 0.995) {
					continue;
				}
				Color c = Color.white;
				c.a = noiseval;
				g.setColor(c);
				g.fillRect(x,y,1,1);
			}
		}
	}
	
	@Override
	public void update(GameContainer container, int delta) {
		
	}
}
