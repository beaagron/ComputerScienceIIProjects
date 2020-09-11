import java.awt.*;
import javax.swing.*;

public class newLabel extends JLabel{

	private GridBagConstraints gbc;
	
	// constructor 
	
	newLabel(JPanel panel, String labelInput, GridBagConstraints gbcObjects, int x, int y, int width, int height)
	{
		gbc = gbcObjects;
		setName(labelInput);
		setText(labelInput);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 15;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(this, gbc);
	}
	
	// constructor that uses StringBuilder parameter
	
	newLabel(JPanel panel, StringBuilder labelInput, GridBagConstraints gbcObjects, int x, int y, int width, int height)
	{
		gbc = gbcObjects;
		setName(labelInput.toString());
		setText(labelInput.toString());
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = 15;
		//gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(this, gbc);
	}
}