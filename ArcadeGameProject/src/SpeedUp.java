import java.awt.Color;
import java.awt.geom.Point2D;

public class SpeedUp extends PowerUp {
	
	public SpeedUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.orange);
	}


	@Override
	public void collideWithHero(Hero h) {
		//System.out.println("speedup collide w/ hero");
		h.collideWithSpeedUp(this);
		this.setFuseStart(true);
		this.die();
	}
	
	@Override
	public void updateFuse(){
		if(getFuse() > 0){
			this.setFuse(-1);;
		}else{
			this.setFuseStart(false);
			//System.out.println("fuuuuuse");
			this.getWorld().getHero().setIsFaster(false);
		}
	}


	@Override
	public String getName() {
		return "speedUp";
	}
	

}
