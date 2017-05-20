
import java.awt.geom.Point2D;

/**
 * An object that has a position to be drawn on the screen
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public interface Relocatable {

	void setCenterPoint(Point2D point);

	Point2D getCenterPoint();

}