import java.awt.Color;
import java.awt.geom.Point2D;

public class BombExpand extends PowerUp {
	private Color color;

	public BombExpand(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.color = Color.MAGENTA;
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

}
