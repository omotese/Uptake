import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Seeker extends Monster {
	private Point2D centerPoint;
	private GameWorld world;
	private int x;
	private int y;
	private int dx;
	private int dy;

	public Seeker(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.world = world;
		this.x = (int) centerPoint.getX();
		this.y = (int) centerPoint.getY();
		this.dx=0;
		this.dy=0;
		
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}
	
	public Point2D reset(){
		return new Point2D.Double(this.x, this.y);
	}
	
	@Override
	public void updatePosition() {
		this.x += this.dx;
		this.y += this.dy;
	}
	
	

}
