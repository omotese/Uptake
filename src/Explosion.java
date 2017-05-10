import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.sun.javafx.geom.Shape;

public class Explosion extends Bomb {
	private int size;
	private double x;
	private double y;

	public Explosion(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.size = 0;
		this.x=this.getCenterPoint().getX();
		this.y=this.getCenterPoint().getY();
	}
	
	@Override
	public void collideWithHero(Hero h ) {
		h.collideWithBomb(this);
	}
	
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, size, size);
	}
	
	public void setSize(int s){
		this.size = s;
	}

}
