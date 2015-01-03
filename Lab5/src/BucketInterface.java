// BucketInterface.java
// ICS 45J Lab Assignment 5
//
// Coded by Norman Jacobson, August 2012


import java.util.LinkedList;

// A bucket contains an alphabetical list, by title, of 
// music items. 
interface BucketInterface
{
	// A bucket is a LinkedList of MusicItem items
	// public Bucket()
	
	
	// Add the music item into the this bucket, 
	// in alphabetical order by title
	public void addItem(MusicItem itemToAdd);

	
	// Accessor -- get the list
	public LinkedList<MusicItem> getItems();
}
