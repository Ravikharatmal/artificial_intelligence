package com.itsallbinary.ai.facade;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.itsallbinary.ai.memory.MemoryManager;
import com.itsallbinary.ai.memory.data.Behavior;
import com.itsallbinary.ai.memory.store.MemoryStoreException;
import com.itsallbinary.ai.memory.store.impl.SerializingMemoryStore;
import com.itsallbinary.ai.processor.ProcessingException;
import com.itsallbinary.ai.processor.Processor;
import com.itsallbinary.ai.processor.impl.NashornProcessor;

public class AIRobot {

	private Processor processor = new NashornProcessor();

	private MemoryManager memoryManager = new MemoryManager(
			new SerializingMemoryStore());

	public void teachBehavior(String name, Integer numberOfInputsNeeded,
			String behavior) throws AIException {
		teachBehaviorInternal(name, numberOfInputsNeeded, behavior);
	}

	public void memorizeData(String jsonData) {
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(jsonData);
		System.out.println(element);
		System.out.println(element.getAsJsonObject().get("ravi"));
	}

	public void teachBehavior(String name, String behavior) throws AIException {
		teachBehaviorInternal(name, 0, behavior);
	}

	private void teachBehaviorInternal(String name,
			Integer numberOfInputsNeeded, String behavior) throws AIException {
		try {
			Behavior behaviorObj = new Behavior(name, numberOfInputsNeeded,
					behavior);
			memoryManager.addLearning(behaviorObj);
		} catch (MemoryStoreException e) {
			throw new AIException(e);
		}
	}

	public Set<String> getKnownBehaviors() {
		return memoryManager.getKnownBehaviors();
	}

	public int getNumberOfInputsForBehavior(String name) throws AIException {
		if (memoryManager.getBehavior(name) == null) {
			throw new AIException("Behavior not found - " + name);
		}
		return memoryManager.getBehavior(name).getNumberOfInputsNeeded();
	}

	public Object processBehavior(String name, List<String> inputs)
			throws AIException {
		return processBehaviorInternal(name, inputs);
	}

	public Object processBehavior(String name) throws AIException {
		return processBehaviorInternal(name, Collections.emptyList());
	}

	private Object processBehaviorInternal(String name, List<String> inputs)
			throws AIException {
		Behavior behavior = memoryManager.getBehavior(name);
		if (behavior == null) {
			throw new AIException("Behavior not found - " + name);
		}

		try {
			return processor.process(behavior, inputs);
		} catch (ProcessingException e) {
			throw new AIException(e);
		}
	}

}
