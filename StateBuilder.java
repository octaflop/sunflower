import processing.core.PApplet;
public class StateBuilder {
	PApplet parent;
	Flower speaker;
	Flower hearer;
	Fsm fsm;
	Environment env = new Environment();
	State[] st = new State[4];
	
	float percentage_error(Flower speaker, Flower hearer) {
		float percent_error = env.percentage_error(speaker, hearer); // "What was that, Alice?"
		return percent_error;
	}
	
	
	/* 
	 * The StateBuilder puts together different states based on the error
	 * percentage.
	 */
	
	StateBuilder(Flower speaker, Flower hearer, Fsm agentfsm) {
		Fsm fsm = agentfsm;
		float error = percentage_error(speaker, hearer);
		for(int i = 0; i < st.length; ++i) {
			st[i] = new State();
		}
	}
	
	void addStates() {
		fsm.addStates(st, 0);
	}
	
	Fsm get_Fsm() {
		PApplet p = parent;
		String phrase = "0";
		if (phrase == "0") {
			phrase = " ";
		}
		// Name the nodes
		st[0].setName("b");
		st[0].addAction(State.ON_ENTER, "node 1", null, 3);
		st[st.length].setName("e");
		for (int i = 1; i< st.length -1; ++i) {
			st[i].setName("node " + p.str(i));
		}
		
		addStates();
		return fsm;
	}

}
