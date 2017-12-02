/**
 * An interface representing a pattern that an enemy moves in.
 * @author rjnagel
 */
public interface MovementPattern {
	/*
	 * Ideas for movement patterns:
	 *  - Classic left-to-right
	 *  - Horizontal parabola (opening left/right)
	 *  - Diagonal
	 *  - etc.
	 */
	/**
	 * (I think that actually, we will want to return a 2D velocity vector, so
	 * that the enemies do not move too fast. The returned velocity vector would
	 * be multiplied by the time elapsed since last frame, giving the change in
	 * position.)
	 * (Relatedly, it may be necessary to pass the amount of time elapsed into
	 * this method, so that it can calculate the velocity to return.)
	 * 
	 * So really, this should look more like "Velocity update(float elapsed);",
	 * where Velocity is just something with x- and y-components.
	 */
	void update();
}
