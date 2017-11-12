package com.wcg.remotecc.model;

import java.util.ArrayList;
import java.util.List;

import com.wcg.remotecc.exceptions.GridCoordinatesOutOfBoundsException;
import com.wcg.remotecc.model.rcu.RemoteControlledUnit;
import com.wcg.remotecc.utils.Constants;

public class Grid {

	private Position size;
	private List<RemoteControlledUnit> rcUnitsList;

	public Grid() {
		this.size = Constants.GRID_DEFAULT_SIZE;
		this.rcUnitsList = new ArrayList<RemoteControlledUnit>();
	}

	public Grid(final Position size) {
		this.size = size;
		this.rcUnitsList = new ArrayList<RemoteControlledUnit>();
	}

	protected Position getSize() {
		return size;
	}

	public List<RemoteControlledUnit> getCars() {
		return rcUnitsList;
	}

	public void addRemoteControlledUnit(final RemoteControlledUnit rcUnit) throws GridCoordinatesOutOfBoundsException {
		if (isInsideGrid(rcUnit.getPosition())) {
			rcUnitsList.add(rcUnit);
		} else {
			throw new GridCoordinatesOutOfBoundsException("Given coordinates exceed Grid boundaries");
		}
	}

	public boolean isInsideGrid(final Position position) {
		return position.isWithinBounds(size);
	}
}
