package com.wcg.remotecc.model.rcu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wcg.remotecc.command.Command;
import com.wcg.remotecc.command.MoveCommand;
import com.wcg.remotecc.command.TurnCommand;
import com.wcg.remotecc.controller.RemoteControl;
import com.wcg.remotecc.exceptions.GridCoordinatesOutOfBoundsException;
import com.wcg.remotecc.model.Grid;
import com.wcg.remotecc.model.Orientation;
import com.wcg.remotecc.model.Position;
import com.wcg.remotecc.model.Turn;

/**
 * Unit tests for Car
 */
public class CarTest {

	@Test
	public void checkCarIsPositionedInTheGridOnGivenCoordinates() throws GridCoordinatesOutOfBoundsException {
		Position carPosition = new Position(5, 5);
		RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(carPosition);
		Grid grid = new Grid();
		newCar.placeInGrid(grid);

		assertEquals(carPosition, grid.getCars().stream().findFirst().get().getPosition());
	}

	@Test(expected = GridCoordinatesOutOfBoundsException.class)
	public void checkCarCoordinatesOutsideTheGridThenAnExceptionArises()
			throws GridCoordinatesOutOfBoundsException {
		Position carPosition = new Position(3, 3);
		RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(carPosition);
		Grid grid = new Grid(new Position(2, 2));
		newCar.placeInGrid(grid);
	}

	@Test
	public void checkCarIsHeadingNorth() throws GridCoordinatesOutOfBoundsException {
		Position carPosition = new Position(6, 6);
		RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(carPosition);
		Grid grid = new Grid();
		newCar.placeInGrid(grid);

		assertEquals(Orientation.NORTH, grid.getCars().stream().findFirst().get().getDirection());
	}

	@Test
	public void checkCarDirectionChangesWhenATurnLeftOrRightCommandIsSent()
			throws GridCoordinatesOutOfBoundsException {
		Position carPosition = new Position(8, 4);
		RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(carPosition);
		Grid grid = new Grid();
		newCar.placeInGrid(grid);

		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setRemoteUnit(newCar);

		Command command = new TurnCommand(Turn.LEFT);

		remoteControl.addCommand(command);
		remoteControl.transmitCommands();

		assertEquals(Orientation.WEST, grid.getCars().stream().findFirst().get().getDirection());

		Command command2 = new TurnCommand(Turn.RIGHT);

		remoteControl.addCommand(command2);

		remoteControl.transmitCommands();

		assertEquals(Orientation.NORTH, grid.getCars().stream().findFirst().get().getDirection());
	}

	@Test
	public void checkCarPositionChangesWhenAMoveForwardCommandIsSent()
			throws GridCoordinatesOutOfBoundsException {
		Position carPosition = new Position(2, 2);
		RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(carPosition);
		Grid grid = new Grid();
		newCar.placeInGrid(grid);

		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setRemoteUnit(newCar);

		Command command = new MoveCommand();

		remoteControl.addCommand(command);
		remoteControl.transmitCommands();

		assertEquals(new Position(2, 3), grid.getCars().stream().findFirst().get().getPosition());
	}

	@Test
	public void checkCarPositionChangesWhenSeveralCommandsAreSent()
			throws GridCoordinatesOutOfBoundsException {
		Position carPosition = new Position(2, 2);
		RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(carPosition);
		Grid grid = new Grid();
		newCar.placeInGrid(grid);

		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setRemoteUnit(newCar);

		Command command = new MoveCommand();
		Command command2 = new TurnCommand(Turn.LEFT);

		remoteControl.addCommand(command);
		remoteControl.addCommand(command2);
		remoteControl.addCommand(command);
		remoteControl.transmitCommands();

		assertEquals(new Position(1, 3), grid.getCars().stream().findFirst().get().getPosition());
		assertEquals(Orientation.WEST, grid.getCars().stream().findFirst().get().getDirection());
	}

	@Test
	public void checkCarPositionWhenAForwardCommandAtTheEdgeOfTheGridIsSent()
			throws GridCoordinatesOutOfBoundsException {
		Position carPosition = new Position(1, 1);
		RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(carPosition);
		Grid grid = new Grid();
		newCar.placeInGrid(grid);

		RemoteControl remoteControl = new RemoteControl();
		remoteControl.setRemoteUnit(newCar);

		Command command = new MoveCommand();
		Command command2 = new TurnCommand(Turn.LEFT);

		remoteControl.addCommand(command2);
		remoteControl.addCommand(command);
		remoteControl.addCommand(command);
		remoteControl.addCommand(command);
		remoteControl.transmitCommands();

		assertEquals(new Position(1, 1), grid.getCars().stream().findFirst().get().getPosition());
	}
}
