package foootball;

import foootball.core.Engine;
import foootball.core.EngineImpl;

public class Main {
	public static void main(String[] args) {
		Engine engine = new EngineImpl();
		engine.run();
	}
}
