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
	private static Flower agent = null;
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

	public Fsm(Flower flower) {
		agent = flower;
	}
	
	public static void doAction(int fun, Fsm fsm) {
		int[] pcolor = agent.color;
		switch(fun){
		/*
		* TODO: 
		* * Make this dynamic from a GA
		* * Make 20 cases to select from in a FSM,
		* * append a function to each case which adjusts the colour
		* 
		*/
		
		case 1:
			fsm.response = "Powering up...";
			break;
		case 2:
			fsm.response = "Flower has shut down";
			agent.colorit(pcolor[0], pcolor[1], pcolor[2]);
			break;
		case 3:
			fsm.response = "Flower is now speaking";
			agent.colorit(pcolor[0], pcolor[1], pcolor[2]);
			break;
		case 4:
			fsm.response = "Activity/doubling";
			agent.colorit(pcolor[0] * 2, pcolor[1] * 2, pcolor[2] * 2);
			break;
		case 5:
			fsm.response = "Activity/Run";
			agent.colorit(pcolor[0], pcolor[1], pcolor[2]);
			break;
		case 6:
			fsm.response = "Activity/Talking";
			break;
		case 7:
			fsm.response = "Activity/Talking";
			break;
		case 8:
			fsm.response = "Activity/Talking";
			break;
		case 9:
			fsm.response = "Activity/Talking";
			break;
		case 10:
			fsm.response = "Activity/Talking";
			break;
		case 11:
			fsm.response = "Activity/Talking";
			break;
		case 12:
			fsm.response = "Activity/Talking";
			break;
		case 13:
			fsm.response = "Activity/Talking";
			break;
		case 14:
			fsm.response = "Activity/Talking";
			break;
		case 15:
			fsm.response = "Activity/Talking";
			break;
		case 16:
			fsm.response = "Activity/Talking";
			break;
		case 17:
			fsm.response = "Activity/Talking";
			break;
		case 18:
			fsm.response = "Activity/Talking";
			break;
		case 19:
			fsm.response = "Activity/Talking";
			break;
		case 20:
			fsm.response = "Activity/Talking";
			break;
		}
	}

}
