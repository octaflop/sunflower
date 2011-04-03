import processing.core.PApplet;
public class Flower {
	/**
	 * A Flower is a line-making agent
	 */
	private static final long serialVersionUID = 1L;
	float[] origin = new float[2];
	float[] referent = new float[2];
	PApplet parent;
	
	Flower(PApplet p, float originx, float originy, float referentx,float referenty) {
		parent = p;
		origin[0] = originx;
		origin[1] = originy;
		referent[0] = referentx;
		referent[1] = referenty;
	}
	
	void display() {
		parent.line(origin[0], origin[1], referent[0], referent[1]);
	}
	
	void update() {
		// called just before display finishes
		// TODO replace with something smarter
		for (int i = 0; i < 5; i++) {
			referent[0] = referent[0] + parent.random(-5,5);
			referent[1] = referent[1] + parent.random(-5,5);
		}
	}
}
