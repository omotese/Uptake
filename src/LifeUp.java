import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * This power up gives the hero an extra life.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class LifeUp extends PowerUp {

	public LifeUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.black);
	}

	public void collideWithHero(Hero h) {
		h.collideWithLifeUp(this);
		this.setSize(0);
	}

	@Override
	public String getName() {
		return "extralife";
	}

}
