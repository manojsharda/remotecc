package com.wcg.remotecc.command;

import com.wcg.remotecc.model.rcu.RemoteControlledUnit;

public class MoveCommand implements Command {

	public void execute(RemoteControlledUnit rcUnit) {
		rcUnit.move();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
