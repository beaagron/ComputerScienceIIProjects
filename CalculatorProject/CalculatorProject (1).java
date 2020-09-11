import java.awt.*;
import javax.swing.*;
import java.math.*;

public class CalculatorProject extends JFrame{
	
	public static JPanel header, operations, conversions, result;
	
	public final int WINDOW_WIDTH = 600, WINDOW_HEIGHT = 700;
	
	public static boolean swap = true;
	
	public static int currentMode = 1;
	
	public static Integer total;
	
	private static newLabel showEquation, displayResultValue, displayHex, displayDeci, displayOct, displayBin;
	
	private static StringBuilder equation, resultValue, hexValue, deciValue, octValue, binValue;
	
	private static newButton lshButton, rshButton, wordButton, aButton, bButton, cButton, dButton, eButton, fButton, 
							 zeroButton, oneButton, twoButton, threeButton, fourButton, 
							 fiveButton, sixButton, sevenButton, eightButton, nineButton;
	
	CalculatorProject() {
		
		equation = new StringBuilder("");
	    hexValue = new StringBuilder("0");
        deciValue = new StringBuilder("0");
        octValue = new StringBuilder("0");
        binValue = new StringBuilder("0");
        resultValue = new StringBuilder("0");
        currentMode = 1;
		
		// creating grid bag layout panels
		
		GridBagConstraints mainPanel = new GridBagConstraints();
		GridBagConstraints headerPanel = new GridBagConstraints();
		
		// creating objects
		
		GridBagConstraints headerObject = new GridBagConstraints();
		GridBagConstraints operationsObject = new GridBagConstraints();
		GridBagConstraints conversionObject = new GridBagConstraints();
		GridBagConstraints resultObject = new GridBagConstraints();
		
		// creating main panel
		
		JPanel mainPanel1 = new JPanel(new GridBagLayout());
		mainPanel.gridx = 0;
		mainPanel.gridy = 0;
		mainPanel.gridheight = 0;
		mainPanel.gridwidth = 0;
		mainPanel.weightx = 1;
		mainPanel.weighty = 1;
		mainPanel.fill = GridBagConstraints.BOTH;
		
		// creating header panel
		
		header = new JPanel();
		header.setLayout(new GridBagLayout());
		headerPanel.gridx = 0;
		headerPanel.gridy = 0;
		headerPanel.gridheight = 1;
		headerPanel.gridwidth = 8;
		headerPanel.weightx = 1;
		headerPanel.weighty = 1;
		headerPanel.fill = GridBagConstraints.BOTH;
		
		// adding the more button/programmer label to the header
		
		newButton moreButton = new newButton(header, "More", headerObject, "0", 0, 0, 1, 1);
		newLabel title = new newLabel(header, "Programmer", headerObject, 1, 0, 1, 1);
		title.setHorizontalAlignment(JLabel.LEFT);
		
		// adding objects to the header panel
		mainPanel1.add(header, headerPanel);
		
		// creating the result panel
		
		result = new JPanel();
		result.setLayout(new GridBagLayout());
		headerPanel.gridx = 1;
		headerPanel.gridy = 1;
		headerPanel.gridheight = 3;
		headerPanel.gridwidth = 6;
		headerPanel.weightx = 1;
		headerPanel.weighty = 1;
		headerPanel.fill = GridBagConstraints.BOTH;
		
		// adding objects to the result panel
		
		showEquation =  new newLabel(result, equation, resultObject, 0, 0, 1, 1);
		//showEquation.setAlignmentX(RIGHT_ALIGNMENT);
		displayResultValue = new newLabel(result, resultValue, resultObject, 0, 1, 1, 2);
		//displayResultValue.setAlignmentX(RIGHT_ALIGNMENT);
		showEquation.setHorizontalAlignment(JLabel.RIGHT);
		displayResultValue.setHorizontalAlignment(JLabel.RIGHT);
		
		// adding objects to the header panel
		mainPanel1.add(result, headerPanel);
		
		// creating conversions panel
		
		conversions = new JPanel();
		conversions.setLayout(new GridBagLayout());
		headerPanel.gridx = 4;
		headerPanel.gridy = 4;
		headerPanel.gridheight = 2;
		headerPanel.gridwidth = 6;
		headerPanel.weightx = 1;
		headerPanel.weighty = 1;
		headerPanel.fill = GridBagConstraints.BOTH;	
		
		// adding conversion buttons
		
		newButton hexButton = new newButton(conversions, "Hex", conversionObject, "hex", 0, 0, 1, 1);
		newButton decButton = new newButton(conversions, "Dec", conversionObject, "dec", 0, 1, 1, 1);
		newButton octButton = new newButton(conversions, "Oct", conversionObject, "oct", 0, 2, 1, 1);
		newButton binButton = new newButton(conversions, "Bin", conversionObject, "bin", 0, 3, 1, 1);
		
		displayHex = new newLabel(conversions, hexValue, conversionObject, 2, 0, 5, 1);
        displayDeci = new newLabel(conversions, deciValue, conversionObject, 2, 1, 5, 1);
        displayOct = new newLabel(conversions, octValue, conversionObject, 2, 2, 5, 1);
        displayBin = new newLabel(conversions, binValue, conversionObject, 2, 3, 5, 1);
        
		// adding objects to the header panel
		mainPanel1.add(conversions, headerPanel);
		
		// creating operations panel
		
		operations = new JPanel();
		operations.setLayout(new GridBagLayout());
		headerPanel.gridx = 0;
		headerPanel.gridy = 6;
		headerPanel.gridheight = 7;
		headerPanel.gridwidth = 10;
		headerPanel.weightx = 1;
		headerPanel.weighty = 1;
		headerPanel.fill = GridBagConstraints.BOTH;
		
		setLayout(new GridBagLayout());
		// adding row 1
		
		newButton des1Button = new newButton(operations, "dots", operationsObject, "0", 0, 0, 1, 1);
		newButton des2Button = new newButton(operations, "dots2", operationsObject, "0", 1, 0, 1, 1);
		wordButton = new newButton(operations, "QWORD", operationsObject, "wordButton", 2, 0, 2, 1);
		newButton msButton = new newButton(operations, "MS", operationsObject, "0", 4, 0, 1, 1);
		newButton mButton = new newButton(operations, "M-", operationsObject, "0", 5, 0, 1, 1);
		
		// adding row 2
		
		lshButton = new newButton(operations, "Lsh", operationsObject, "lsh", 0, 1, 1, 1);
		rshButton = new newButton(operations, "Rsh", operationsObject, "rsh", 1, 1, 1, 1);
		newButton orButton = new newButton(operations, "Or", operationsObject, "0", 2, 1, 1, 1);
		newButton xorButton = new newButton(operations, "Xor", operationsObject, "0", 3, 1, 1, 1);
		newButton notButton = new newButton(operations, "Not", operationsObject, "0", 4, 1, 1, 1);
		newButton AndButton = new newButton(operations, "And", operationsObject, "0", 5, 1, 1, 1);
		
		// adding row 3
		
		newButton secondButton = new newButton(operations, "2nd", operationsObject, "swap", 0, 2, 1, 1);  // does this button do anything?
		newButton modButton = new newButton(operations, "Mod", operationsObject, "%", 1, 2, 1, 1);
		newButton ceButton = new newButton(operations, "CE", operationsObject, "clearEqu", 2, 2, 1, 1);
		newButton clearButton = new newButton(operations, "C", operationsObject, "clearAll", 3, 2, 1, 1);
		newButton backButton = new newButton(operations, "Back", operationsObject, "delete", 4, 2, 1, 1);
		newButton divButton = new newButton(operations, "/", operationsObject, "div", 5, 2, 1, 1);
		
		// adding row 4
		
		aButton = new newButton(operations, "A", operationsObject, "A", 0, 3, 1, 1);
		bButton = new newButton(operations, "B", operationsObject, "B", 1, 3, 1, 1);
		sevenButton = new newButton(operations, "7", operationsObject, "seven", 2, 3, 1, 1);
		eightButton = new newButton(operations, "8", operationsObject, "eight", 3, 3, 1, 1);
		nineButton = new newButton(operations, "9", operationsObject, "nine", 4, 3, 1, 1);
		newButton multButton = new newButton(operations, "*", operationsObject, "mult", 5, 3, 1, 1);
		
		// adding row 5
		
		cButton = new newButton(operations, "C", operationsObject, "C", 0, 4, 1, 1);
		dButton = new newButton(operations, "D", operationsObject, "D", 1, 4, 1, 1);
		fourButton = new newButton(operations, "4", operationsObject, "four", 2, 4, 1, 1);
		fiveButton = new newButton(operations, "5", operationsObject, "five", 3, 4, 1, 1);
		sixButton = new newButton(operations, "6", operationsObject, "six", 4, 4, 1, 1);
		newButton subButton = new newButton(operations, "-", operationsObject, "sub", 5, 4, 1, 1);
		
		// adding row 6
		
		eButton = new newButton(operations, "E", operationsObject, "E", 0, 5, 1, 1);
		fButton = new newButton(operations, "F", operationsObject, "F", 1, 5, 1, 1);
		oneButton = new newButton(operations, "1", operationsObject, "one", 2, 5, 1, 1);
		twoButton = new newButton(operations, "2", operationsObject, "two", 3, 5, 1, 1);
		threeButton = new newButton(operations, "3", operationsObject, "three", 4, 5, 1, 1);
		newButton addButton = new newButton(operations, "+", operationsObject, "add", 5, 5, 1, 1);
		
		// adding row 7
		
		newButton rightparenButton = new newButton(operations, "(", operationsObject, "(", 0, 6, 1, 1);
		newButton leftparenButton = new newButton(operations, ")", operationsObject, ")", 1, 6, 1, 1);
		newButton signButton = new newButton(operations, "+/-", operationsObject, "0", 2, 6, 1, 1);
		zeroButton = new newButton(operations, "0", operationsObject, "zero", 3, 6, 1, 1);
		newButton decimalButton = new newButton(operations, ".", operationsObject, ".", 4, 6, 1, 1);
		newButton equalsButton = new newButton(operations, "=", operationsObject, "=", 5, 6, 1, 1);
		
		// adding panels on to mainPanel
		
		mainPanel1.add(operations, headerPanel);
		
		setTitle("Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLayout(new GridBagLayout());		
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(mainPanel1, mainPanel);	
	}
	
	public static void processInput(String input) {
		
		if(input == "=")
		{
			operations finalres = new operations(equation, currentMode);
			//showEquation.setText(equation.toString());
			showEquation.setText("");
			equation.delete(0 , equation.length());
			equation.append(finalres.toString());
			displayResultValue.setText(equation.toString());
			
			deciValue.replace(0, deciValue.length(), Integer.toString(Integer.parseInt(equation.toString(), 10)));
			displayDeci.setText(deciValue.toString());
			hexValue.replace(0, hexValue.length(), Integer.toHexString(Integer.parseInt(equation.toString(), 10)));
			displayHex.setText(hexValue.toString());
			//deciValue.replace(0, deciValue.length(), Integer.toString(Integer.parseInt(total.toString(), 10)));
			//displayDeci.setText(deciValue.toString());
		}
		else if(input.equals("hex"))
		{
			if(aButton.hasListener() == false) {
				aButton.setListener();
			}
			if(bButton.hasListener() == false) {
				bButton.setListener();
			}
			if(cButton.hasListener() == false) {
				cButton.setListener();
			}
			if(dButton.hasListener() == false) {
				dButton.setListener();
			}
			if(eButton.hasListener() == false) {
				eButton.setListener();
			}
			if(fButton.hasListener() == false) {
				fButton.setListener();
			}
			if(oneButton.hasListener() == false) {
				oneButton.setListener();
			}
			if(twoButton.hasListener() == false) {
				twoButton.setListener();
			}
			if(threeButton.hasListener() == false) {
				threeButton.setListener();
			}
			if(fourButton.hasListener() == false) {
				fourButton.setListener();
			}
			if(fiveButton.hasListener() == false) {
				fiveButton.setListener();
			}
			if(sixButton.hasListener() == false) {
				sixButton.setListener();
			}
			if(sevenButton.hasListener() == false) {
				sevenButton.setListener();
			}
			if(eightButton.hasListener() == false) {
				eightButton.setListener();
			}
			if(nineButton.hasListener() == false) {
				nineButton.setListener();
			}
			currentMode = 1;
		}
		else if(input.equals("dec"))
		{
			if(aButton.hasListener() == true) {
				aButton.setEnabler();
			}
			if(bButton.hasListener() == true) {
				bButton.setEnabler();
			}
			if(cButton.hasListener() == true) {
				cButton.setEnabler();
			}
			if(dButton.hasListener() == true) {
				dButton.setEnabler();
			}
			if(eButton.hasListener() == true) {
				eButton.setEnabler();
			}
			if(fButton.hasListener() == true) {
				fButton.setEnabler();
			}
			if(oneButton.hasListener() == false) {
				oneButton.setListener();
			}
			if(twoButton.hasListener() == false) {
				twoButton.setListener();
			}
			if(threeButton.hasListener() == false) {
				threeButton.setListener();
			}
			if(fourButton.hasListener() == false) {
				fourButton.setListener();
			}
			if(fiveButton.hasListener() == false) {
				fiveButton.setListener();
			}
			if(sixButton.hasListener() == false) {
				sixButton.setListener();
			}
			if(sevenButton.hasListener() == false) {
				sevenButton.setListener();
			}
			if(eightButton.hasListener() == false) {
				eightButton.setListener();
			}
			if(nineButton.hasListener() == false) {
				nineButton.setListener();
			}
			currentMode = 2;
		}
		else if(input.equals("oct"))
		{
			if(aButton.hasListener() == true) {
				aButton.setEnabler();
			}
			if(bButton.hasListener() == true) {
				bButton.setEnabler();
			}
			if(cButton.hasListener() == true) {
				cButton.setEnabler();
			}
			if(dButton.hasListener() == true) {
				dButton.setEnabler();
			}
			if(eButton.hasListener() == true) {
				eButton.setEnabler();
			}
			if(fButton.hasListener() == true) {
				fButton.setEnabler();
			}
			if(oneButton.hasListener() == false) {
				oneButton.setListener();
			}
			if(twoButton.hasListener() == false) {
				twoButton.setListener();
			}
			if(threeButton.hasListener() == false) {
				threeButton.setListener();
			}
			if(fourButton.hasListener() == false) {
				fourButton.setListener();
			}
			if(fiveButton.hasListener() == false) {
				fiveButton.setListener();
			}
			if(sixButton.hasListener() == false) {
				sixButton.setListener();
			}
			if(sevenButton.hasListener() == false) {
				sevenButton.setListener();
			}
			if(eightButton.hasListener() == true) {
				eightButton.setEnabler();
			}
			if(nineButton.hasListener() == true) {
				nineButton.setEnabler();
			}
			
			currentMode = 3;
		}
		else if(input.equals("bin"))
		{
			if(aButton.hasListener() == true) {
				aButton.setEnabler();
			}
			if(bButton.hasListener() == true) {
				bButton.setEnabler();
			}
			if(cButton.hasListener() == true) {
				cButton.setEnabler();
			}
			if(dButton.hasListener() == true) {
				dButton.setEnabler();
			}
			if(eButton.hasListener() == true) {
				eButton.setEnabler();
			}
			if(fButton.hasListener() == true) {
				fButton.setEnabler();
			}
			if(oneButton.hasListener() == false) {
				oneButton.setListener();
			}
			if(twoButton.hasListener() == true) {
				twoButton.setEnabler();
			}
			if(threeButton.hasListener() == true) {
				threeButton.setEnabler();
			}
			if(fourButton.hasListener() == true) {
				fourButton.setEnabler();
			}
			if(fiveButton.hasListener() == true) {
				fiveButton.setEnabler();
			}
			if(sixButton.hasListener() == true) {
				sixButton.setEnabler();
			}
			if(sevenButton.hasListener() == true) {
				sevenButton.setEnabler();
			}
			if(eightButton.hasListener() == true) {
				eightButton.setEnabler();
			}
			if(nineButton.hasListener() == true) {
				nineButton.setEnabler();
			}
			
			currentMode = 4;
		}
		else if(input.equals("word"))
		{
			// limit max input
		}
		else if(input.equals("%"))
		{
			equation.append("%");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("clearEqu"))
		{
			equation.delete(0 , equation.length());
			showEquation.setText(equation.toString());
			displayResultValue.setText("0");
		}
		else if(input.equals("clearAll"))
		{
			equation.delete(0 , equation.length());
			displayResultValue.setText("0");
			//showEquation.setText(equation.toString());
			showEquation.setText("0");
		}
		else if(input.equals("delete"))
		{
			equation.delete(equation.length() - 1,equation.length());
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("div"))
		{
			equation.append("/");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("A"))
		{
			equation.append("A");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("B"))
		{
			equation.append("B");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("seven"))
		{
			equation.append("7");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("eight"))
		{
			equation.append("8");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("nine"))
		{
			equation.append("9");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("mult"))
		{
			equation.append("*");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("C"))
		{
			equation.append("C");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("D"))
		{
			equation.append("D");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("four"))
		{
			equation.append("4");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("five"))
		{
			equation.append("5");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("six"))
		{
			equation.append("6");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("sub"))
		{
			equation.append("-");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("E"))
		{
			equation.append("E");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("F"))
		{
			equation.append("F");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("one"))
		{
			equation.append("1");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("two"))
		{
			equation.append("2");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("three"))
		{
			equation.append("3");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("add"))
		{
			equation.append("+");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("("))
		{
			equation.append("(");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals(")"))
		{
			equation.append(")");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("zero"))
		{
			equation.append("0");
			displayResultValue.setText(equation.toString());
		}
		else if(input.equals("0"))
		{
			System.out.println("button is for display");
		}
		else if(input.equals("swap")) {
			if (swap == true) {
				lshButton.setText("RoL");
                rshButton.setText("RoR");
                swap = false;
            }
            else{
                lshButton.setText("Lsh");
                rshButton.setText("Rsh");
                swap = true;
            }
		}
		else if(input.equals("wordButton")) {
			if (currentMode < 4) {
				currentMode++;
			}
			else {
				currentMode = 1;
			}
			
			switch (currentMode){
            case 1: 
                wordButton.setText("QWord");
                break;
            case 2: 
                wordButton.setText("DWord");
                break;
            case 3: 
                wordButton.setText("Word");
                break;
            case 4: 
                wordButton.setText("Byte");
                break;
			}
		}
		else{
			System.out.println("Error, invalid keyInput");
		}	
	}
	
	public static void main(String[] args) {
		new CalculatorProject();
	}
}