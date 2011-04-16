import processing.core.PApplet;
import java.util.Vector;
public class State {
	public static int ON_ENTER = 0;
	public static int ON_DO = 1;
	public static int ON_EXIT = 2;
	public static int ON_EVENT = 3;

	public String name = "";
	public int numTransitions = 0;
	public int numEvents = 0;
	public int maxEvents = 6;

	public Vector specifications;
	public Vector transitions;
	/** Creates a new instance of State */
	public State() {
		specifications = new Vector();
		transitions = new Vector();
		for(int i = 0;i < 10;++i){
			specifications.addElement(new Specification());
		}
	}

	public void setName(String n){
		this.name = n;
	}

	public void addTransition (String e, State s){
		if (numTransitions < maxEvents) {
			transitions.add(new Transition(e,s));
			numTransitions++;
		}
	}

	public void addAction(int w, String n, String e, int f){
		if (w < ON_EVENT){
			((Specification)specifications.elementAt(w)).name = n;
			((Specification)specifications.elementAt(w)).fun = f;
		} else {
			if (numEvents < maxEvents){
				((Specification)specifications.elementAt(w + numEvents)).name = n;
				((Specification)specifications.elementAt(w + numEvents)).event = e;
				((Specification)specifications.elementAt(w + numEvents)).fun = f;
				numEvents++;
			}
		}
	}

	public boolean incoming(String e, Fsm f){
		if (numEvents > 0){
			for(int i = 0;i < numEvents;++i){
				Specification spec = (Specification)specifications.elementAt(ON_EVENT + i);
				if (spec.event == e) {
					f.doAction(spec.fun, f);
					return true;
				}
			}
		} else {
			for(int i = 0;i < ON_DO;++i){
				Specification spec = (Specification)specifications.elementAt(i);
				if (spec.fun != 0){
					f.doAction(spec.fun, f);
				}
			}
		}
		return false;
	}

	public State outgoing(String e, Fsm f){
		Specification spec = (Specification)specifications.elementAt(ON_EXIT);
		for(int i = 0;i < numTransitions;++i){
			Transition tran = (Transition)transitions.elementAt(i);
			if (tran.event == e) {
				if (spec.fun != 0){
					f.doAction(spec.fun, f);
				}
				return tran.state;
			}
		}
		return null;
	}

	class Transition {
		String event = null;
		State state = null;

		public Transition(String e, State s){
			event = e;
			state = s;
		}
	}

	class Specification {
		String name = null;
		String event = null;
		int fun = 0;
	}

}
