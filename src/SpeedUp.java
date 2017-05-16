import java.awt.Color;
import java.awt.geom.Point2D;

public class SpeedUp extends PowerUp {
	
	public SpeedUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
	}
	
	public void speedHero(){
		this.getWorld().getHero().setIsFaster(true);
	}


	@Override
	public void collideWithHero(Hero h) {
		speedHero();
		this.fuseStart = true;
		this.size = 0;
	}
	
	@Override
	public void updateFuse(){
		//System.out.println("update fuse");
		if(fuse > 0){
			this.fuse--;
			System.out.println(fuse);
		}else{
			this.fuseStart = false;
			this.getWorld().getHero().setIsFaster(false);
		}
	}

}
