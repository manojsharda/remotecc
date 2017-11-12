package com.wcg.remotecc.command;

import com.wcg.remotecc.model.Turn;
import com.wcg.remotecc.model.rcu.RemoteControlledUnit;

public class TurnCommand implements Command {

	private Turn turn;

	public TurnCommand(final Turn turn) {
		this.turn = turn;
	}

	public void execute(RemoteControlledUnit rcUnit) {
		rcUnit.turn(turn);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((turn == null) ? 0 : turn.hashCode());
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
		TurnCommand other = (TurnCommand) obj;
		if (turn != other.turn)
			return false;
		return true;
	}

}
