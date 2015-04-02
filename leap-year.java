
import javax.swing.*;

public class LeapYearFinal
{

//****************************************************************************************************************
//
// This program prompts the user to enter a year that it will then check to determine whether the year is or
// is not a leap year. This program took forever to work out, as the logic kept getting mixed up. I think this
// version finally DOES work properly for all user input.
//
//****************************************************************************************************************
// OTHER NOTES:
//
// I have made the entire program a "do-loop." That way,
// the user doesn't have to run the program anew each time he wants to check a year.
// I've also added a "while-loop" to make sure the program will continue running properly (instead of just ending)
// if the first year the user enters is invalid -- i.e., less than 1582. 
//
// I only added comments where I thought the code might be confusing: in particular, where the logic gets tricky. I 
// think the comments may help in understanding where the conditions of the "if-" and "else-" statements/blocks
// begin and end, and to which ones they belong. I tried to indent properly also, so that might help avoid confusion
// as well...
//
//*****************************************************************************************************************

	public static void main (String[] args)
	{

		final int GREG_START = 1582;
		int year, again;

		do
		{
			
			String input = JOptionPane.showInputDialog(null, "Please enter the year you'd like to check for "
			+ "leap-year status:", "Is it a leap year?", JOptionPane.PLAIN_MESSAGE);		
			year = Integer.parseInt(input);
		
			while (year < GREG_START)
			{
				JOptionPane.showMessageDialog(null, "Oops! The year you entered is less than 1582, the "
				+ "start of the Gregorian calendar. \nThis program only works for checking years during"
				+ " which the Gregorian calendar is in effect.", "Error!", JOptionPane.ERROR_MESSAGE);		
		
				String input2 = JOptionPane.showInputDialog(null, "Please enter a year after 1581: ", 
				"Shall we try this again...?", JOptionPane.PLAIN_MESSAGE);
			
				year = Integer.parseInt(input2);
			}
			
			if (year >= GREG_START)
						
			{//Begin if-1: (year >= GREG_START)
				if (year % 4 == 0)
						
				{//Begin if-2: (year % 4 == 0)
					if (year % 100 == 0)
									
					{//Begin if-3: (year % 100 == 0)
						if (year % 400 == 0)
						
						{//Begin if-4: (year % 400 == 0)		
							JOptionPane.showMessageDialog(null, "The year " + year + " IS, in fact, a leap year...",
							"Hooray!", JOptionPane.INFORMATION_MESSAGE);							
						}//End if-4: (year % 400 == 0)
											
					else
						JOptionPane.showMessageDialog(null, "The year " + year + " is NOT a leap year...",
						"Oh well...", JOptionPane.INFORMATION_MESSAGE);
					}//End if-3: (year % 100 == 0)
					
				else
					JOptionPane.showMessageDialog(null, "The year " + year + " IS, in fact, a leap year...",
					"Hooray!", JOptionPane.INFORMATION_MESSAGE);				
				}//End if-2: (year % 4 == 0)
				
			else
				JOptionPane.showMessageDialog(null, "The year " + year + " is NOT a leap year...",
				"Oh well...", JOptionPane.INFORMATION_MESSAGE);
			}//End if-1: year >= GREG_START
	
			
		again = JOptionPane.showConfirmDialog(null, "Would you like to check another year?", 
		"Play it again, Sam!", JOptionPane.YES_NO_OPTION);
		}//End do-loop
		
		while (again == JOptionPane.YES_OPTION);
		
	}
	
}
