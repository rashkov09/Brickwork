package entities.models;

import entities.interfaces.Brick;
import entities.interfaces.Layer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LayerImpl implements Layer {
    private int[][] dimensions;
    private Collection<Brick> bricks;

    public LayerImpl(int rows,int cols) {
        setDimensions(rows,cols);
        this.bricks = new ArrayList<>();
    }

    private void setDimensions(int rows, int cols) {
        if (rows >= 100 || cols >= 100){
            throw new IllegalArgumentException("Invalid layer dimensions!");
        }
        this.dimensions = new int[rows][cols];
    }

    @Override
    public void addBricks() {
        int[] left;
        int[] right;
        int leftValue;
        int rightValue;
        for (int row = 0; row < this.getLayerData().length; row++) {
            for (int col = 0; col < this.getLayerData()[row].length; col+=2) {
                leftValue = this.getLayerData()[row][col];
                rightValue = this.getLayerData()[row][col+1];
                if (leftValue == rightValue){
                    left = new int[]{row,col};
                    right = new int[]{row,col+1};
                    Brick brick = new BrickImpl(left,right,rightValue);
                    this.bricks.add(brick);
                }
            }
        }
    }

    @Override
    public void fillLayer(int row, int[] data) {
        if (row > this.getLayerData().length){
            throw new IllegalArgumentException("Out of layer");
        }
        this.getLayerData()[row] = data;
    }

    @Override
    public int[][] getLayerData() {
        return this.dimensions;
    }

    @Override
    public Collection<Brick> getBricks() {
        return this.bricks;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.getLayerData().length; i++) {
            for (int j = 0; j < this.getLayerData()[i].length; j++) {
                builder.append(this.getLayerData()[i][j]).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
