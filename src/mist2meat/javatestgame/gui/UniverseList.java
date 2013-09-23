package mist2meat.javatestgame.gui;

import java.util.ArrayList;

import mist2meat.javatestgame.universe.UniverseManager;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class UniverseList extends GuiElement {

	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	private Color bgColor = new Color(50,50,50);
	
	public UniverseList(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		refresh();
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(bgColor);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		for(Button b : buttons) {
			b.draw(g);
		}
		g.setColor(Color.white);
	}
	
	@Override
	public void update() {
		for(Button b : buttons) {
			b.update();
		}
	}

	public void refresh() {
		buttons.clear();
		
		int off = 6;
		
		int i = 0;
		for(final String name : UniverseManager.getUniverses()){
			buttons.add(new Button(getX()+(off/2), getY()+off+(i*31), getWidth()-off, 30, name, new Runnable() {
				public void run() {
					UniverseManager.loadUniverse(name);
				}
			}));
			i++;
		}
	}

}
