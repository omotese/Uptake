import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * This power up extends the blast radius of the bomb.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class BombExpand extends PowerUp {

	public BombExpand(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.MAGENTA);
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithBombExpand(this);
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
				this.getWorld().getHero().setHasExpandBomb(false);
				this.getWorld().getHero().setName("hero");
			}
		}
	}

	@Override
	public String getName() {
		return "bombexpand";
	}

}
