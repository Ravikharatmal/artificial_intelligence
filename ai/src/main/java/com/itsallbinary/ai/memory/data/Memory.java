package com.itsallbinary.ai.memory.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;

public class Memory implements Serializable {

	private static final long serialVersionUID = 5045431842980848951L;

	private Map<String, Behavior> learnedBehaviors = new HashMap<>();

	private List<JsonObject> memorizedData = new ArrayList<>();

	public Map<String, Behavior> getLearnedBehaviors() {
		return learnedBehaviors;
	}

	public List<JsonObject> getMemorizedData() {
		return memorizedData;
	}

}
