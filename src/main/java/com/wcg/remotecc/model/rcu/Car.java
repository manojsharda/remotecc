package com.wcg.remotecc.model.rcu;

import com.wcg.remotecc.exceptions.GridCoordinatesOutOfBoundsException;
import com.wcg.remotecc.model.Grid;
import com.wcg.remotecc.model.Orientation;
import com.wcg.remotecc.model.Position;
import com.wcg.remotecc.model.Turn;

public class Car implements RemoteControlledUnit {

	private Position position;
	private Orientation direction;
	private Grid grid;

	public Orientation getDirection() {
		return direction;
	}

	public void setInitialPosition(final Position position) {
		this.position = position;
	}

	public void placeInGrid(final Grid grid) throws GridCoordinatesOutOfBoundsException {
		this.direction = Orientation.NORTH;
		this.grid = grid;
		grid.addRemoteControlledUnit(this);
	}

	public Position getPosition() {
		return this.position;
	}

	public void turn(final Turn turn) {
		this.direction = direction.turnTo(turn);
	}

	public void move() {
		final Position newPosition = position.addPosition(direction.getUnitVector());
		if (grid.isInsideGrid(newPosition)) {
			this.position = newPosition;
		}
	}

}
