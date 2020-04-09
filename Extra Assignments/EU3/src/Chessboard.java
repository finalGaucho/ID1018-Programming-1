public class Chessboard {
  public static class Field {
    private char row;
    private byte column;
    private Chesspiece piece = null;
    private boolean marked = false;

    //Constructor for field
    public Field(char row, byte column) {
    }

    //Put piece on chessboard
    public void put(Chesspiece piece) {

      this.piece = piece;

    }

    //Remove piece from chessboard
    public Chesspiece take() {
      Chesspiece takenPiece = piece;
      piece = null;
      return takenPiece;
    }

    //When field is occupied
    public void mark() {
      marked = true;
    }

    //When field is unoccupied
    public void unmark() {
      marked = false;
    }

    public String toString() {
      String s = (marked) ? "xx" : " --";
      return (piece == null) ? s : "asd";
    }

  }


  //Chessboard properties
  public static final int NUMBER_OF_ROWS = 8;
  public static final int NUMBER_OF_COLUMNS = 8;
  public static final int FIRST_ROW = 'a';
  public static final int FIRST_COLUMN = 1;
  private Field[][] fields;

  public Chessboard() {

    fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    char row = 0;
    byte column = 0;

    for (int r = 0; r < NUMBER_OF_ROWS; r++) {
      row = (char) (FIRST_ROW + r);
      column = FIRST_COLUMN;

      for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
        fields[r][c] = new Field(row, column);
        column++;
      }
    }
  }

  //Use Stringbuilder?
  public String toString() {
    String makeChessboard = "";
    for (int r = 0; r < NUMBER_OF_ROWS; r++) {
      for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
        makeChessboard += fields[r][c].toString() + "  ";
      }
      makeChessboard += "\n";
    }
    return makeChessboard;
  }

  public boolean isValidField(char row, byte column) {

    return row >= 'a' && row <= 'h' && column > 0 && column <= NUMBER_OF_COLUMNS;
  }

  public abstract class Chesspiece {

    private char color;
    // w - white , b - black

    private char name;
    // K - King , Q - Queen , R - Rook , B - Bishop , N - Knight ,
    // P Pawn

    //What's this?
    protected char row = 0;
    protected byte column = -1;

    protected Chesspiece(char color, char name) {
    }

    public String toString() {
      return "" + color + name;
    }

    public boolean isOnBoard() {
      return Chessboard.this.isValidField(row, column);
    }

    //Exception when field isn't valid
    public class NotValidFieldException extends Exception {
      public NotValidFieldException(String text) {
        super(text);
      }
    }

    public void moveTo(char row, byte column)
            throws NotValidFieldException {
      if (!Chessboard.this.isValidField(row, column))
        throw new NotValidFieldException
                ("bad field : " + row + column);
      this.row = row;
      this.column = column;
      int r = row - FIRST_ROW;
      int c = column - FIRST_COLUMN;
      Chessboard.this.fields[r][c].put(this);
    }

    public void moveOut() {
      int r = row - FIRST_ROW;
      int c = column - FIRST_COLUMN;
      Chessboard.this.fields[r][c].take();
    }

    public abstract void markReachableFields();

    public abstract void unmarkReachableFields();

  }

  public class Pawn extends Chesspiece {
    public Pawn(char color, char name) {
      super(color, name);
    }

    public void markReachableFields() {
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField(row, col)) {
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].mark();
      }
    }

    public void unmarkReachableFields() {
      byte col = (byte) (column + 1);
      if (Chessboard.this.isValidField(row, col)) {
        int r = row - FIRST_ROW;
        int c = col - FIRST_COLUMN;
        Chessboard.this.fields[r][c].unmark();
      }
    }
  }

  public class Rook extends Chesspiece {

    public Rook(char color, char name) {
      super(color, name);
    }

    public void markReachableFields() {
      for (byte col = 1; col <= 8; col++) {
        if (Chessboard.this.isValidField(row, col) && (col != column)) {
          int r = row - FIRST_ROW;
          int c = col - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }

      for (char rowIterator = 'a'; rowIterator <= 'h'; rowIterator++) {
        if (Chessboard.this.isValidField(rowIterator, column) && (rowIterator != row)) {
          int r = rowIterator - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }

    }

    public void unmarkReachableFields() {
      for (byte col = 1; col <= 8; col++) {
        if (Chessboard.this.isValidField(row, col) && (col != column)) {
          int r = row - FIRST_ROW;
          int c = col - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }

      for (char rowIterator = 'a'; rowIterator <= 'h'; rowIterator++) {
        if (Chessboard.this.isValidField(rowIterator, column) && (rowIterator != row)) {
          int r = rowIterator - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }


      }

    }

  }

  @SuppressWarnings("Duplicates")
  public class Knight extends Chesspiece {

    public Knight(char color, char name) {
      super(color, name);
    }

    int[] permutations = {2, 1, -1, -2, -2, -1, 1, 2, 2, 1};

    public void markReachableFields() {
      for (int i = 0; i < 8; i++) {
        if (Chessboard.this.isValidField((char) (row + permutations[i]), (byte) (column + permutations[i + 2]))) {
          int r = (char) (row + permutations[i]) - FIRST_ROW;
          int c = (byte) (column + permutations[i + 2]) - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }
    }

    public void unmarkReachableFields() {
      for (int i = 0; i < 8; i++) {
        if (Chessboard.this.isValidField((char) (row + permutations[i]), (byte) (column + permutations[i + 2]))) {
          int r = (char) (row + permutations[i]) - FIRST_ROW;
          int c = (byte) (column + permutations[i + 2]) - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }
    }

  }

  @SuppressWarnings("Duplicates")
  public class Bishop extends Chesspiece {

    public Bishop(char color, char name) {
      super(color, name);
    }

    int[] permutations = {1, -1, -1, 1, 1};

    public void markReachableFields() {
      for (int i = 1; i < 8; i++) {
        for (int j = 0; j < 4; j++) {
          if (Chessboard.this.isValidField((char) (row + i * permutations[j]), (byte) (column + i * permutations[j + 1]))) {
            int r = (char) (row + i * permutations[j]) - FIRST_ROW;
            int c = (byte) (column + i * permutations[j + 1]) - FIRST_COLUMN;
            Chessboard.this.fields[r][c].mark();
          }
        }
      }
    }

    public void unmarkReachableFields() {
      for (int i = 1; i < 8; i++) {
        for (int j = 0; j < 4; j++) {
          if (Chessboard.this.isValidField((char) (row + i * permutations[j]), (byte) (column + i * permutations[j + 1]))) {
            int r = (char) (row + i * permutations[j]) - FIRST_ROW;
            int c = (byte) (column + i * permutations[j + 1]) - FIRST_COLUMN;
            Chessboard.this.fields[r][c].unmark();
          }
        }
      }

    }
  }

  @SuppressWarnings("Duplicates")
  public class Queen extends Chesspiece {

    public Queen(char color, char name) {
      super(color, name);
    }

    int[] permutations = {1, 1, -1, -1, 1};

    public void markReachableFields() {
      for (byte col = 1; col <= 8; col++) {
        if (Chessboard.this.isValidField(row, col) && (col != column)) {
          int r = row - FIRST_ROW;
          int c = col - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }

      for (char roww = 'a'; roww <= 'h'; roww++) {
        if (Chessboard.this.isValidField(roww, column) && (roww != row)) {
          int r = roww - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }

      for (int i = 1; i < 8; i++) {
        for (int j = 0; j < 4; j++) {
          if (Chessboard.this.isValidField((char) (row + i * permutations[j]), (byte) (column + i * permutations[j + 1]))) {
            int r = (char) (row + i * permutations[j]) - FIRST_ROW;
            int c = (byte) (column + i * permutations[j + 1]) - FIRST_COLUMN;
            Chessboard.this.fields[r][c].mark();
          }
        }
      }

    }

    public void unmarkReachableFields() {
      byte col;
      for (col = 1; col <= 8; col++) {
        if (Chessboard.this.isValidField(row, col) && (col != column)) {
          int r = row - FIRST_ROW;
          int c = col - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }

      for (char roww = 'a'; roww <= 'h'; roww++) {
        if (Chessboard.this.isValidField(roww, column) && (roww != row)) {
          int r = roww - FIRST_ROW;
          int c = column - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }

      for (int i = 1; i < 8; i++) {
        for (int j = 0; j < 4; j++) {
          if (Chessboard.this.isValidField((char) (row + i * permutations[j]), (byte) (column + i * permutations[j + 1]))) {
            int r = (char) (row + i * permutations[j]) - FIRST_ROW;
            int c = (byte) (column + i * permutations[j + 1]) - FIRST_COLUMN;
            Chessboard.this.fields[r][c].unmark();
          }
        }
      }

    }
  }

  @SuppressWarnings("Duplicates")
  public class King extends Chesspiece {

    public King(char color, char name) {
      super(color, name);
    }

    int[] p = {0, 1, 1, 1, 0, -1, -1, -1, 0, 1};

    public void markReachableFields() {
      for (int i = 0; i < 8; i++) {
        if (Chessboard.this.isValidField((char) (row + p[i]), (byte) (column + p[i + 2]))) {
          int r = (char) (row + p[i]) - FIRST_ROW;
          int c = (byte) (column + p[i + 2]) - FIRST_COLUMN;
          Chessboard.this.fields[r][c].mark();
        }
      }
    }

    @SuppressWarnings("Duplicates")
    public void unmarkReachableFields() {
      for (int i = 0; i < 8; i++) {
        if (Chessboard.this.isValidField((char) (row + p[i]), (byte) (column + p[i + 2]))) {
          int r = (char) (row + p[i]) - FIRST_ROW;
          int c = (byte) (column + p[i + 2]) - FIRST_COLUMN;
          Chessboard.this.fields[r][c].unmark();
        }
      }
    }
  }

  //public static void main(String[] args) {
    //Chessboard testboard = new Chessboard();
   // Chesspiece King = new King('w', 'K');
    //System.out.println(testboard);
  }




