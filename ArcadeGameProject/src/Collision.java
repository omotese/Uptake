
/**
 * TODO Put here a description of what this class does.
 *
 * @author trenthe.
 *         Created May 18, 2017.
 */
public interface Collision {
	abstract void collide(GameObject o);

	abstract void collideWithHero(Hero h);

	abstract void collideWithMonster(Monster m);

	abstract void collideWithSeeker(Seeker s);

	abstract void collideWithWall(Wall w);

	abstract void collideWithBomb(Bomb b);

	abstract void collideWithExplosion(Explosion e);

	abstract void collideWithSpeedUp(SpeedUp s);

	abstract void collideWithMultiBomb(MultiBomb m);

	abstract void collideWithBombExpand(BombExpand b);

	abstract void collideWithDetonator(Detonator d);

	abstract void collideWithLifeUp(LifeUp l);
}
