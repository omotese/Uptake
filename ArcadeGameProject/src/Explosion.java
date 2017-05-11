import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Explosion extends Bomb {
	private int size;
	private double x;
	private double y;
	private Color explosionColor;

	public Explosion(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.size = 0;
		this.x=this.getCenterPoint().getX();
		this.y=this.getCenterPoint().getY();
		this.explosionColor = Color.pink;
	}
	
	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, size, size);
	}
	
	public void setSize(int s){
		this.size = s;
	}
	
	
	@Override
	public void collideWithHero(Hero h ) {
		h.collideWithBomb(this);
	}
	
	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithBomb(this);
	}
	

}
