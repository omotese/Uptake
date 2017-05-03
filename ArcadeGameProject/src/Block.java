	import java.awt.geom.Point2D;
public abstract class Block extends GameObject implements Drawable, Temporal {

//		private double dx;
//		private double dy;
		private Point2D centerPoint;
		private GameWorld world;
		private boolean isPaused = false;
		public Block(GameWorld world) {
			super(world);
		}
		public Block(GameWorld world, Point2D centerPoint) {
			// TODO Auto-generated constructor stub.
			this.centerPoint= centerPoint;
			this.world= world;
		}
		protected void setCenterPoint(Point2D centerPoint) {
			this.centerPoint = centerPoint;
		}

		@Override
		public void timePassed() {
			updateColor();
			updateSize();
			
		}

		@Override
		public void die() {
			world.removeBlock(Block.this);
		}

		@Override
		public boolean getIsPaused() {
			// not yet implemented
			return false;
		}

		@Override
		public void setIsPaused(boolean isPaused) {
			this.isPaused= isPaused;
		}
		// Drawable interface (partial implementation, subclasses must help)

//		@Override
//		public Shape getShape() {
//			double x = getCenterPoint().getX();
//			double y = getCenterPoint().getY();
//			double size = getDiameter();
//			return new Ellipse2D.Double(x - size / 2, y - size / 2, size, size);
//		}

		// -------------------------------------------------------------------------
		// Relocatable interface

		/**
		 * Re-centers this ball at the given point.
		 * 
		 * @param point
		 */
		@Override
		public void moveTo(Point2D point) {
			double x= point.getX();
			double y= point.getY();
			this.centerPoint = new Point2D.Double(x,y);

		}
		@Override
		public Point2D getCenterPoint() {
			return this.centerPoint;
		}

		/**
		 * Updates the position of this object, if necessary, due to the passing of
		 * a "moment" in time.
		 */
		public abstract void updatePosition(double x, double y);

		/**
		 * Updates the size of this object, if necessary, due to the passing of a
		 * "moment" in time.
		 */
		public abstract void updateSize();

		/**
		 * Updates the color of this object, if necessary, due to the passing of a
		 * "moment" in time.
		 */
		public abstract void updateColor();

		/**
		 * Returns the diameter of this ball.
		 * 
		 * @return the diameter
		 */
		public abstract double getDiameter();

	}





}
