import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Hero extends Character {
	private double x;
	private double y;
	private double dx;
	private double dy;
	private Point2D centerPoint;
	public Hero(GameWorld world) {
		super(world);
		this.x= 50;
		this.y=50;
		this.dx=0;
		this.dy=0;
		this.centerPoint= new Point2D.Double(x,y);
	}
	
	public void moveUp() {
		dy=0.5;
		
	}
	public void moveDown() {
		dy=-0.5;
	}
	public void moveLeft() {
		dx=-0.5;
	}
	public void moveRight() {
		dx=0.5;
	}
	public Shape getShape(){
		return new Ellipse2D.Double(20,20,50,50);
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.black;
	}

	@Override
	public void updatePosition() {
		x+=dx;
		y+=dy;
		Point2D.Double myPoint= new Point2D.Double(x,y);
		this.setCenterPoint(myPoint);
	}
	public void stopHero(){
		dx=0;
		dy=0;
	}
	@Override
	public void updateSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Point2D getCenterPoint(){
		return centerPoint;
	}


}
