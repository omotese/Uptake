
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public interface Drawable {

	Color getColor();

	Shape getShape();

	int getSize();

	void setSize(int size);

	void drawImage(Graphics2D g2);

}
