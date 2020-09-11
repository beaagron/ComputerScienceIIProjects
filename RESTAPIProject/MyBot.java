import java.io.IOException;
import org.jibble.pircbot.*;

public class MyBot extends PircBot {
    
    public MyBot() {
        this.setName("test156");
    }
    
    public void onMessage(String channel, String sender, String login, String hostname, String message)
	{
    	
    	// if the user types a message related to the weather
    	
    	if ((message.contains("weather")) || (message.contains("Weather"))) 
    	{
    		
    		// finding the last word as the keyword for the weather API
    		
    		String userCity = "";
    		
    		for(int i = message.length() - 1; i > 0; i--)
    		{
    			if(message.charAt(i) == ' ')
    			{
    				break;
    			}
    			else
    			{
    				userCity = message.charAt(i) + userCity;
    			}
    		}
    		
    		try {
				sendMessage(channel, Project1.getWeather(userCity));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	} 
    	
    	// if the user types a greeting such as hello
    	
    	if (message.contains("Hello")) 
    	{

    		sendMessage(channel, "Hey " + sender + "! ");

    	} 
    	
    	// if the user types a message regarding kanye
    	
    	if(message.contains("kanye"))
    	{
    		try {
				sendMessage(channel, Kanye.getKanye());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	}
}