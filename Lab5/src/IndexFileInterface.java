// IndexFileInterface.java
// ICS 45J Lab Assignment 5
//
// Coded by Norman Jacobson, August 2012

// Sets up requirements for open, write,
// and close routines for the index file.
// Note it does not specify that file's location,
// so the implementing class is free to place
// the file where needed

import java.io.IOException;

public interface IndexFileInterface
{
	// public IndexFile()
	
	// Open index file with name indexFileName
	// for sequential writing
	//
	// Opens a sequential text file to accept 
	// output; prints out report headings
	//
	// Throws IOException if index file cannot
	// be opened or other IO problems occur
	public void open(String indexFileName) throws IOException;

	// Writes out the current line of the report,
	// contained in itemToWrite
	public void writeItem(MusicItem itemToWrite);

	
	// closes the index file
	public void close();

}