import processing.core.PApplet;
public class Flower {
	/**
	 * A Flower is a line-making agent
	 */
	private static final long serialVersionUID = 1L;
	float[] origin = new float[2];
	float[] referent = new float[2];
	PApplet parent;
	
	Flower(PApplet p, float originx, float originy, float referentx, float referenty) {
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
		// april 5: replaced with annealing
		float crt = 1;
		for (int i = 0; i < 5; i++) {
			//referent[0] = referent[0] + parent.random(-5,5);
			//referent[1] = referent[1] + parent.random(-5,5);
			float[] fixedref = new float[2];
			fixedref[0] = parent.width/2;
			fixedref[1] = parent.height/2;
			referent = anneal(referent[0], referent[1], fixedref[0], fixedref[1]);
		}
	}
	float[] anneal(float prefx, float prefy, float refx, float refy) {
		float[] ret = new float[2];
		float[] dif = new float[2];
		dif[0] = parent.abs(prefx - refx);
		dif[1] = parent.abs(prefx - refy);
		float deltax = dif[0];
		float deltay = dif[1];
		if (dif[0] > 0) {
			deltax = (float) (deltax * 0.8);
		} 
		else if (dif[0] < 0) {
			deltax = (float) (deltax * 1.6);
		} else {
			deltax = 1;
		}
		
		if (dif[1] > 0) {
			deltay = (float) (deltay * 0.8);
		} 
		else if (dif[1] < 0) {
			deltay = (float) (deltay * 1.6);
		} else {
			deltay = 1;
		}
		
		ret[0] = prefx + parent.random(deltax, -deltax);
		ret[1] = prefy + parent.random(deltay, -deltay);
		return ret;
	}
}
