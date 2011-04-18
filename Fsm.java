import processing.core.PApplet;
public class Fsm {
	/**
	 * The finite state machine takes the states of the incoming stings and 
	 * outputs a 3-part colour value int[]. 
	 */
	public String event = null;
	public String response = "Idle";
	public State currState = null;
	public State state = null;
	public State[] states;
	public void addStates(State[] st, int initSt){
		states = st;
		currState = states[initSt];
	}
	public boolean inEvent(String e){
		if (currState != null) {
			return currState.incoming(e, this);
		}
		return false;
	}

	public boolean outEvent(String e){
		if ((states != null) && (currState != null)){
			event = e;
			State temp = currState.outgoing(e, this);
			if (temp != null){
				currState = temp;
				currState.incoming(e, this);
				return true;
			}
		}
		event = "Unknown event";
		return false;
	}

	public static void doAction(int fun, Fsm fsm){
		switch(fun){
		// TODO: Make this dynamic from a GA
		case 1:
			fsm.response = "Powering up...";
			break;
		case 2:
			fsm.response = "Flower has shut down";
			break;
		case 3:
			fsm.response = "Flower is now speaking";
			break;
		case 4:
			fsm.response = "performing";
			break;
		case 5:
			fsm.response = "Activity/Run";
			break;
		case 6:
			fsm.response = "Activity/Talking";
			break;
		}
	}

	public Fsm() {

	}
}
