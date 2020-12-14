package core.models;

import core.interfaces.Controller;
import entities.interfaces.Layer;
import entities.models.LayerImpl;
import io.interfaces.Reader;

import java.io.IOException;
import java.util.Arrays;

public class ControllerImpl implements Controller {
    private Layer layer;

    public ControllerImpl() {
    }

    @Override
    public void createLayer(int rows, int cols) {
        this.layer = new LayerImpl(rows, cols);
    }

    @Override
    public void fillLayer(Reader reader) throws IOException {
        for (int i = 0; i < this.layer.getLayerData().length; i++) {
            int[] input = Arrays.stream(reader.readLine()
                    .split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input.length != this.layer.getLayerData()[0].length) {
                throw new IllegalArgumentException("Invalid row input!");
            }
            this.layer.fillLayer(i, input);
        }

    }

    @Override
    public void addBricks() {
        this.layer.addBricks();
    }

    @Override
    public String result() {
        return this.layer.toString();
    }

    @Override
    public void createNextLayer() {
        // TODO;
    }


}
