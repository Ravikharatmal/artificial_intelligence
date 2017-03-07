package com.itsallbinary.ai.memory.data;

import java.io.Serializable;

public class Behavior implements Serializable {

	private static final long serialVersionUID = -5619808105308154276L;

	private String name;

	private Integer numberOfInputsNeeded;

	private String behavior;

	public Behavior(String name, Integer numberOfInputsNeeded, String behavior) {
		this.name = name;
		this.numberOfInputsNeeded = numberOfInputsNeeded;
		this.behavior = behavior;
	}

	public Integer getNumberOfInputsNeeded() {
		return numberOfInputsNeeded;
	}

	public void setNumberOfInputsNeeded(Integer numberOfInputsNeeded) {
		this.numberOfInputsNeeded = numberOfInputsNeeded;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
