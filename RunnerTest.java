package demo.tests;

import static org.junit.jupiter.api.Assertions.*;
//Project package
import art.controller.Runner;

//Reflection needs
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RunnerTest
{
	private Runner testedRunner;

	@BeforeEach
	void setUp() throws Exception
	{
		testedRunner = new Runner();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		testedRunner = null;
	}

	@Test
	void testMain()
	{
		try
		{
			Method[] runnerMethods = Class.forName("Runner").getDeclaredMethods();
			assertTrue(runnerMethods.length == 1, "There should only be 1 method in your Runner class");
			assertTrue(runnerMethods[0].getParameterCount() == 1, "The method should only have 1 parameter");
			Type [] types = runnerMethods[0].getGenericParameterTypes();
			assertTrue(runnerMethods[0].getName().equals("main"), "The only method should be main!");
			int returnType = runnerMethods[0].getModifiers();
			assertTrue(returnType == Modifier.STATIC, "The main method needs to be static!");
			assertTrue(runnerMethods[0].getReturnType().equals(Void.TYPE), "The main method needs to a void method!");
			assertTrue(types[0].getTypeName().equals("java.lang.String[]") , "The parameter type needs to be: String []");
			
		}
		catch (SecurityException error)
		{
			
		}
		catch (ClassNotFoundException oops)
		{
			System.out.println("The Runner class needs to exist!");
		}
		
				
	}

}
