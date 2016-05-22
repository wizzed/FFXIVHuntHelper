package net.wizzed.hunthelper.model;

import java.io.Serializable;
import java.util.Objects;


import android.graphics.Point;

public class Mob implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8617505348788101892L;
	public Name name;
	public int numberRequired;
	public Coordinate location;
	public String map;

	public Mob(String map, Name name, int numberRequired, Coordinate location) {
		this.name = name;
		this.numberRequired = numberRequired;
		this.map = map;
		this.location = location;
	}

	public boolean equals(Mob o) {
		return this.name.getName(Name.EN).equals(o.name.getName(Name.EN));
	}

}
