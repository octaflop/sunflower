import processing.core.*;

public class WorldLoop extends PApplet {
	/**
	 * WorldLoop is the main class which runs the app.
	 */
	private static final long serialVersionUID = 1L;
	int width = 600;
	int height = 600;
	//Referent referent = new Referent; //(this, width/2, height/2);
	Referent referent1 = new Referent(this, width/2, height/2);
	Referent referent2 = new Referent(this, width/2, height/2);
	int[] posa = new int[2];
	int[] posb = new int[2];
	int[] colora = new int[3];
	int[] colorb = new int[3];
	Flower flowera = new Flower(this);
	Flower flowerb = new Flower(this);
	
	// The main setup function...
	public void setup() {
		size(width,height);
		background(0);
		posa[0] = width/2; // posa x
		posa[1] = height/4; // posa y
		posb[0] = width/2; // posa x
		posb[1] = height/4 + height/2; // posa y
		flowera.colorit(50, 50, 50);
		flowera.positionit(posa[0], posa[1]);
		flowerb.colorit(75, 75, 75);
		flowerb.positionit(posb[0], posb[1]);
		// initialize "sun"
		// Initialize all flowers
	}

	public void draw() {
		stroke(255);
		if (mousePressed) {
			flowera.display();
			flowerb.display();
			flowera.recolorit();
			flowerb.recolorit();
		}
	}
}
