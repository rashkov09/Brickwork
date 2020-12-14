package core.interfaces;

import io.interfaces.Reader;

import java.io.IOException;

public interface Controller {
    void createLayer(int row, int col);

    void fillLayer(Reader reader) throws IOException;

    void addBricks();

    String result();

    void createNextLayer();

}
