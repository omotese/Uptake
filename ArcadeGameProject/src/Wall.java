import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Wall extends GameObject {
	private String name;
	private double x;
	private double y;
	private int size;
	
	public Wall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.name = "wall";
		this.x= this.getCenterPoint().getX();
		this.y= this.getCenterPoint().getY();
		setColor(Color.gray);
		this.size=50;
	}
	

	//Drawable--------------------------------------
	@Override
	public Shape getShape(){
		Rectangle2D.Double myRect= new Rectangle2D.Double(x,y,this.size, this.size);
		return myRect ;
	}
	
	//Temporal--------------------------------------
	
	//Relocatable------------------------------------
	
	//Collision--------------------------------------
	@Override
	public void collideWithHero(Hero h) {
		h.collideWithWall(this);
	}
	
	@Override
	public void collideWithMonster(Monster m) {
		// TODO Auto-generated method stub.
		m.collideWithWall(this);
	}
	


}
