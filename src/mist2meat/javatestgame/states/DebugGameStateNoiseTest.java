package mist2meat.javatestgame.states;

import mist2meat.javatestgame.input.Input;
import mist2meat.javatestgame.noise.PerlinNoise;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class DebugGameStateNoiseTest extends GameState {

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
				Color c = Color.black;
				
				if(noiseval < 0.5) {
					c = Color.blue;
				}else if(noiseval < 0.505) {
					c = Color.yellow;
				}else if(noiseval < 0.6) {
					c = Color.green;
				}else if(noiseval < 0.65) {
					c = Color.gray;
				}else if(noiseval < 0.8) {
					c = Color.white;
				}
				
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
