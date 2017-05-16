import java.awt.Color;
import java.awt.geom.Point2D;

public class MultiBomb extends PowerUp {
	private Color color;

	public MultiBomb(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.color = Color.BLACK;
		
	}
	
	public void multiBomb(){
		this.getWorld().getHero().setMultiBomb(true);
	}
	

	

	@Override
	public void collideWithHero(Hero h) {
		// TODO Auto-generated method stub.
		multiBomb();
		this.fuseStart = true;
		this.size=0;
	}
	
	@Override
	public void updateFuse(){
		//System.out.println("update fuse");
		if(fuse > 0){
			this.fuse--;
			System.out.println(fuse);
		}else{
			this.fuseStart = false;
			this.getWorld().getHero().setMultiBomb(false);
		}
	}

}
