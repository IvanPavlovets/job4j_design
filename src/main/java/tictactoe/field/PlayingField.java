package tictactoe.field;

/**
 * Класс игрового поля.
 */
public class PlayingField {

    /**
     * Наше игровое поле.
     */
    Cell[][] field = new Cell[3][3];

    public PlayingField() {
        initField();
    }

    public Cell[][] getField() {
        return field;
    }

    public void setField(Cell[][] field) {
        this.field = field;
    }

    public void initField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = new Cell();
            }
        }
    }

}
