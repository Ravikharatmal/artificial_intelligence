package com.example.ai.main;

import com.example.ai.bot.IntelligentBot;
import com.example.ai.presentation.Presentation;
import com.itsallbinary.ai.facade.AIException;

public class Main {

	public static void main(String[] args) throws AIException {
		IntelligentBot intelligentBot = new IntelligentBot(new Presentation());
		intelligentBot.startBot();
	}

}
