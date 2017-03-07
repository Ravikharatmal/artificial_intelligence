package com.itsallbinary.ai.processor;

import java.util.List;

import com.itsallbinary.ai.memory.data.Behavior;

public interface Processor {

	Object process(Behavior behavior, List<String> inputs) throws ProcessingException;

}