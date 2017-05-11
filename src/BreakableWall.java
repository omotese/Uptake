import java.awt.Color;
import java.awt.geom.Point2D;

public class BreakableWall extends Wall {
	private Color breakableColor;

	public BreakableWall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.breakableColor = Color.blue;
	}
	
	@Override
	public Color getColor() {
		return breakableColor;
	}
	//Collisions
	@Override
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
	@Override
	public void collideWithExplosion(Explosion e) {
	}

}
