package mist2meat.javatestgame.gui;

import mist2meat.javatestgame.input.Input;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Button extends GuiElement {
	
	private Image curImage;
	
	private Image image;
	private Image hoverImage;
	private Image depressedImage;
	
	private int state = 0;
	
	private Runnable function;
	
	private Label label;
	
	public Button(int x, int y, int w, int h, String text, Runnable function) {
		super(x,y,w,h);
		
		label = new Label(x+w/2,y+h/2,text);
		label.setCentered(true);
		
		try {
			image = new Image("res/gfx/gui/button/button.png");
			hoverImage = new Image("res/gfx/gui/button/button_hover.png");
			depressedImage = new Image("res/gfx/gui/button/button_depressed.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		curImage = image;
		
		this.function = function;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		
		curImage.draw(getX(), getY(), getWidth(), getHeight());
		
		label.draw(g);
	}
	
	@Override
	public void update() {
		if(hovering() && !depressed() && state == 2) {
			function.run();
		}
		
		if(depressed()) {
			curImage = depressedImage;
			state = 2;
		}else if(hovering()) {
			curImage = hoverImage;
			state = 1;
		}else{
			curImage = image;
			state = 0;
		}
	}
	
	private boolean hovering() {
		int x = Input.getMouseX();
		int y = Input.getMouseY();
		
		if(x > getX() && y > getY()){
			if(x < getX()+getWidth() && y < getY()+getHeight()){
				return true;
			}
		}
		return false;
	}
	
	private boolean depressed() {
		if(hovering() && Input.getMouse1()) {
			return true;
		}
		return false;
	}
}
