import java.awt.Color;
import java.awt.geom.Point2D;

public class MultiBomb extends PowerUp {

	public MultiBomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		
	}
	
	public void multiBomb(){
		this.getWorld().getHero().setMultiBomb(true);
	}
	

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub.
		return Color.black;
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub.

	}

	@Override
	public void collideWithHero(Hero h) {
		// TODO Auto-generated method stub.
		multiBomb();
		this.fuseStart = true;
		this.size=0;
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
