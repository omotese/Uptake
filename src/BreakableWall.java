import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class BreakableWall extends Wall {
	private Color breakableColor;
	private GameWorld world;

	public BreakableWall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world=world;
		this.breakableColor = Color.blue;
	}
	
	@Override
	public Color getColor() {
		return breakableColor;
	}
	
	public void detectCollisionWithExplosion(){
		for (int i = 0; i < this.world.getObjectList().size(); i++) {
			if ((this.world.getObjectList().get(i) != this)
					&& this.getShape().intersects((Rectangle2D) this.world.getObjectList().get(i).getShape())) {
				this.collide(this.world.getObjectList().get(i));
			}
		}
	}
	
	@Override
	public void updatePosition() {
		detectCollisionWithExplosion();
	}
	
	
	//Collisions
	/*@Override
	public void collide(GameObject m) {
		m.collideWithBreakable(this);
	}
	@Override
	public void collideWithHero(Hero h) {
		h.collideWithBreakable(this);
	}
	
	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithBreakable(this);
	}
	public void collideWithSeeker(Seeker s) {
		s.collideWithBreakable(this);
	}*/
	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();
	}

}
