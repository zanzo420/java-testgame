package mist2meat.javatestgame.object;

import mist2meat.javatestgame.input.Input;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class PlayerShip extends BaseObject {

	private float rotation, angvelocity;
	private Vector2f position, velocity;

	private float size = 128f;
	private float enginesize = 32f;

	private Image hull, engine;

	public PlayerShip(float x, float y) throws SlickException {
		velocity = new Vector2f(0, 0);
		angvelocity = 0f;

		position = new Vector2f(x, y);
		rotation = 0f;

		hull = new Image("res/gfx/objects/ship/hull.png");
		engine = new Image("res/gfx/objects/ship/engine.png");
	}

	@Override
	public void draw(Graphics g) {
		g.drawString("R: " + rotation, 5, 10);
		g.drawString("V: " + velocity.x + "," + velocity.y, 5, 25);

		g.rotate(position.x + 64, position.y + 64, rotation);

		g.setColor(Color.white);
		hull.draw(position.x, position.y, size, size);

		engine.draw(position.x, position.y);
		engine.draw(position.x + size - enginesize, position.y);
		engine.draw(position.x, position.y + size - enginesize);
		engine.draw(position.x + size - enginesize, position.y + size - enginesize);

		g.rotate(position.x + 64, position.y + 64, -rotation);
	}

	@Override
	public void update() {
		org.newdawn.slick.Input i = Input.getInput();

		float angstr = 0.05f;
		float movestr = 0.1f;

		float angdecay = 0.01f;
		float movedecay = 0.01f;

		Vector2f thrust = new Vector2f(0, 0);

		if (i.isKeyDown(org.newdawn.slick.Input.KEY_Q)) {
			angvelocity -= angstr;
		}
		if (i.isKeyDown(org.newdawn.slick.Input.KEY_E)) {
			angvelocity += angstr;
		}

		if (i.isKeyDown(org.newdawn.slick.Input.KEY_W)
				|| i.isKeyDown(org.newdawn.slick.Input.KEY_A)
				|| i.isKeyDown(org.newdawn.slick.Input.KEY_S)
				|| i.isKeyDown(org.newdawn.slick.Input.KEY_D)) {
			thrust.set(movestr, 0);

			float offset = 0f;

			if (i.isKeyDown(org.newdawn.slick.Input.KEY_A)) {
				offset = -90f;
			}
			if (i.isKeyDown(org.newdawn.slick.Input.KEY_D)) {
				offset = 90f;
			}

			if (i.isKeyDown(org.newdawn.slick.Input.KEY_W)) {
				offset *= 0.5f;
			}
			if (i.isKeyDown(org.newdawn.slick.Input.KEY_S)) {
				offset += (offset / 2) + (offset == 0 ? 180 : 0);
			}

			thrust.setTheta(rotation + offset);
		}

		if (i.isKeyDown(org.newdawn.slick.Input.KEY_SPACE)) {
			position.set(256, 256);
			rotation = 0f;

			angvelocity = 0f;
			velocity.set(0, 0);
		}

		velocity.add(thrust);

		position.add(velocity);
		rotation += angvelocity;

		rotation = rotation % 360;

		velocity.scale(1f - movedecay);
		angvelocity *= 1f - angdecay;
		
		engine.setRotation((float) (velocity.getTheta() - rotation));
	}
}
