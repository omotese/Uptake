import java.awt.Color;
import java.awt.geom.Point2D;

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
