	import java.awt.geom.Point2D;
public abstract class Block extends GameObject {

//		private double dx;
//		private double dy;
		private Point2D centerPoint;
		private GameWorld world;
		private boolean isPaused = false;
		public Block(GameWorld world) {
			super(world);
		}
		public Block(GameWorld world, Point2D centerPoint) {
			super(world, centerPoint);
		}
			
		





}
