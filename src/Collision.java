
public interface Collision {
	abstract void collide(GameObject o);

	abstract void collideWithHero(Hero h);
	
	abstract void collideWithMonster(Wanderer m);
	
	abstract void collideWithWall(Wall w);
	
	abstract void collideWithBomb(Bomb b);
	
	abstract void collideWithExplosion(Explosion e);
	
	abstract void collideWithBreakable(BreakableWall b);
}
