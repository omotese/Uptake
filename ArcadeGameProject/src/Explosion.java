import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Explosion extends Bomb {
	private int size;
	private double x;
	private double y;
	private Color explosionColor;
	private int fuse;

	public Explosion(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.size = 150;
		this.x=this.getCenterPoint().getX();
		this.y=this.getCenterPoint().getY();
		this.explosionColor = Color.pink;
		this.fuse = 30;
	}
	
	
	public void updateFuse(){
		this.fuse--;
		if(fuse<=0){
			this.die();
		}
	}
	
	@Override
	public void updatePosition(){
		updateFuse();
	}
	
	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(x, y, size, size);
	}
	
	public void setSize(int s){
		this.size = s;
	}
	
	@Override
	public Color getColor(){
		return this.explosionColor;
	}
	
	
	@Override
	public void collideWithHero(Hero h ) {
		h.collideWithExplosion(this);
	}
	
	@Override
	public void collideWithMonster(Monster m) {
		m.collideWithExplosion(this);
	}
	
	@Override
	public void collideWithBreakable(BreakableWall b) {
		b.collideWithExplosion(this);
	}
	
	
	

}
