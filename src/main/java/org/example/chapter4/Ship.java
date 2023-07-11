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


}
