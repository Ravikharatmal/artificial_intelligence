package com.itsallbinary.ai.memory.store.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.itsallbinary.ai.memory.data.Memory;
import com.itsallbinary.ai.memory.store.MemoryStore;
import com.itsallbinary.ai.memory.store.MemoryStoreException;

public class SerializingMemoryStore implements MemoryStore {

	private static final String SERIALIZED_MEMORY_FILE = "serializedMemory.memory";

	public void storeMemory(Memory memory) throws MemoryStoreException {
		ObjectOutputStream oos;
		try {
			FileOutputStream fout = new FileOutputStream(SERIALIZED_MEMORY_FILE);
			oos = new ObjectOutputStream(fout);

			oos.writeObject(memory);
			oos.close();
		} catch (IOException e) {
			throw new MemoryStoreException(e);
		}
	}

	public Memory fetchMemory() throws MemoryStoreException {
		ObjectInputStream ois;
		try {
			FileInputStream fin = new FileInputStream(SERIALIZED_MEMORY_FILE);
			ois = new ObjectInputStream(fin);
			return (Memory) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new MemoryStoreException(e);
		}
	}
}
