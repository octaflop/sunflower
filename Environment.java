import processing.core.PApplet;
public class Environment {
	PApplet parent;
	Flower speaker;
	Flower hearer;
	float[] error;
	
	/**
	 * The environment determines the fitness so the statebuilder
	 *  can build a new state
	 */
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
