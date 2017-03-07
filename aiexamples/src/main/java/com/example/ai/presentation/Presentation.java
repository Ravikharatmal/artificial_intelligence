package com.example.ai.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Presentation {

	public String takeInput(String message) {
		System.out.println(message);
		Scanner reader = new Scanner(System.in);
		return reader.nextLine();

	}

	public void showOutput(String message) {
		System.out.println(message);
	}

	public String[] takeBehaviorAsInput() {

		String name = takeInput("What is name of behavior?");

		String numberOfInputs = takeInput("How many inputs does it need?");

		String behavior = takeInput("What the implementation of behavior?");

		return new String[] { name, numberOfInputs, behavior };

	}

	public List<String> getInputsForBehavior(int numberOfInputsNeeded) {
		List<String> inputs = new ArrayList<>();

		for (int i = 0; i < numberOfInputsNeeded; i++) {
			String input = takeInput("Give input number " + i);
			inputs.add(input);
		}
		return inputs;
	}

	public boolean wantToContinue() {

		String wantToContinue = takeInput("Want to continue? (1 = Yes, 0 = No) ");
		boolean shouldContinue = wantToContinue.equalsIgnoreCase("1");

		return shouldContinue;

	}

	public void sayGoodBye() {
		showOutput("Goodbye ! See you again !");
	}
}
