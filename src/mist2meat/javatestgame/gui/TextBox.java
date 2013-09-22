package mist2meat.javatestgame.gui;

import java.util.ArrayList;

import mist2meat.javatestgame.input.Input;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.KeyListener;

public class TextBox extends GuiElement {
	
	private ArrayList<Character> text = new ArrayList<Character>();
	
	private Color bgColor = new Color(50,50,50);
	private Color textColor = Color.white;
	private Color borderColor = new Color(100,100,100);
	
	public TextBox(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		Input.getInput().addKeyListener(new KeyListener() {
			@Override
			public void inputEnded() {}

			@Override
			public void inputStarted() {}

			@Override
			public boolean isAcceptingInput() {
				return true;
			}

			@Override
			public void setInput(org.newdawn.slick.Input arg0) {}

			@Override
			public void keyPressed(int key, char c) {
				if(key == org.newdawn.slick.Input.KEY_BACK) {
					if(text.size() > 0) {						
						text.remove(text.size()-1);
					}
				}else{					
					text.add(c);
				}
			}

			@Override
			public void keyReleased(int arg0, char arg1) {}
		});
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(bgColor);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		
		g.setColor(borderColor);
		g.drawRect(getX(), getY(), getWidth(), getHeight());
		
		g.setColor(textColor);
		g.drawString(getText(), getX(), getY());
	}
	
	@Override
	public void update() {
		
	}
	
	public String getText() {
		String str = "";
		
		for(char c : text) {
			str += c;
		}
		
		return str;
	}

}
