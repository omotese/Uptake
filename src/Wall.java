import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Wall extends GameObject {
	private Color wallColor;
	private double x;
	private double y;
	private GameWorld world;
	private Point2D centerPoint;
	private int wallSize;
	
	public Wall(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.wallColor = Color.gray;
		this.x= this.getCenterPoint().getX();
		this.y= this.getCenterPoint().getY();
		this.wallSize=50;
	}
	
	public Shape getShape(){
		Rectangle2D.Double myRect= new Rectangle2D.Double(x,y,wallSize,wallSize);
		return myRect ;
	}
	
	public boolean isWithin(double xCheck, double yCheck){
		if(this.x<=xCheck && xCheck<=this.x+50 && this.y<=yCheck && yCheck <=this.y+50) {
			return true;
		}
		return false;
	}
	
	@Override
	public Color getColor() {
		return wallColor;
	}
	@Override
	public void updatePosition() {
		
	}
	@Override
	public void updateSize() {
		
	}
	@Override
	public void updateColor() {
		
	}
	@Override
	public double getDiameter() {
		return wallSize;
	}
	
	
	
	//Collisions
	@Override
	public void collide(GameObject m) {
		m.collideWithWall(this);
	}
	
	@Override
	public void collideWithHero(Hero h) {
		h.collideWithWall(this);
	}
	
//	@Override
//	public void collideWith(Wanderer m) {
//		m.collideWithWall(this);
//	}

	@Override
	public void collideWithWall(Wall w) {
	}

	@Override
	public void collideWithBomb(Bomb b) {
	}

	@Override
	public void collideWithExplosion(Explosion e) {
	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
	}

	@Override
	public void collideWithMonster(Monster m) {
		// TODO Auto-generated method stub.
		m.collideWithWall(this);
	}

	@Override
	public void collideWithSeeker(Seeker s) {
		// TODO Auto-generated method stub.
		s.collideWithWall(this);
	}

	@Override
	public void collideWithPowerUp(SpeedUp p) {
		// TODO Auto-generated method stub.
		
	}
	


}
