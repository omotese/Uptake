
public interface Collision {
	abstract void collide(GameObject o);

	abstract void collideWithHero(Hero h);
	
	abstract void collideWithMonster(Monster m);
	
	abstract void collideWithWall(Wall w);
	
	abstract void collideWithBomb(Explosion e);
	
	abstract void collideWithBreakable(BreakableBlock b);
}
