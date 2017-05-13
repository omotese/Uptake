import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class PowerUp extends GameObject {
	private Bomb myBomb;
	private GameWorld world;
	private double x;
	private double y;
	
	public PowerUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		// TODO Auto-generated constructor stub.
		this.world= world;
		this.x= centerPoint.getX();
		this.y = centerPoint.getY();
	}
	
//	public Shape bombExpand(){
//		Point2D bombLocation= myBomb.getCenterPoint();
//		return new Rectangle2D.Double(bombLocation.getX(), bombLocation.getY(), 70, 70);
//	}
	
	public void speedHero(){
		this.world.getHero().moveUpFaster();
		this.world.getHero().moveDownFaster();
		this.world.getHero().moveUpFaster();
		this.world.getHero().moveUpFaster();
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.ORANGE;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub.
		return new Rectangle2D.Double(x,y, 40, 40);
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithHero(Hero h) {
		// TODO Auto-generated method stub.
		Random rand= new Random();
		speedHero();
		this.die();
//		if(rand.nextInt(2)==1){
//			bombExpand();
//			this.die();
//		}
//		else{
//			speedHero();
//			this.die();
//		}
	}

	@Override
	public void collideWithMonster(Monster m) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithSeeker(Seeker s) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithWall(Wall w) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithBomb(Bomb b) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithExplosion(Explosion e) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
		// TODO Auto-generated method stub.
	
	}

	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateSize() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void updateColor() {
		// TODO Auto-generated method stub.

	}

	@Override
	public double getDiameter() {
		// TODO Auto-generated method stub.
		return 0;
	}

	@Override
	public void collideWithPowerUp(PowerUp p) {
		// TODO Auto-generated method stub.
		
	}

}
