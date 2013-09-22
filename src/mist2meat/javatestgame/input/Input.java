package mist2meat.javatestgame.input;

import org.lwjgl.input.Mouse;

public class Input {

	private static org.newdawn.slick.Input input;
	
	public static void setInput(org.newdawn.slick.Input i) {
		input = i;
	}
	
	public static org.newdawn.slick.Input getInput() {
		return input;
	}
	
	public static int getMouseX() {
		return Mouse.getX();
	}
	
	public static int getMouseY() {
		return 600 - Mouse.getY();
	}
	
	public static boolean getMouse1() {
		return Mouse.isButtonDown(0);
	}
}
