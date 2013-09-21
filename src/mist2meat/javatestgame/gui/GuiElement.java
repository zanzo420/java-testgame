package mist2meat.javatestgame.gui;

import org.newdawn.slick.Graphics;

public class GuiElement {

	private int x,y,w,h;
	
	public GuiElement(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	public void setSize(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void update() {
		
	}
}
