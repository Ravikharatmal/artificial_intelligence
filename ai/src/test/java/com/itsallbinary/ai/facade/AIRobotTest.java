package com.itsallbinary.ai.facade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class AIRobotTest {

	AIRobot subject;

	@Before
	public void setUp() throws Exception {
		subject = new AIRobot();
	}

	@Test
	public void memorizeData_shouldConvertToJson() {
		// subject.memorizeData("{\"ravi\":\"test\"}");
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(
				"{   \"glossary\": {       \"title\": \"example glossary\",		\"GlossDiv\": {           \"title\": \"S\",			\"GlossList\": {               \"GlossEntry\": {                   \"ID\": \"SGML\",					\"SortAs\": \"SGML\",					\"GlossTerm\": \"Standard Generalized Markup Language\",					\"Acronym\": \"SGML\",					\"Abbrev\": \"ISO 8879:1986\",					\"GlossDef\": {                       \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",						\"GlossSeeAlso\": [\"GML\", \"XML\"]                   },					\"GlossSee\": \"markup\"               }           }       }   }}");
	
		System.out.println(element.getAsJsonObject().get("title"));
	
	}

}
