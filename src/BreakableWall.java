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

	@Override
	public void collideWithExplosion(Explosion e) {
		this.die();
	}

}
