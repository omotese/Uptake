import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Wall {
	private Color wallColor;
	private static final int SIZE = 30;
	
	public Wall(GameWorld world) {
		this.wallColor = Color.gray;
	}
	public Shape drawWall(double x, double y){
		return new Rectangle2D.Double(x,y,SIZE,SIZE);
	}

}
