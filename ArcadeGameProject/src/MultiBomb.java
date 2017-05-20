import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Power up allows the hero to drop multiple bombs at a time
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class MultiBomb extends PowerUp {

	public MultiBomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.GREEN);

	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithMultiBomb(this);
		this.setFuseStart(true);
		this.setSize(0);
	}

	/**
	 * Keeps track of how long the hero has the power up
	 */
	@Override
	public void updateFuse() {
		if (this.getFuseStart()) {
			if (getFuse() > 0) {
				this.setFuse(-1);
			} else {
				this.setFuseStart(false);
				this.getWorld().getHero().setMultiBomb(false);
				this.getWorld().getHero().setName("hero");
			}
		}

	}

	@Override
	public String getName() {
		return "multibomb";
	}

}
