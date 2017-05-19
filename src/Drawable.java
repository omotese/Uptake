
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

/**
 * TODO Put here a description of what this class does.
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
