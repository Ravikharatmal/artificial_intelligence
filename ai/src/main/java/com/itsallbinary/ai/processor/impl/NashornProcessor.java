package com.itsallbinary.ai.processor.impl;

import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.itsallbinary.ai.memory.data.Behavior;
import com.itsallbinary.ai.processor.ProcessingException;
import com.itsallbinary.ai.processor.Processor;

public class NashornProcessor implements Processor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itsallbinary.ai.processor.IProcessor#process(com.itsallbinary.ai.
	 * memory.data.Behavior, java.util.List)
	 */
	@Override
	public Object process(Behavior behavior, List<String> inputs) throws ProcessingException {

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		String nashornFunction = "function " + behavior.getName() + "(";

		for (int i = 0; i < behavior.getNumberOfInputsNeeded(); i++) {
			nashornFunction = nashornFunction + "i" + i;
			if (i < (behavior.getNumberOfInputsNeeded() - 1)) {
				nashornFunction = nashornFunction + ",";
			}
		}
		nashornFunction = nashornFunction + ")" + " { " + behavior.getBehavior() + " }";

		System.out.println("Function = " + nashornFunction);
		Object result;
		try {
			engine.eval(nashornFunction);

			Invocable inv = (Invocable) engine;

			result = inv.invokeFunction(behavior.getName(), inputs.toArray());

		} catch (ScriptException | NoSuchMethodException e) {
			throw new ProcessingException(e);
		}

		return result;

	}

}
