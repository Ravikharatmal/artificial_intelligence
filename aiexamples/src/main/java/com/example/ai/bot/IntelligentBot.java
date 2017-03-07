package com.example.ai.bot;

import java.util.ArrayList;
import java.util.List;

import com.example.ai.presentation.Presentation;
import com.itsallbinary.ai.facade.AIException;
import com.itsallbinary.ai.facade.AIRobot;

public class IntelligentBot {

	Presentation presentation;

	AIRobot aiRobot;

	public IntelligentBot(Presentation presentation) {
		this.presentation = presentation;
		aiRobot = new AIRobot();
	}

	public void startBot() throws AIException {

		boolean shouldContinue;

		do {

			shouldContinue = false;

			if (!aiRobot.getKnownBehaviors().isEmpty()) {
				presentation.showOutput("What you want me to do?");

				List<String> topics = new ArrayList<>(aiRobot.getKnownBehaviors());
				for (int i = 0; i < topics.size(); i++) {
					presentation.showOutput(i + " = " + topics.get(i));
				}
				presentation.showOutput(topics.size() + " = Teach something new");
				presentation.showOutput((topics.size() + 1) + " = Exit");
				String selectedTopic = presentation.takeInput("Enter number for topic");
				int index = Integer.parseInt(selectedTopic);
				if (index == topics.size()) {
					learn();
				} else if (index == (topics.size() + 1)) {
					exit();
				} else {

					Object result = aiRobot.processBehavior(topics.get(index), presentation
							.getInputsForBehavior(aiRobot.getNumberOfInputsForBehavior(topics.get(index))));
					presentation.showOutput("Result = " + result);
				}

			} else {
				learn();

			}

			shouldContinue = presentation.wantToContinue();
			if (!shouldContinue) {
				exit();
			}

		} while (shouldContinue);
	}

	private void exit() {
		presentation.sayGoodBye();
		System.exit(0);
	}

	private void learn() throws AIException {

		presentation.showOutput("Teach Me");
		String[] behavior = presentation.takeBehaviorAsInput();
		aiRobot.teachBehavior(behavior[0], Integer.parseInt(behavior[1]), behavior[2]);
		presentation.showOutput("Thanks !");

	}
}
