import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * TODO Put here a description of what this class does.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public class Heart extends GameObject {

	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 * @param world
	 * @param centerPoint
	 */
	public Heart(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.setSize(50);
	}

	@Override
	public String getName() {
		return "lifeheart";
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(this.getCenterPoint().getX(), this.getCenterPoint().getY(), this.getSize(),
				this.getSize());
	}

}
