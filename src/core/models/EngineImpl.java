package core.models;

import core.interfaces.Controller;
import core.interfaces.Engine;
import io.interfaces.Reader;
import io.interfaces.Writer;
import io.models.InputReader;
import io.models.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private final Reader reader;
    private final Writer writer;
    private final Controller controller;

    public EngineImpl() {
        this.reader = new InputReader();
        this.writer = new OutputWriter();
        this.controller = new ControllerImpl();
    }

    @Override
    public void run() {
        String result;
        while (true) {
            try {
                int[] dimensions = Arrays.stream(this.reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                int rows = dimensions[0];
                int cols = dimensions[1];
                controller.createLayer(rows, cols);
                controller.fillLayer(this.reader);
                controller.addBricks();
                controller.createNextLayer();
                result = controller.result();
                if (result != null) {
                    break;
                }
            } catch (IOException | IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        this.writer.writeLine(result);
    }
}
