
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

/**
 * Drawable objects can be drawn on the game screen, so this handles some of the things needed to draw them.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public interface Drawable {

	Color getColor();

	Shape getShape();

	int getSize();

	void setSize(int size);

	void drawImage(Graphics2D g2);

}
