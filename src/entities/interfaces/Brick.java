package entities.interfaces;

public interface Brick {
    void rotateVertically();
    int[] getLeft();
    int[] getRight();
    int getMarkedValue();
    void move(int[] left, int[] right);
}
