import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class PowerUp extends GameObject{
	protected double x;
	protected double y;
	protected int fuse;
	protected boolean fuseStart;
	protected int size;
	
	
	public PowerUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.x= centerPoint.getX();
		this.y = centerPoint.getY();
		this.fuse = 2000;
		this.fuseStart = false;
		this.size = 40;
	}
	
	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(this.x,this.y, size, size);
	}

	@Override
	public void updatePosition() {
		if(fuseStart){
			this.updateFuse();
		}
		
	}
}
