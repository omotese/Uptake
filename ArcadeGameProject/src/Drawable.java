

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;


public interface Drawable {

	Color getColor();

	Shape getShape();
	
	int getSize();
	
	BufferedImage getImage();
	

}
