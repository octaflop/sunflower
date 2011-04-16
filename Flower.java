import processing.core.PApplet;
public class Flower {
	/**
	 * A Flower is an agent which speaks, interprets, and displays
	 */
	private static final long serialVersionUID = 1L;
	int[] pcolor = new int[3];
	int[] ncolor = new int[3];
	int[] dispbox = new int[2];
	int[] pos = new int[2];
	PApplet parent;
	
	Flower(PApplet p) {
		parent = p;
		dispbox[0] = 75;
		dispbox[1] = 75;
		pcolor[0] = 50;
		pcolor[1] = 50;
		pcolor[2] = 50;
	}
	
	void sizeit(int x, int y) {
		dispbox[0] = x;
		dispbox[1] = y;
	}
	
	void positionit(int x, int y) {
		pos[0] = x;
		pos[1] = y;
	}
	
	void colorit(int r, int g, int b) {
		ncolor[0] = r;
		ncolor[1] = g;
		ncolor[2] = b;
	}
	
	void display() {
		parent.fill(ncolor[0], ncolor[1], ncolor[2]);
		parent.rect(pos[0], pos[1], dispbox[0], dispbox[1]);
	}
	
	String speak() {
		return "tets";
	}
	
	void recolorit() {
		// the interpreter class taking the previous colour and shoving it through the GA
		ncolor[0] = (int) (ncolor[0] + parent.random(-30,30));
		ncolor[1] = (int) (ncolor[1] + parent.random(-20,20));
		ncolor[2] = (int) (ncolor[2] + parent.random(-10,10));
	}
}
	

