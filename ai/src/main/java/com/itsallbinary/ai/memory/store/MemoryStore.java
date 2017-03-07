package com.itsallbinary.ai.memory.store;

import com.itsallbinary.ai.memory.data.Memory;

public interface MemoryStore {

	public void storeMemory(Memory memory) throws MemoryStoreException;

	public Memory fetchMemory() throws MemoryStoreException;
}
