import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class SpeedUp extends PowerUp {
	
	
	
	public SpeedUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		
	}
	
//	public Shape bombExpand(){
//		Point2D bombLocation= myBomb.getCenterPoint();
//		return new Rectangle2D.Double(bombLocation.getX(), bombLocation.getY(), 70, 70);
//	}
	
	public void speedHero(){
		//System.out.println("set is faster before " + this.world.getHero().getIsFaster());
		this.world.getHero().setIsFaster(true);
		//System.out.println("set is faster after " + this.world.getHero().getIsFaster());
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.ORANGE;
	}

	@Override
	public void collideWithHero(Hero h) {
		// TODO Auto-generated method stub.
		//Random rand= new Random();
		speedHero();
		this.fuseStart = true;
		this.size = 0;
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithPowerUp(SpeedUp p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithMonster(Monster m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithSeeker(Seeker s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithWall(Wall w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithBomb(Bomb b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithExplosion(Explosion e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideWithBreakable(BreakableWall b) {
		// TODO Auto-generated method stub
		
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

}
