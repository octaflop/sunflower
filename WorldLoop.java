import processing.core.*;

public class WorldLoop extends PApplet {
	/**
	 * WorldLoop is the main class which runs the app.
	 */
	private static final long serialVersionUID = 1L;
	int width = 600;
	int height = 600;
	// first row of flowers
	// TODO: Test these
	Flower[] flowers1 = new Flower[2];
	Flower[] flowers2 = new Flower[2];
	//Referent referent = new Referent; //(this, width/2, height/2);
	Referent referent;

	// The main setup function...
	public void setup() {
		size(width,height);
		background(0);
		// initialize "sun"
		Referent referent1 = new Referent(this, width/2, height/2);
		Referent referent2 = new Referent(this, width/2, height/2);
		// Initialize all flowers
		for (int i =0; i< flowers1.length; i++) {
			flowers1[i] = new Flower(this, 
					// originx
					(width/2 - width/4), 
					// originy
					(height/20 + (25*i)), 
					// referentx
					width/2,
					// referenty
					height/2
				);
			flowers2[i] = new Flower(this, 
					// originx
					(width/2 + width/4), 
					// originy
					(height/20 + (25*i)), 
					// referentx
					width/2, 
					// referenty
					height/2
				);
		}
	}

	public void draw() {
		stroke(255);
		if (mousePressed) {
			fill(100,90,80);
			referent.update();
			referent.display();
			for (int i =0; i< flowers1.length; i++) {
				flowers1[i].update();
				flowers2[i].update();
				stroke(204,102,0);
				flowers1[i].display();
				stroke(153);
				flowers2[i].display();
			}
 		}
	}
}
