package com.itsallbinary.ai;

import java.util.function.Function;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {

	public static void main(String[] args) throws ScriptException {
		String[] data = {"1","2"};
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		@SuppressWarnings("unchecked")
		Function<Object, Object> f = (Function<Object, Object>) engine
				.eval(String.format("new java.util.function.Function(%s)", "function(x) 3 * x + 1"));
		for (int i = 1; i < data.length; i++) {
			System.out.println(f.apply(data[i]));
		}
	}

}
