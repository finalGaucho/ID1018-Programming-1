/*public class ReachableFieldsOnChessboard {
    public static void main(String [] args) throws Chessboard.Chesspiece.NotValidFieldException {

      Chessboard chessBoard = new Chessboard ();
      System . out. println ( chessBoard + "\n");
      Chessboard . Chesspiece [] pieces = new Chessboard . Chesspiece [6];
      pieces [0] = chessBoard . new Pawn ('w', 'P');
      pieces [1] = chessBoard . new Rook ('b', 'R');
      pieces [2] = chessBoard . new Queen ('w', 'Q');
      pieces [3] = chessBoard . new Bishop ('w', 'B');
      pieces [4] = chessBoard . new King ('b', 'K');
      pieces [5] = chessBoard . new Knight ('w', 'N');

      for (Chessboard.Chesspiece piece : pieces) {
        piece.moveTo('d', (byte) (6));
        piece.markReachableFields();
        System.out.println(chessBoard + "\n");
        piece.unmarkReachableFields();
        System.out.println(chessBoard + "\n");
        piece.moveOut();
      }

    }
}
 */

import java.util.Random;
public class ReachableFieldsOnChessboard {
  public static void main(String[] args) throws Chessboard.Chesspiece.NotValidFieldException {
    Random rand = new Random();
    Chessboard chessBoard = new Chessboard();
    System.out.println(chessBoard + "\n");

    Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
    pieces[0] = chessBoard.new Pawn('w', 'P');
    pieces[1] = chessBoard.new Rook('b', 'R');
    pieces[2] = chessBoard.new Queen('w', 'Q');
    pieces[3] = chessBoard.new Bishop('w', 'B');
    pieces[4] = chessBoard.new King('b', 'K');
    pieces[5] = chessBoard.new Knight('w', 'N');

    for (int i = 0; i < pieces.length; i++) {
      int row = rand.nextInt(8);
      int firstRow = 'a';
      char charRow = (char) (firstRow + row);
      int col = rand.nextInt(8) + 1;
      byte byteCol = (byte) (col);

      pieces[i].moveTo(charRow, byteCol);
      pieces[i].markReachableFields();
      System.out.println("Piece " + (i + 1) + ":\n" + chessBoard);
      pieces[i].unmarkReachableFields();
      pieces[i].moveOut();
    }
  }
}
