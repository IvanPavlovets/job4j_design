package tictactoe.field;

/**
 * Класс, сохроняющий в себе координату ячейки
 */
public class Coord {
    private int x = -1;
    private int y = -1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
