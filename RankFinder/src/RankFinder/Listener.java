package RankFinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import RankFinder.RankFind;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Listener implements ActionListener {
	RFGui mygui;
	String name;
	Boolean CanPick = false;
	String[] arr;
	Timer metronome;
	int time = 120;
	int server = 1;
	
	public Listener()
	{
		metronome = new Timer(1000, this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = "";
		
		
		if (arg0.getSource() instanceof JButton)
		{

			JButton clicked = (JButton) arg0.getSource();
			if (clicked.getText().equals("Update") && CanPick)
			{
				try {
					RankFind.download(server);
					arr = RankFind.update(mygui.user.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				mygui.XP.setText("XP to Next Rank: " + arr[6]);
				mygui.rank.setText("Current Rank: " + arr[1]);
				mygui.revalidate();
				mygui.repaint();
				
			}
			
			if (clicked.getText().equals("Change League"))
			{
				String options[] = new String[4];
				options[0] = "Legacy";
				options[1] = "SSF Legacy";
				options[2] = "Hardcore Legacy";
				options[3] = "SSF Hardcore Legacy";
				
				int choice = JOptionPane.showOptionDialog(null, "Pick a League", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, 0);
				
				switch (choice)
				{
				case 0:
					server = 1;
					mygui.title.setText("Legacy Rank Finder");
				case 1:
					server = 2;
					mygui.title.setText("SSF Legacy Rank Finder");
				case 2:
					server = 3;
					mygui.title.setText("Hardcore Legacy Rank Finder");
				case 3:
					server = 4;
					mygui.title.setText("SSF Hardcore Legacy Rank Finder");
				}
				
			}
			
			else if (clicked.getText().equals("Set Player"))
			{
				CanPick = true;
				name = JOptionPane.showInputDialog("Please Enter a Player Name");
				mygui.user.setText(name);
			}
			
			if (clicked.getText().equals("Auto Update"))
			{
				try {
					RankFind.download(server);
					arr = RankFind.update(mygui.user.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				mygui.XP.setText("XP to Next Rank: " + arr[6]);
				mygui.rank.setText("Current Rank: " + arr[1]);
				mygui.revalidate();
				mygui.repaint();
				
				mygui.AutoUpdate.setText("Stop");
				metronome.start();
				mygui.revalidate();
				mygui.repaint();
			}
			
			else if (clicked.getText().equals("Stop"))
			{
				mygui.AutoUpdate.setText("Auto Update");
				metronome.stop();
				mygui.revalidate();
				mygui.repaint();
			}
		}
		
		if (arg0.getSource() instanceof Timer)
		{
			if (time == 0)
				{
				time = 120;
				try {
					RankFind.download(server);
					arr = RankFind.update(mygui.user.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				mygui.XP.setText("XP to Next Rank: " + arr[6]);
				mygui.rank.setText("Current Rank: " + arr[1]);
				mygui.revalidate();
				mygui.repaint();
			}
			
			mygui.clock.setText("Next update in: " + time);
			time--;
			mygui.revalidate();
			mygui.repaint();
			
			
		}
	}
	
	public void setgui(RFGui mygui)
	{
		this.mygui = mygui;
	}

}
