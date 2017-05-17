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
		h.collideWithMultiBomb(this);
		this.setFuseStart(true);
		this.die();
	}
	
	@Override
	public void updateFuse(){
		if(this.getFuseStart()){
		if (getFuse() > 0) {
			this.setFuse(-1);
		} else {
			this.setFuseStart(false);
			this.getWorld().getHero().setMultiBomb(false);
		}
		}	
		
	}

	@Override
	public String getName() {
		return "multibomb";
	}

}
