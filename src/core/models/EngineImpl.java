package core.models;

import core.interfaces.Engine;
import entities.interfaces.Brick;
import entities.interfaces.Layer;
import entities.models.LayerImpl;
import io.interfaces.Reader;
import io.interfaces.Writer;
import io.models.InputReader;
import io.models.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Reader reader;
    private Writer writer;

    public EngineImpl() {
        this.reader = new InputReader();
        this.writer = new OutputWriter();
    }

    @Override
    public void run() {
        try {
            int[] dimensions = Arrays.stream(this.reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int rows = dimensions[0];
            int cols = dimensions[1];
            Layer layer = new LayerImpl(rows,cols);
            for (int i = 0; i < rows; i++) {
                layer.fillLayer(i, Arrays.stream(this.reader.readLine()
                        .split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            layer.addBricks();
            this.writer.writeLine(layer.toString());
            for (Brick brick:layer.getBricks()){
                this.writer.writeLine(brick.getMarkedValue()+" "+ brick.getMarkedValue() );
            }
        }catch (IOException | IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
