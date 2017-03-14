package RankFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

public class RankFind {
	
	
	public static void download(int server) throws IOException
	{
		if (server == 1)
		{
			URL website = new URL("https://www.pathofexile.com/ladder/export-csv/league/Legacy/index/1");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("ladder.csv");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		}
		if (server == 2)
		{
			URL website = new URL("https://www.pathofexile.com/ladder/export-csv/league/SSF%20Legacy/index/1");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("ladder.csv");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		}
		if (server == 3)
		{
			URL website = new URL("https://www.pathofexile.com/ladder/export-csv/league/Hardcore%20Legacy/index/1");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("ladder.csv");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		}
		if (server == 4)
		{
			URL website = new URL("https://www.pathofexile.com/ladder/export-csv/league/SSF%20HC%20Legacy/index/1");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("ladder.csv");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		}
		
	}
	
	public static String[] update(String name) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File("ladder.csv")));
		
		br.readLine();
		String input = "";
		String[] output = null;
		
		boolean kgo = true;
		double value = 0;
		
		for(int x = 0;x < 2000; x++)
		{
			input = br.readLine();
			String[] arr = input.split(",");
			
			if (arr[3].equals(name))
			{
				arr[6] = Double.toString(value - Double.parseDouble(arr[6]));
				output = arr;
			}
			else
			{
				value = Double.parseDouble(arr[6]);
			}
			
		}
		
		return output;
	}

}
