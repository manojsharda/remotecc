package com.wcg.remotecc;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.wcg.remotecc.utils.InputParser;
import com.wcg.remotecc.model.Grid;
import com.wcg.remotecc.model.rcu.RemoteControlledUnit;
import com.wcg.remotecc.command.Command;
import com.wcg.remotecc.controller.RemoteControl;
import com.wcg.remotecc.exceptions.GridCoordinatesOutOfBoundsException;
import com.wcg.remotecc.exceptions.CommandNotKnownException;

/**
 * Main App Class
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Enter Initial  Car coordinates and the commands to be executed (e.g. 5,5:RFLFRFLF)");
		final Scanner in = new Scanner(System.in);
		final String nextLine = in.nextLine();
		final InputParser inputParser = new InputParser();
		Map<RemoteControlledUnit, List<Command>> parsedInput;
		try {
			parsedInput = inputParser.parseInput(nextLine);
			final Grid grid = new Grid();
			for (final Entry<RemoteControlledUnit, List<Command>> rcu : parsedInput.entrySet()) {
				final RemoteControlledUnit controlledUnit = rcu.getKey();
				controlledUnit.placeInGrid(grid);
				final RemoteControl remoteControl = new RemoteControl();
				remoteControl.setRemoteUnit(controlledUnit);
				final List<Command> commands = rcu.getValue();
				commands.forEach(com -> remoteControl.addCommand(com));
				remoteControl.transmitCommands();
				System.out.println(controlledUnit.getPosition());
			}
		} catch (CommandNotKnownException e) {
			System.err.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (GridCoordinatesOutOfBoundsException e) {
			System.err.println(e.getMessage());
		} finally {
			in.close();
		}
	}
}
