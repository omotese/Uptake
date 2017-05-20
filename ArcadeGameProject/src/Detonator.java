import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * This power up allows the hero to detonate a bomb at a time of the player's choosing using the spacebar.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class Detonator extends PowerUp {

	public Detonator(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.cyan);
	}

	@Override
	public String getName() {
		return "detonator";
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithDetonator(this);
		this.setFuseStart(true);
		this.setSize(0);
	}

	@Override
	public void updateFuse() {
		if (this.getFuseStart()) {
			if (getFuse() > 0) {
				this.setFuse(-1);
			} else {
				this.setFuseStart(false);
				this.getWorld().getHero().setHasDetonator(false);
				this.getWorld().getHero().setName("hero");
			}
		}

	}

}
