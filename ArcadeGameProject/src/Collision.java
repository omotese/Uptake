
public interface Collision {
	abstract void collide(GameObject m);
	abstract void collideWithHero(Hero m);
	abstract void collideWithMonster(Monster m);
}
