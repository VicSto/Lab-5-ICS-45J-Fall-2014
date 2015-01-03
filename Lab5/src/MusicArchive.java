// MusicArchive.java
// ICS 45J Lab Assignment 5
//
// Coded by Norman Jacobson, August 2012
// Based on code from ICS 21, Summer 2009 version

// Make a manager and turn it loose!
public class MusicArchive
{
	public static void main(String[] args)
	{
		MusicManager musicManager = new MusicManager();
		musicManager.makeIndexAndDisplayCounts();
	}
}
