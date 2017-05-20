import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * These walls can be blown up and removed by the bomb.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
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
