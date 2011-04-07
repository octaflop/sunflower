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
		float ndeltax = -1 *dif[0];
		float ndeltay = -1 *dif[1];
		float pdeltax = dif[0];
		float pdeltay = dif[1];
		if (dif[0] > 0) {
			ndeltax = (float) (ndeltax * -0.8);
			pdeltax = (float) (pdeltax * 0.8);
		} 
		else if (dif[0] < 0) {
			ndeltax = (float) (ndeltax * -1.6);
			pdeltax = (float) (pdeltax * 1.6);
		} else {
			ndeltax = -1;
			pdeltax = 1;
		}
		
		if (dif[0] > 0) {
			ndeltay = (float) (ndeltay * -0.8);
			pdeltay = (float) (pdeltay * 0.8);
		} 
		else if (dif[0] < 0) {
			ndeltay = (float) (ndeltay * -1.6);
			pdeltay = (float) (pdeltay * 1.6);
		} else {
			ndeltay = -1;
			pdeltay = 1;
		}
		
		ret[0] = prefx * parent.random(ndeltax, pdeltax);
		ret[1] = prefy * parent.random(ndeltay, pdeltay);
		return ret;
	}
}
