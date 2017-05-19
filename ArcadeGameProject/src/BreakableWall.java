import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * TODO Put here a description of what this class does.
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
