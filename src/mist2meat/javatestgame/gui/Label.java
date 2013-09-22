package mist2meat.javatestgame.gui;

import org.newdawn.slick.Graphics;

public class Label extends GuiElement {

	private String text;
	private boolean center = false;
	
	public Label(int x, int y, String text) {
		super(x, y, 0, 0);
		
		this.text = text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setCentered(boolean b) {
		center = b;
	}
	
	public boolean getCentered() {
		return center;
	}
	
	@Override
	public void draw(Graphics g) {
		float xoffset = 0;
		float yoffset = 0;
		
		if(center) {
			xoffset = g.getFont().getWidth(text) / 2;
			yoffset = g.getFont().getHeight(text) / 2;
		}
		
		g.drawString(text, getX()-xoffset, getY()-yoffset);
	}

}
