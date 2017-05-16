import java.awt.Color;
import java.awt.geom.Point2D;

public class MultiBomb extends PowerUp {
	private Color color;

	public MultiBomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		setColor(Color.black);
		
	}
	
	public void multiBomb(){
		this.getWorld().getHero().setMultiBomb(true);
	}
	

	

	@Override
	public void collideWithHero(Hero h) {
		multiBomb();
		this.fuseStart = true;
		this.size=0;
	}
	
	@Override
	public void updateFuse(){
		if(fuse > 0){
			this.fuse--;
		}else{
			this.fuseStart = false;
			this.getWorld().getHero().setMultiBomb(false);
		}
	}

}
