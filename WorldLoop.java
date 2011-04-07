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
	Flower[] flowers1 = new Flower[10];
	Flower[] flowers2 = new Flower[10];
	/*
	float[] origin1 = { (width/2 - width/4), (height/2 + height/4) };
	float[] origin2= { (width/2 - width/4), height/2 };
	float[] origin3= { (width/2 - width/4), (height/2 - height/4) };
	
	float[] referent1 = { width/5, height/5 };
	float[] referent2 = { width/5, height/5 };
	float[] referent3 = { width/5, height/5 };
	*/
	
	// The main setup function...
	// 
	public void setup() {
		size(width,height);
		background(0);
		// Initialize all "stripes"
/*		for (int i = 0; i < stripes.length; i++) {
			stripes[i] = new Stripe(this);
		}*/
		// Initialize all flowers
		for (int i =0; i< flowers1.length; i++) {
			flowers1[i] = new Flower(this, 
					// originx
					(width/2 - width/4), 
					// originy
					(height/20 + (15*i)), 
					// referentx
					width/2,
					// referenty
					height/2
				);
			flowers2[i] = new Flower(this, 
					// originx
					(width/2 + width/4), 
					// originy
					(height/20 + (15*i)), 
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
			for (int i =0; i< flowers1.length; i++) {
				flowers1[i].update();
				flowers2[i].update();
				stroke(204,102,0);
				flowers1[i].display();
				stroke(153);
				flowers2[i].display();
			}
			//line(mouseX,mouseY,pmouseX,pmouseY);
			/*for(int i = 1; i < 60; i = i+ 4) {
				referent1[0] += referent1[0] * 0.5;
				referent1[1] += referent1[1] * 0.5;
				referent2[0] += referent2[0] * 0.5;
				referent2[1] += referent2[1] * 0.5;
				referent3[0] += referent3[0] * 0.5;
				referent3[1] += referent3[1] * 0.5;
				line(origin1[0], origin1[1], referent1[0], referent1[1]);
				line(origin2[0], origin2[1], referent2[0], referent2[1]);
				line(origin3[0], origin3[1], referent3[0], referent3[1]);
			}
			*/
		}
	}
}
