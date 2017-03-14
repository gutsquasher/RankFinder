package RankFinder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JButton;
import javax.swing.*;

public class RFGui extends JFrame {
	
	Listener l;
	JPanel panel;
	
	JButton update;
	JButton setuser;
	JLabel title;
	JLabel XP;
	JLabel rank;
	JLabel user;
	JLabel clock;
	JButton AutoUpdate;
	JButton pick;
	
	GridBagConstraints Uupdate;
	GridBagConstraints Usetuser;
	GridBagConstraints Uinput;
	GridBagConstraints Utitle;
	GridBagConstraints UXP;
	GridBagConstraints Urank;
	GridBagConstraints Uuser;
	GridBagConstraints Uclock;
	GridBagConstraints UAutoUpdate;
	GridBagConstraints Upick;
	
	
	public RFGui()
	{
		panel = new JPanel();
		//panel.setSize(300,300);
		panel.setPreferredSize(new Dimension(400,300));
		panel.setBackground(Color.white);
		this.getContentPane().add(panel);
		panel.setLayout(new GridBagLayout());
		
		update = new JButton("Update");
		Uupdate = new GridBagConstraints();
		Uupdate.gridx = 2;
		Uupdate.gridy = 2;
		panel.add(update, Uupdate);
		
		user = new JLabel(" ");
		Uuser = new GridBagConstraints();
		Uuser.gridx = 1;
		Uuser.gridy = 1;
		panel.add(user, Uuser);
		
		pick = new JButton("Change League");
		Upick= new GridBagConstraints();
		Upick.gridx = 1;
		Upick.gridy = 7;
		panel.add(pick, Upick);
		
		AutoUpdate = new JButton("Auto Update");
		UAutoUpdate = new GridBagConstraints();
		UAutoUpdate.gridx = 2;
		UAutoUpdate.gridy = 3;
		panel.add(AutoUpdate, UAutoUpdate);
		
		clock = new JLabel("");
		Uclock = new GridBagConstraints();
		Uclock.gridx = 1;
		Uclock.gridy = 4;
		panel.add(clock, Uclock);
		
		setuser = new JButton("Set Player");
		Usetuser = new GridBagConstraints();
		Usetuser.gridx = 1;
		Usetuser.gridy = 5;
		panel.add(setuser, Usetuser);
		
		
		title = new JLabel("Legacy Rank Finder");
		GridBagConstraints Utitle = new GridBagConstraints();
		Utitle.gridx = 1;
		Utitle.gridy = 0;
		panel.add(title, Utitle);
		
		XP = new JLabel("XP to Next Rank:");
		GridBagConstraints UXP = new GridBagConstraints();
		UXP.gridx = 0;
		UXP.gridy = 3;
		panel.add(XP, UXP);
		
		rank = new JLabel("Current Rank: ");
		GridBagConstraints Urank = new GridBagConstraints();
		Urank.gridx = 0;
		Urank.gridy = 2;
		panel.add(rank, Urank);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	public void setlistener(Listener mylistener)
	{
		l = mylistener;
		
		pick.addActionListener(l);
		AutoUpdate.addActionListener(l);
		update.addActionListener(l);
		setuser.addActionListener(l);
	}

}
