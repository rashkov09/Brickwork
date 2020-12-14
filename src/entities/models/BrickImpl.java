package entities.models;

import entities.interfaces.Brick;

public class BrickImpl implements Brick {
    private int[] left;
    private int[] right;
    private int markedValue;

    public BrickImpl(int[] left, int[] right, int markedValue) {
        setLeft(left);
        setRight(right);
        setMarkedValue(markedValue);
    }

    private void setMarkedValue(int markedValue) {
        this.markedValue = markedValue;
    }

    private void setRight(int[] right) {
        this.right = right;
    }

    private void setLeft(int[] left) {
        this.left = left;
    }


    @Override
    public void rotateVertically() {
        setRight(new int[]{getRight()[0]+1,getRight()[1]-1});
    }

    @Override
    public int[] getLeft() {
        return this.left;
    }

    @Override
    public int[] getRight() {
        return this.right;
    }

    @Override
    public int getMarkedValue() {
        return this.markedValue;
    }

    @Override
    public void move(int[] left, int[] right) {
        setLeft(left);
        setRight(right);
    }
}
