import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * This power up makes the hero move faster.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class SpeedUp extends PowerUp {

	public SpeedUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.orange);
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithSpeedUp(this);
		this.setFuseStart(true);
		this.setSize(0);
	}

	/**
	 * Fuses control the amount of time the hero is allowed to have a power up.
	 */
	@Override
	public void updateFuse() {
		if (this.getFuseStart()) {
			if (getFuse() > 0) {
				this.setFuse(-1);
			} else {
				this.setFuseStart(false);
				this.getWorld().getHero().setIsFaster(false);
				this.getWorld().getHero().setName("hero");
			}
		}

	}

	@Override
	public String getName() {
		return "speedup";
	}

}
