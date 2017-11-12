package com.wcg.remotecc.command;

import java.util.HashMap;
import java.util.Map;

import com.wcg.remotecc.exceptions.CommandNotKnownException;
import com.wcg.remotecc.model.Turn;

public class CommandFactory {

	private static Map<String, Command> commandsMap;

	static {
		commandsMap = new HashMap<String, Command>();
		commandsMap.put("R", new TurnCommand(Turn.RIGHT));
		commandsMap.put("L", new TurnCommand(Turn.LEFT));
		commandsMap.put("F", new MoveCommand());
	}

	public static Command getCommand(final String commandString) throws CommandNotKnownException {
		final Command command = commandsMap.get(commandString);
		if (command == null) {
			throw new CommandNotKnownException(commandString + " command is not recognized");
		}
		return command;
	}

}
