import java.awt.Color;
import java.awt.Shape;
import java.awt.Transparency;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BreakableWall extends Wall {
	private String name;
	private Color color;

	public BreakableWall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.color = Color.blue;
	}

	// Drawable--------------------------------------

	// Temporal--------------------------------------

	// @Override
	// public void updatePosition() {
	// detectCollisionWithExplosion();
	// }

	// Relocatable------------------------------------

	// Collision--------------------------------------
	
	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();
	}

	// ---------------------------------------------------

	// public void detectCollisionWithExplosion() {
	// for (int i = 0; i < this.getWorld().getObjectList().size(); i++) {
	// if ((this.getWorld().getObjectList().get(i) != this)
	// && this.getShape().intersects((Rectangle2D)
	// this.getWorld().getObjectList().get(i).getShape())) {
	// this.collide(this.getWorld().getObjectList().get(i));
	// }
	// }
	// }

}
