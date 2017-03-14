package RankFinder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JFrame;

import RankFinder.Listener;
import RankFinder.RFGui;

public class RankFinderApp {

	public static void main(String[] args) {

		RFGui mygui = new RFGui();
		
		Listener mylistener = new Listener();
		
		mygui.setlistener(mylistener);
		mylistener.setgui(mygui);
		
		mygui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
