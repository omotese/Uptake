import java.awt.Color;
import java.awt.geom.Point2D;

public class BombExpand extends PowerUp {

	public BombExpand(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
	}
	
	
	public void allowBig(){
		this.getWorld().getHero().setHasExpandBombPowerUp(true);
	}


	@Override
	public void collideWithHero(Hero h) {
		// TODO Auto-generated method stub.
		//Random rand= new Random();
		allowBig();
		this.fuseStart = true;
		this.size = 0;
	}
	
	public void expandBomb() {
		for(Bomb b: this.getWorld().getBombList()){

			System.out.println("bomb expand");
		}
		
	}
	
	@Override
	public void updateFuse(){
		//System.out.println("update fuse");
		if(fuse > 0){
			this.fuse--;
			System.out.println(fuse);
		}else{
			this.fuseStart = false;
			this.getWorld().getHero().setHasExpandBombPowerUp(false);
		}
	}

	@Override
	public Color getColor() {
		return Color.magenta;
	}

	@Override
	public void collide(GameObject o) {
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


	@Override
	public void collideWithPowerUp(PowerUp p) {
		// TODO Auto-generated method stub.
		
	}

}
