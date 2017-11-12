package com.wcg.remotecc.command;

import com.wcg.remotecc.model.rcu.RemoteControlledUnit;

public interface Command {
	public void execute(RemoteControlledUnit rcUnit);
}
