package com.itsallbinary.ai.memory;

import java.util.Set;

import com.itsallbinary.ai.memory.data.Behavior;
import com.itsallbinary.ai.memory.data.Memory;
import com.itsallbinary.ai.memory.store.MemoryStore;
import com.itsallbinary.ai.memory.store.MemoryStoreException;

public class MemoryManager {

	private Memory memory;

	private MemoryStore memoryStore;

	public MemoryManager(MemoryStore memoryStore) {
		this.memoryStore = memoryStore;
		try {
			memory = this.memoryStore.fetchMemory();
		} catch (MemoryStoreException e) {
			System.err.println("Not able to deserialize memory. Resetting to new memory. ");
			memory = new Memory();
		}
	}

	public void addLearning(Behavior behavior) throws MemoryStoreException {
		memory.getLearnedBehaviors().put(behavior.getName(), behavior);
		memoryStore.storeMemory(memory);
	}

	public boolean isHavingAnyLearning() {
		return !memory.getLearnedBehaviors().isEmpty();
	}

	public Set<String> getKnownBehaviors() {
		return memory.getLearnedBehaviors().keySet();
	}

	public Behavior getBehavior(String name) {
		return memory.getLearnedBehaviors().get(name);
	}

}
