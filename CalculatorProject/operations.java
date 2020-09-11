import java.math.*;
import java.util.*;

public class operations {

	// creating the data structures used to process inputs
	
	private Stack<String> operationStack = new Stack<String>();
	private Stack<String> evaluateStack = new Stack<String>();
	private Queue<String> evalulateQueue = new LinkedList<String>();
	private Queue<String> finalQueue = new LinkedList<String>();
	
	// creating private helper functions to improve readability 
	
	// isPair() will determine if the function is unbalanced or balanced
	private boolean isPair(StringBuilder input) {
		boolean isPair = false;
		Stack<String> balancedStack = new Stack<String>();
		
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) =='(')
			{
				char tempVal = input.charAt(i);
				balancedStack.push(Character.toString(tempVal));
			}
			else if(input.charAt(i) ==')')
			{
				balancedStack.pop();
			}
		}
		
		if(balancedStack.empty() == true)
		{
			isPair = true;
		}
		
		return isPair;
	}
	
	// isLeftParen() will determine if the input is a left parenthesis
	private boolean isLeftParen(char input)
	{
		boolean isLeftParen = false;
		
		if(input == '(')
		{
			isLeftParen = true;
		}
		
		return isLeftParen;
	}
	
	// isRightParen() will determine if the input is a right parenthesis
	private boolean isRightParen(char input)
		{
			boolean isRightParen = false;
			
			if(input == ')')
			{
				isRightParen = true;
			}
			
			return isRightParen;
		}
	
	// isOperator() will determine if the input is an operator
	private boolean isOperator(char input) {
		boolean isOperator = false;
		
		if((input == '+') || (input == '-') || (input == '*') || (input == '/'))
		{
			isOperator = true;
		}
		
		return isOperator;
	}
	
	// isNumber() will determine if the input is a digit or hex value
	private boolean isNumber(char input) {
		boolean isNumber = false;
		
		if((input >= 48) && (input <= 57))
		{
			isNumber = true;
		}
		else if((input >= 65) && (input <= 70))
		{
			isNumber = true;
		}
		
		
		return isNumber;
	}
	
	// precedence() will determine if the incoming char complies with PEMDAS
	private boolean precedence(String input) {
		boolean complies = true;
		
		if(((input.equals("+")) || (input.equals("-"))) && (operationStack.empty() == false))
		{
			if((operationStack.peek().equals("*")) || (operationStack.peek().equals("/")))
			{
				complies = false;
			}
		}
		
		return complies;
	}
	
	// hexConversion() will convert hex to decimal to make the algorithm easier to run
	private StringBuilder hexConversion(StringBuilder input) {
		StringBuilder finalRes = new StringBuilder();
		String currentVal = "";
		char tempVal = ' ';
		
		for(int i = 0; i < input.length(); i++)
		{
			
			tempVal = input.charAt(i);
			
			if(isOperator(input.charAt(i)) == false)
			{
				currentVal = currentVal + Character.toString(tempVal);
			}
			else
			{
				System.out.println(currentVal);
				String digits = "0123456789ABCDEF";
				int val = 0;
				for(int j = 0; j < currentVal.length(); j++)
				{
					char c = currentVal.charAt(j);
					int d = digits.indexOf(c);
					val = 16 * val + d;
				}
				
				finalRes.append(val + Character.toString(tempVal));
				currentVal = "";
			}
		}
		
		// converting the last currentVal
		
		System.out.println(currentVal);
		String digits = "0123456789ABCDEF";
		int val = 0;
		for(int j = 0; j < currentVal.length(); j++)
		{
			char c = currentVal.charAt(j);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		
		finalRes.append(val);
		
		
		return finalRes;
	}
	
	// binConversion() will convert binary to decimal to make the algorithm easier to run
	private StringBuilder binConversion(StringBuilder input) {
		StringBuilder finalres = new StringBuilder();
		String currentVal = "";
		char tempVal = ' ';
		
		for(int i = 0; i < input.length(); i++)
		{
			
			tempVal = input.charAt(i);
			
			if(isOperator(input.charAt(i)) == false)
			{
				currentVal = currentVal + Character.toString(tempVal);
			}
			else
			{
				int val = Integer.parseInt(currentVal,2);
				
				finalres.append(val + Character.toString(tempVal));
			}
		}
		
		// converting the last currentVal
		
		int val = Integer.parseInt(currentVal,2);
		
		finalres.append(val);
		
		return finalres;
	}
	
	// octConversion() will convert octal to decimal to make the algorithm easier to run
	private StringBuilder octConversion(StringBuilder input) {
		StringBuilder finalres = new StringBuilder();
		String currentVal = "";
		char tempVal = ' ';
		
		for(int i = 0; i < input.length(); i++)
		{
			
			tempVal = input.charAt(i);
			
			if(isOperator(input.charAt(i)) == false)
			{
				currentVal = currentVal + Character.toString(tempVal);
			}
			else
			{
				int val = Integer.parseInt(currentVal,8);
				
				finalres.append(val + Character.toString(tempVal));
			}
		}
		
		// converting the last currentVal
		
		int val = Integer.parseInt(currentVal,8);
		
		finalres.append(val);
		
		return finalres;
	}
	
	// creating constructor for operations file, taking equation and processing
	
	operations(StringBuilder input, int currentMode)
	{
		
		char tempVal = ' ';
		
		if(isPair(input) == true) {
			
			// determining which mode the input is set to and converting to decimal to make it easier 
			
			if(currentMode == 1)
			{
				input = hexConversion(input);
			}
			else if(currentMode == 3)
			{
				input = binConversion(input);
			}
			else if(currentMode == 4)
			{
				input = octConversion(input);
			}
			else if(currentMode != 2)
			{
				System.out.println("Error, invalid input mode");
			}
			
			for(int i = 0; i < input.length(); i++)
			{
				tempVal = input.charAt(i);
				
					if(isNumber(input.charAt(i)) == true)
					{
						evalulateQueue.add(Character.toString(tempVal));
					}
					else if((isOperator(input.charAt(i)) == true) || (isLeftParen(input.charAt(i)) == true) || (isRightParen(input.charAt(i)) == true))
					{
						if(isLeftParen(input.charAt(i)))
						{
							operationStack.push(Character.toString(tempVal));
						}
						else if ((isRightParen(input.charAt(i))) == true)
						{
							
							while (operationStack.empty() == false)
							{
								
								String temp = operationStack.peek();
								
								if(temp.equals("("))
								{
									break;
								}
								else
								{
									evalulateQueue.add(temp);
									operationStack.pop();
								}
							}
							
							operationStack.pop();
						}
						else if(precedence(Character.toString(tempVal)))
						{
							operationStack.push(Character.toString(tempVal));
						}
						else
						{
							while(precedence(Character.toString(tempVal)) == false)
							{
								String temp = operationStack.peek();
								operationStack.pop();
								evalulateQueue.add(temp);
							}
							
							operationStack.push(Character.toString(tempVal));
						}
					}
					else
					{
						System.out.println("An error has occured, invalid input values");
					}
			}
		}
		else
		{
			System.out.println("An error has occured, invalid input values");
		}
		
		// moving operation stack to evaluation queue
		
		while(operationStack.empty() != true)
		{
			String movingVal = operationStack.peek();
			evalulateQueue.add(movingVal);
			operationStack.pop();
		}
		
		// test 
		
		System.out.println("$$$$$$$$$$");
		for(String item: evalulateQueue) {
			System.out.print(item);
		}
		System.out.println("\n$$$$$$$$$$");
		
		// converting post-fix notation to the final result
		
		while(evalulateQueue.isEmpty() != true)
		{
			String currentNum = evalulateQueue.peek();
			System.out.println(currentNum);
			
			// if its an operator, popping two numbers from evaluate stack to evaluate
			if((isOperator(currentNum.charAt(0))) && (evaluateStack.size() > 0))
			{
				String firstNum = evaluateStack.pop();
				String secondNum = evaluateStack.pop();
				double addedRes;
				
				// evaluating and pushing into the final queue
				
				switch (currentNum) {
					case "+": 
						addedRes = Double.parseDouble(secondNum) + Double.parseDouble(firstNum);
						if(finalQueue.size() > 0)
						{
							double newRes = Double.parseDouble(finalQueue.peek()) + addedRes;
							finalQueue.remove();
							finalQueue.add(Double.toString(newRes));
						}
						else
						{
							finalQueue.add(Double.toString(addedRes));
						}
						System.out.println(finalQueue.peek());
						break;
					case "-":
						addedRes = Double.parseDouble(secondNum) - Double.parseDouble(firstNum);
						if(finalQueue.size() > 0)
						{
							double newRes = Double.parseDouble(finalQueue.peek()) + addedRes;
							finalQueue.remove();
							finalQueue.add(Double.toString(newRes));
						}
						else
						{
							finalQueue.add(Double.toString(addedRes));
						}
						System.out.println(finalQueue.peek());
						break;
					case "*":
						addedRes = Double.parseDouble(secondNum) * Double.parseDouble(firstNum);
						if(finalQueue.size() > 0)
						{
							double newRes = Double.parseDouble(finalQueue.peek()) + addedRes;
							finalQueue.remove();
							finalQueue.add(Double.toString(newRes));
						}
						else
						{
							finalQueue.add(Double.toString(addedRes));
						}
						System.out.println(finalQueue.peek());
						break;
					case "/":
						addedRes = Double.parseDouble(secondNum) / Double.parseDouble(firstNum);
						if(finalQueue.size() > 0)
						{
							double newRes = Double.parseDouble(finalQueue.peek()) + addedRes;
							finalQueue.remove();
							finalQueue.add(Double.toString(newRes));
						}
						else
						{
							finalQueue.add(Double.toString(addedRes));
						}
						System.out.println(finalQueue.peek());
					default:
						System.out.println("Error, invalid operation");
						break;
				
				}
			}
			// if its a number, pushing it on the evaluate stack to be operated on
			else if (isNumber(currentNum.charAt(0)))
			{
				evaluateStack.push(currentNum);
			}
			else
			{
				System.out.println("Error, invalid input into final queue");
			}
			
			// removing the last item in the queue
			
			evalulateQueue.remove();
			
		}
	}
	
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("(5*4+3*2)-1");
		operations test1 = new operations(str, 2);
	}
}
