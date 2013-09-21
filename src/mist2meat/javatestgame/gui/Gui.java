package mist2meat.javatestgame.gui;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Gui {

	ArrayList<GuiElement> elements = new ArrayList<GuiElement>();
	
	private boolean visible = true;
	
	public Gui() {
		
	}
	
	public void draw(Graphics g) {
		if(visible){
			for(GuiElement e : elements) {
				e.draw(g);
			}
		}
	}
	
	public void update(GameContainer container) {
		if(visible) {
			for(GuiElement e : elements) {
				e.update();
			}
		}
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void addElement(GuiElement e) {
		elements.add(e);
	}
	
	public void clear() {
		elements.clear();
	}
}
