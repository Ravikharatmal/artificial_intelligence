package com.example.hello;

import com.itsallbinary.ai.facade.AIException;
import com.itsallbinary.ai.facade.AIRobot;

public class HelloWorldExample {

	public static void main(String[] args) throws AIException {
		AIRobot aiRobot = new AIRobot();

		aiRobot.teachBehavior("sayHello", "print('Hello !')");

		aiRobot.processBehavior("sayHello");
		
		aiRobot.teachBehavior("getdate", "new Date()");

		System.out.println(aiRobot.processBehavior("getdate"));
		
	}

}
