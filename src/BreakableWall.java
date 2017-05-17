import java.awt.Color;
import java.awt.geom.Point2D;

public class BreakableWall extends Wall {
	public BreakableWall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.blue);
	}
	
	@Override
	public String getName() {
		return "breakablewall";
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
