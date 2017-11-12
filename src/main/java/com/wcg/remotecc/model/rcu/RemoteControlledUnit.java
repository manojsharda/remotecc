package com.wcg.remotecc.model.rcu;

import com.wcg.remotecc.exceptions.GridCoordinatesOutOfBoundsException;
import com.wcg.remotecc.model.Grid;
import com.wcg.remotecc.model.Orientation;
import com.wcg.remotecc.model.Position;
import com.wcg.remotecc.model.Turn;

public interface RemoteControlledUnit {

	public void turn(Turn turn);

	public void move();

	public Position getPosition();

	public Orientation getDirection();

	public void setInitialPosition(Position position);

	public void placeInGrid(Grid grid) throws GridCoordinatesOutOfBoundsException;
}
