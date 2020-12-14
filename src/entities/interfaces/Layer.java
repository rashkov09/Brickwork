package entities.interfaces;

import java.util.Collection;
import java.util.List;

public interface Layer {
    void addBricks();
    void fillLayer(int row,int[] data);
    int[][] getLayerData();
    Collection<Brick> getBricks();
}
