package langton;

import java.awt.Point;

import langton.Board.Color;

public class Ant {

	private Point coordinates;
	enum Direction {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
	private Direction direction;
	private Board board;
	
	public Ant(Board board) {
		this.coordinates = new Point(0, 0);
		this.direction = Direction.NORTH;
		this.board = board;
	}

	public Ant() {
		this.coordinates = new Point(0, 0);
		this.direction = Direction.NORTH;
	}

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(int x, int y) {
		this.coordinates.setLocation(x, y);
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void move() {
		board.toggleColor(coordinates);
		if (board.getColor(coordinates) == Color.BLACK) {
			this.goLeft();
		}
		else if (board.getColor(coordinates) == Color.WHITE) {
			this.goRight();
		}
		//System.out.println("x = " + coordinates.x + " y = " + coordinates.y );
	}

	private void goRight() {
		switch(this.direction)
		{
		case EAST:
			moveSouth();
			break;
		case NORTH:
			moveEast();
			break;
		case SOUTH:
			moveWest();
			break;
		case WEST:
			moveNorth();
			break;
		default:
			break;
		}
	}

	private void goLeft() {
		switch(this.direction)
		{
		case EAST:
			moveNorth();
			break;
		case NORTH:
			moveWest();
			break;
		case SOUTH:
			moveEast();
			break;
		case WEST:
			moveSouth();
			break;
		default:
			break;
		}		
	}

	private void moveWest() {
		this.direction = Direction.WEST;
		if (coordinates.x > 0) {
			this.coordinates.x--;
		}
	}

	private void moveEast() {
		this.direction = Direction.EAST;
		if (coordinates.x < this.board.getHeight()) {
			this.coordinates.x++;		
		}
	}

	private void moveSouth() {
		this.direction = Direction.SOUTH;
		if (coordinates.y > 0) {
			this.coordinates.y--;
		}
	}

	private void moveNorth() {
		this.direction = Direction.NORTH;
		if (coordinates.y < board.getLength()) {
			this.coordinates.y++;
		}
	}
}
