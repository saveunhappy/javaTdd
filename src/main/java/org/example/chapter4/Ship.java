package org.example.chapter4;

public class Ship {

	/***    ----------需求 1------------
	 *		给定军舰的起始位置(x, y)以及它面向的方向 （N、S、E或W） ）。   ***/

	private final Location location;

	public Location getLocation() {
		return location;
	}

	public Ship(Location location) {
		this.location = location;
	}
	public boolean moveForward() {
		return location.forward();
	}

	public boolean moveBackward() {
		return location.backward();
	}

	public void turnLeft() {
		location.turnLeft();
	}

	public void turnRight() {
		location.turnRight();
	}

	public void receiveCommands(String commands) {

		if (commands.charAt(0) == 'f') {
			moveForward();
		}
		if (commands.charAt(0) == 'b') {
			moveBackward();
		}
		if (commands.charAt(0) == 'l') {
			turnLeft();
		}
		if (commands.charAt(0) == 'r') {
			turnRight();
		}

	}
}
