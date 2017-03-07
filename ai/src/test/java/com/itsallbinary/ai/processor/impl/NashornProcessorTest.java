package com.itsallbinary.ai.processor.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.itsallbinary.ai.facade.AIRobot;
import com.itsallbinary.ai.memory.data.Behavior;

public class NashornProcessorTest {

	NashornProcessor subject;

	@Before
	public void setUp() throws Exception {
		subject = new NashornProcessor();
	}

	@Test
	public void testProcess() throws Exception {

		// Given
		Behavior behavior = new Behavior("multiply", 2, "return i0 * i1");
		List<String> inputs = new ArrayList<>();
		inputs.add("3");
		inputs.add("4");

		// When
		Object result = subject.process(behavior, inputs);

		// Then
		assertThat(result).isEqualTo(12d);

	}

}
