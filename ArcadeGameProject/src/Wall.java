import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Wall implements Drawable {
	private Color wallColor;

	private static final int SIZE = 30;
	
	public Wall(GameWorld world) {
		this.wallColor = Color.gray;

	}
	public Shape getShape(){
		return new Rectangle2D.Double(30,30,SIZE,SIZE);
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return wallColor;
	}


}
