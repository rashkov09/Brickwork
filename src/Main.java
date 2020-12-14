import core.interfaces.Engine;
import core.models.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }

}
