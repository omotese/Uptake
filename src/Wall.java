import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Wall implements Drawable {
	private Color wallColor;
	private double x;
	private double y;
	
	private int wallSize;
	
	public Wall(double x, double y) {
		this.wallColor = Color.gray;
		this.x= x;
		this.y= y;
		this.wallSize=50;
	}
	public Shape getShape(){
		Rectangle2D.Double myRect= new Rectangle2D.Double(x,y,wallSize,wallSize);
		
		return myRect ;
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return wallColor;
	}


}
