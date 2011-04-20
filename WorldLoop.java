import processing.core.*;

public class WorldLoop extends PApplet {
	/**
	 * WorldLoop is the main class which runs the app.
	 */
	private static final long serialVersionUID = 1L;
	int width = 600;
	int height = 600;
	//Referent referent = new Referent; //(this, width/2, height/2);
	Environment env = new Environment();
	int[] posa = new int[2];
	int[] posb = new int[2];
	int[] speakercol = new int[3];
	int[] hearercol = new int[3];
	Flower speaker = new Flower(this);
	Flower hearer = new Flower(this);
	
	// The main setup function...
	public void setup() {
		size(width,height);
		background(0);
		posa[0] = width/2; // posa x
		posa[1] = height/4; // posa y
		posb[0] = width/2; // posa x
		posb[1] = height/4 + height/2; // posa y
		speaker.colorit(50, 50, 50);
		speaker.positionit(posa[0], posa[1]);
		hearer.colorit(75, 75, 75);
		hearer.positionit(posb[0], posb[1]);
		// initialize "sun"
		// Initialize all flowers
	}

	public void draw() {
		stroke(255);
		if (mousePressed) {
			speaker.display();
			hearer.display();
			speaker.colorit(env.initial_color()[0], env.initial_color()[1], env.initial_color()[2]);
			//speaker.recolorit();
			hearer.recolorit();
			//clear previous text
			fill(0,0,0);
			stroke(0,0,0);
			rect(0,0,375,150);
			fill(255,255,255);
			String speaks = "Speaker: " + speaker.speak() + " " + speaker.colour()[0] + ", " + speaker.colour()[1] + ", " + speaker.colour()[2];
			String hears = "Listener: " + hearer.speak() + " " + hearer.colour()[0] + ", " + hearer.colour()[1] + ", " + hearer.colour()[2];
			Environment env = new Environment();
			String error = "Error Rate: " + str(env.percentage_error(speaker, hearer));
			// write new values
			text(speaks, 15, 25);
			text(hears, 15, 45);
			text(error, 15, 65);
		}
	}
}
