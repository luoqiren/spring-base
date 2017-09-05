package com.lqr.spring.spel;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test001 {

	public static void main(String[] args) throws ScriptException, NoSuchMethodException {
		javaEl();
		javaScriptEl();
	}

	private static void javaScriptEl() throws ScriptException, NoSuchMethodException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
		String scriptText = "function sum(a,b) {return a+b;}";
		
		scriptEngine.eval(scriptText);
		
		Invocable invocable = (Invocable) scriptEngine;
		
		Object result = invocable.invokeFunction("sum", 100, 10);
		System.out.println("javascript:" + result.toString());
		
	}

	private static void javaEl() {
		ExpressionParser expressionParser = new SpelExpressionParser();
		Expression expression = expressionParser.parseExpression("'Java: Hello ' + 'World'.concat('!')");
		
		String value = expression.getValue(String.class);
		
		System.out.println(value);		
	}

}
