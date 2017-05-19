import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * TODO Put here a description of what this class does.
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
	 * TODO
	 */
	@Override
	public void updateFuse() {
		if (this.getFuseStart()) {
			if (getFuse() > 0) {
				this.setFuse(-1);
				System.out.println(this.getFuse());
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
