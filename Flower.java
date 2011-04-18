import processing.core.PApplet;
public class Flower {
	/**
	 * A Flower is an agent which speaks, interprets, and displays
	 */
	private static final long serialVersionUID = 1L;
	//int[] pcolor = new int[3];
	int[] color = new int[3];
	int[] dispbox = new int[2];
	int[] pos = new int[2];
	String utterance = null;
	PApplet parent;
	Fsm grammar;
	
	Flower(PApplet p) {
		parent = p;
		dispbox[0] = 75;
		dispbox[1] = 75;
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
		color[0] = r;
		color[1] = g;
		color[2] = b;
	}
	
	void display() {
		parent.fill(color[0], color[1], color[2]);
		parent.stroke(color[0], color[1], color[2]);
		parent.rect(pos[0], pos[1], dispbox[0], dispbox[1]);
	}
	
	String speak() {
		/**
		 * Speaking produces a string of the grammar.
		 */
		if (utterance == null) {
			// initiate grammar with random rules
			utterance = "AB";
			Fsm grammar = new Fsm(this); // Flower adds itself to the grammar
			utterance = grammar.response;
		} 
		//grammar.inEvent(utterance);
		return utterance;
	}
	
	void recolorit() {
		// the interpreter class taking the previous colour and shoving it through the GA
		color[0] = (int) (color[0] + parent.random(-30,30));
		color[1] = (int) (color[1] + parent.random(-20,20));
		color[2] = (int) (color[2] + parent.random(-10,10));
	}
	
	public int[] colour() {
		return color;
	}
	
}
	

