package langton;

import java.awt.Point;

public class Board {

	enum Color {
		BLACK,
		WHITE
	}
	
	Color[][] boardArray;
	int edgeSize;
	
	public Board(int edgeSize) {
		this.edgeSize = edgeSize;
		this.boardArray = new Color[edgeSize][edgeSize];
		for(int x = 0 ; x < edgeSize ; x++) {
			for(int y = 0 ; y < edgeSize ; y++) {
				boardArray[x][y] = Color.WHITE;
			}
		}
	}

	public void init() {
		for(int x = 0 ; x < edgeSize ; x++) {
			for(int y = 0 ; y < edgeSize ; y++) {
				boardArray[x][y] = (Math.random() < 0.5)?Color.BLACK:Color.WHITE;
			}
		}
	}

	public int getLength() {
		return boardArray[0].length;
	}

	public int getHeight() {
		return boardArray.length;
	}
	
	public Color getColor(Point point) {
		return boardArray[point.x][point.y];
	}

	private void setColor(Point point, Color color) {
		boardArray[point.x][point.y] = color;		
	}

	public void toggleColor(Point point) {
	  if(getColor(point) == Color.BLACK) {
		  setColor(point, Color.WHITE);
	  } else {
		  setColor(point, Color.BLACK);
	  }
	}
	
	public String toString() {
		String str = "";
		for(int x = 0 ; x < edgeSize ; x++) {
			for(int y = 0 ; y < edgeSize ; y++) {
				if (boardArray[x][y] == Color.BLACK) {
					str += "X";
				} else {
					str += " ";
				}
			}
			str += "\n";
		}
		return str;
	}

}
