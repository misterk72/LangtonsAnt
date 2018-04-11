package langton;

import java.awt.Point;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import langton.Board.Color;

public class BoardTest {
	@Test
	public void testBoardCorrectSize() {
		Board board = new Board(50);
		board.init();
		int length = board.getLength();
		int height = board.getHeight();
		Assertions.assertThat(50).isEqualTo(length);
		Assertions.assertThat(50).isEqualTo(height);
	}
	
	@Test
	public void testBoardInitialized() {
		Board board = new Board(50);
		board.init();
		int length = board.getLength();
		int height = board.getHeight();
		boolean foundBlack = false;
		boolean foundWhite = false;
		// Verify that all the cases are white or black
		for ( int x = 0 ; x < length ; x++) {
			for ( int y = 0 ; y < height ; y++) {
				Color color = board.getColor(new Point(x, y));
				if (!foundBlack && color == Color.BLACK ) {
					foundBlack = true;
				}
				if (!foundWhite && color == Color.WHITE) {
					foundWhite = true;
				}
				Assertions.assertThat(color).isIn(Color.BLACK, Color.WHITE);
			}
		}
		// Verify that at least one case is white and one is black
		Assertions.assertThat(foundBlack).isTrue();
		Assertions.assertThat(foundWhite).isTrue();
	}
	
	@Test
	public void toggleColor() {
		Board board = new Board(50);
		int x = 5;
		int y = 6;
		Point point = new Point(x, y);
		Color color = board.getColor(point);
		board.toggleColor(point);
		Assertions.assertThat(color).isNotEqualTo(board.getColor(point));
	}
}
