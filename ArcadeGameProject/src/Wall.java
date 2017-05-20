import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * These are the walls in the game, through which neither the hero nor the monsters can move.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class Wall extends GameObject {
	private String name;
	private double x;
	private double y;

	public Wall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.name = "wall";
		this.x = this.getCenterPoint().getX();
		this.y = this.getCenterPoint().getY();
		setColor(Color.gray);
		this.setSize(50);
	}

	@Override
	public Shape getShape() {
		Rectangle2D.Double myRect = new Rectangle2D.Double(x, y, this.getSize(), this.getSize());
		return myRect;
	}

	@Override
	public void collideWithHero(Hero h) {
		h.collideWithWall(this);
	}

	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithWall(this);
	}

	@Override
	public String getName() {
		return "wall";
	}

}
