package mist2meat.javatestgame.main;

import org.lwjgl.input.Mouse;

public class Input {

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
