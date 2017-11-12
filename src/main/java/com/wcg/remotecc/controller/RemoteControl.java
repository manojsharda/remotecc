package com.wcg.remotecc.controller;

import java.util.ArrayList;
import java.util.List;

import com.wcg.remotecc.command.Command;
import com.wcg.remotecc.model.rcu.RemoteControlledUnit;

public class RemoteControl {

	private List<Command> commandList;
	private RemoteControlledUnit rcUnit;

	public RemoteControl() {
		this.commandList = new ArrayList<Command>();
	}

	public void addCommand(final Command command) {
		this.commandList.add(command);
	}

	public void transmitCommands() {
		for (final Command command : commandList) {
			command.execute(this.rcUnit);
		}
		this.commandList = new ArrayList<Command>();
	}

	public void setRemoteUnit(final RemoteControlledUnit rcUnit) {
		this.rcUnit = rcUnit;
	}
}
