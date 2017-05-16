import java.awt.Color;
import java.awt.geom.Point2D;

public class BombExpand extends PowerUp {

	public BombExpand(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.MAGENTA);
	}

	public void allowBig() {
		this.getWorld().getHero().setHasExpandBombPowerUp(true);
	}

	@Override
	public void collideWithHero(Hero h) {
		allowBig();
		this.fuseStart = true;
		this.size = 0;
	}

	public void expandBomb() {
		for (Bomb b : this.getWorld().getBombList()) {
		}

	}

	@Override
	public void updateFuse() {
		if (fuse > 0) {
			this.fuse--;
		} else {
			this.fuseStart = false;
			this.getWorld().getHero().setHasExpandBombPowerUp(false);
		}
	}

}
