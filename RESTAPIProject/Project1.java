import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Scanner;
import com.google.gson.*;

public class Project1
{
	public static void main(String [] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		// Ask you user which city/zip they want to find the weather for
		
		System.out.print("Enter a city or zipcode: ");
		String userCity = input.nextLine();
		String tempFahrenheit = getWeather(userCity);
		
		System.out.println(tempFahrenheit);
	}
	
	static String getWeather(String userCity) throws IOException 
	{
		
		String resURL;
		
		// Create the API "endpoint" that you will need to hit by incorporating what the city name/zipcode
		
		resURL = ("https://api.openweathermap.org/data/2.5/weather?q=" + userCity + "&APPID=659342907c24d4a4de2938481dcc762d");
				
		// Create URL Object and HTTPURLConnection Object, using that object to create a GET Request
				
		URL url = new URL(resURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization","659342907c24d4a4de2938481dcc762d");
				
		// Create a BufferReader to read the connection inputStream
				
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while((inputLine = in.readLine()) != null)
		{
			content.append(inputLine);
		}
		in.close();
				
		con.disconnect();
				
		// Parse the JSON - call a custom function to parse the JSON response
				
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(content.toString()).getAsJsonObject();
		double temp = obj.getAsJsonObject("main").getAsJsonPrimitive("temp").getAsDouble();
		double low = obj.getAsJsonObject("main").getAsJsonPrimitive("temp_min").getAsDouble();
		double high = obj.getAsJsonObject("main").getAsJsonPrimitive("temp_max").getAsDouble();
				
		// Converting temp amount in JSON to Fahrenheit
				
		double tempFahrenheit = ((temp - 273.15) * (9.0/5) + 32);
		double tempLowFahrenheit = ((low - 273.15) * (9.0/5) + 32);
		double tempHighFahrenheit = ((high - 273.15) * (9.0/5) + 32);
		DecimalFormat df = new DecimalFormat("##.##");
		
		return "The weather is going to be " + df.format(tempFahrenheit) + " with a high of " + df.format(tempHighFahrenheit) + " and a low of " + df.format(tempLowFahrenheit);
	}
	
}