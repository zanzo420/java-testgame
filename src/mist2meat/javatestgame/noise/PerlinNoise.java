package mist2meat.javatestgame.noise;

import java.util.Random;

public class PerlinNoise {
	
	public static float[][] generateNoise(int width, int height, int octaves, float persistance, float amplitude, float frequency) {
		float[][] whitenoise = generateWhiteNoise(width,height);
		
		float[][] perlinNoise = generatePerlinNoise(whitenoise, width, height, octaves, persistance, amplitude, frequency);
		
		return perlinNoise;
	}
	
	private static float[][] generatePerlinNoise(float[][] whiteNoise, int width, int height, int octaves, float persistance, float amplitude, float frequency) {
		float[][] perlinNoise = new float[width][height];
		
		float[][][] smoothNoise = new float[octaves][width][height];
		
		float totalAmplitude = 0.0f;
		
		for(int i = 0; i < octaves; i++){
			smoothNoise[i] = generateSmoothNoise(whiteNoise, width, height, i, frequency);
		}
		
		for(int octave = octaves - 1; octave >= 0; octave--) {
			amplitude *= persistance;
			totalAmplitude += amplitude;
			
			for(int x = 0; x < width; x++) {
				for(int y = 0; y < height; y++) {
					perlinNoise[x][y] += smoothNoise[octave][x][y] * amplitude;
				}
			}
		}
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				perlinNoise[x][y] /= totalAmplitude;
			}
		}
		
		return perlinNoise;
	}

	private static float[][] generateWhiteNoise(int width, int height) {
		Random random = new Random(1337);
		
		float[][] whiteNoise = new float[width][height];
		
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				whiteNoise[x][y] = (float)random.nextDouble() % 1;
			}
		}
		
		return whiteNoise;
	}
	
	private static float[][] generateSmoothNoise(float[][] whiteNoise, int width, int height, int octave, float frequency) {
		float[][] smoothNoise = new float[width][height];
		
		int samplePeriod = 1 << octave;
		
		for(int x = 0; x < width; x++){
			int sample_x0 = (x / samplePeriod) * samplePeriod;
			int sample_x1 = (sample_x0 + samplePeriod) % width;
			float horizontal_blend = (x - sample_x0) * frequency;
			
			for(int y = 0; y < height; y++){
				int sample_y0 = (y / samplePeriod) * samplePeriod;
				int sample_y1 = (sample_y0 + samplePeriod) % height;
				float vertical_blend = (y - sample_y0) * frequency;
				
				float top = interpolate(whiteNoise[sample_x0][sample_y0],whiteNoise[sample_x1][sample_y0],horizontal_blend);
				float bottom = interpolate(whiteNoise[sample_x0][sample_y1],whiteNoise[sample_x1][sample_y1],horizontal_blend);
				
				smoothNoise[x][y] = interpolate(top,bottom,vertical_blend);
			}
		}
		
		return smoothNoise;
	}
	
	private static float interpolate(float x, float y, float alpha) {
		return x * (1 - alpha) + alpha * y;
	}
}
