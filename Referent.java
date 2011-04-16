import processing.core.PApplet;
public class Referent {
	/**
	 * A Referent is a dot for the flowers to follow; it's like the "sun"
	 * Referents are replicated for each flower bed
	 */
	private static final long serialVersionUID = 1L;
	float[] position = new float[2];
	float[] size = new float[2];
	PApplet parent;
	Referent(PApplet p, float positionx, float positiony) {
		parent = p;
		size[0] = 40;
		size[1] = 40;
		position[0] = positionx;
		position[1] = positiony;
	}
	
	void display() {
		parent.ellipse(position[0], position[1], size[0], size[1]);
	}
	
	void update() {
		position[0] += parent.random(-10,10);
		position[1] += parent.random(-12,12);
	}

}
