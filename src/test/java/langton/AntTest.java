package langton;

import java.awt.Point;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import langton.Ant;
import langton.Ant.Direction;
import langton.Board.Color;

public class AntTest {
	@Test
	public void testSetCoordinates() {
		Ant ant = new Ant();
		ant.setCoordinates(4, 5);
		Point coordinates = ant.getCoordinates();
		Assertions.assertThat(coordinates.getX()).isEqualTo(4);
		Assertions.assertThat(coordinates.getY()).isEqualTo(5);
	}
	
	@Test
	public void testSetDirection() {
		Ant ant = new Ant();
		ant.setDirection(Direction.NORTH);
		Direction direction = ant.getDirection();
		Assertions.assertThat(direction).isEqualTo(Direction.NORTH);
		ant.setDirection(Direction.EAST);
		direction = ant.getDirection();
		Assertions.assertThat(direction).isEqualTo(Direction.EAST);
		ant.setDirection(Direction.SOUTH);
		direction = ant.getDirection();
		Assertions.assertThat(direction).isEqualTo(Direction.SOUTH);
		ant.setDirection(Direction.WEST);
		direction = ant.getDirection();
		Assertions.assertThat(direction).isEqualTo(Direction.WEST);
	}
	
	@Test
	public void testMoveAccordingToRules() {
		Board board = new Board(30);
		board.init();
		Ant ant = new Ant(board);
		int x = 4;
		int y = 5;
		ant.setCoordinates(x, y);
		ant.setDirection(Direction.NORTH);
		ant.move();
		Point coordinates = ant.getCoordinates();
		if (board.getColor(new Point(x, y)) == Color.BLACK) {
			Assertions.assertThat(coordinates.x).isEqualTo(x - 1);
		}
		else {
			Assertions.assertThat(coordinates.x).isEqualTo(x + 1);
		}			
		Assertions.assertThat(coordinates.y).isEqualTo(y);
		
	}
	
	@Test
	public void testWanderAround() {
		Board board = new Board(100);
		//board.init();
		Ant ant = new Ant(board);
		int x = 50;
		int y = 50;
		ant.setCoordinates(x, y);
		ant.setDirection(Direction.NORTH);
		for(int i = 0 ; i< 11500; i++) {			
			ant.move();
		}
		System.out.println(board.toString());
	}
}
