import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class PowerUp extends GameObject {
	private double x;
	private double y;
	private int fuse;
	private boolean fuseStart;

	public PowerUp(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.x = centerPoint.getX();
		this.y = centerPoint.getY();
		this.fuse = 2000;
		this.fuseStart = false;
		this.setSize(40);
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(this.x, this.y, getSize(), getSize());
	}

	public int getFuse() {
		return this.fuse;
	}

	public void setFuse(int addFuse) {
		this.fuse += addFuse;
	}

	public void setFuseStart(boolean fuseStart) {
		this.fuseStart = fuseStart;
	}

	public boolean getFuseStart() {
		return this.fuseStart;
	}

}
