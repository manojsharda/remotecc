package com.wcg.remotecc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wcg.remotecc.command.Command;
import com.wcg.remotecc.command.CommandFactory;
import com.wcg.remotecc.exceptions.CommandNotKnownException;
import com.wcg.remotecc.model.Position;
import com.wcg.remotecc.model.rcu.Car;
import com.wcg.remotecc.model.rcu.RemoteControlledUnit;

public class InputParser {

	protected Position parsePosition(final String positionString) throws IllegalArgumentException {
		final String[] coordinates = positionString.split("[\\s,]");
		if (coordinates.length != 2) {
			throw new IllegalArgumentException("Invalid position definition");
		}

		int posX = 0;
		int posY = 0;

		try {
			posX = Integer.parseInt(coordinates[0]);
			posY = Integer.parseInt(coordinates[1]);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("Position coordinates must be numbers");
		}
		return new Position(posX, posY);
	}

	protected List<Command> parseCommands(final String commandsString) throws CommandNotKnownException {
		final List<Command> commandsList = new ArrayList<Command>();

		for (final String commandString : commandsString.split("")) {
			commandsList.add(CommandFactory.getCommand(commandString));
		}

		return commandsList;
	}

	public Map<RemoteControlledUnit, List<Command>> parseInput(final String input)
			throws CommandNotKnownException, IllegalArgumentException {
		final Map<RemoteControlledUnit, List<Command>> parsedInput = new HashMap<RemoteControlledUnit, List<Command>>();
		final String[] inputParts = input.split(":");
		if (inputParts.length != 2) {
			throw new IllegalArgumentException("Invalid input definition");
		}
		final Position parsedPosition = parsePosition(inputParts[0]);
		final List<Command> parsedCommands = parseCommands(inputParts[1]);

		final RemoteControlledUnit newCar = new Car();
		newCar.setInitialPosition(parsedPosition);

		parsedInput.put(newCar, parsedCommands);

		return parsedInput;
	}

}
