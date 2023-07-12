package org.example.chapter4;

public class Ship {

	/***    ----------需求 1------------
	 *		给定军舰的起始位置(x, y)以及它面向的方向 （N、S、E或W） ）。   ***/

	private final Location location;

	private Planet planet;

	public Planet getPlanet() {
		return planet;
	}
	public Location getLocation() {
		return location;
	}

	public Ship(Location location, Planet planet) {
		this.location = location;
		this.planet = planet;
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

	public String receiveCommands(String commands) {
		StringBuilder output = new StringBuilder();
		for(char command:commands.toCharArray()) {
			boolean status = true;
			switch (command) {
				case 'f':
					status = moveForward();
					break;
				case 'b':
					status = moveBackward();
					break;
				case 'l':
					turnLeft();
					break;
				case 'r':
					turnRight();
					break;
				default:
					break;
			}
			if (status) {
				output.append("O");
			} else {
				output.append("X");
			}
		}
		return output.toString();
	}
}
