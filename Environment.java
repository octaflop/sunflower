import processing.core.PApplet;
public class Environment {
	/**
	 * The environment determines the fitness so the statebuilder
	 *  can build a new state
	 */
	PApplet parent;
	Flower speaker;
	Flower hearer;
	float[] error = new float[3];
	int[] initial_col = new int[3]; int[] last_col = new int[3];
	//initial speaker color is red @ 80% redness
	
	Environment () {
		initial_col[0] = 40;
		initial_col[1] = 0;
		initial_col[2] = 120;
		// colour shifts to blue @ 90% blueness
		last_col[0] = 0;
		last_col[1] = 0;
		last_col[2] = 90;
	}
	
	public int[] initial_color () {
		return initial_col;
	}
	
	public float percentage_error(Flower speaker, Flower hearer) {
		/*
		 * Returns the fitness of the S→H
		 * % error = abs((speaker - hearer) / hearer * 100)
		 * The average of all 3 rgb errors
		 */
		PApplet p = parent;
		float temp = 0;
		float[] error = new float[speaker.color.length];
		for(int i = 0; i< speaker.color.length; i++) {
			if (hearer.color[i] == 0) {
				error[i] = hearer.color[i];
			} else {
				error[i] = p.abs((hearer.color[i] - speaker.color[i]) / (hearer.color[i] * 100));
			}
		}
		for(int j = 0; j< error.length; j++) {
			temp += error[j];
		}
		return (float) (temp / error.length);
	}
}