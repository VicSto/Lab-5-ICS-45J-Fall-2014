import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.URL;
import java.util.*;
import java.io.*;
import java.net.URL;

public class MusicFile implements MusicFileInterface
{
	private Scanner inFile;
	
	public MusicFile()
	{
	}

	// Open index file with name indexFileName
	// for sequential writing
	//
	// Opens a sequential text file to accept 
	// music info and parse it
	//
	// Throws IOException if music file cannot
	// be opened or other IOproblems occur
	public void open(String indexFileName) throws IOException
	{	
		if (indexFileName.equalsIgnoreCase("music.txt"))
		{
			// Opening from file on disk
			inFile = new Scanner(new FileReader(indexFileName));
		}		
		else
		{
			URL url = new URL(indexFileName);
			inFile = new Scanner(url.openStream());
		}
	}

	// Are there more items in the file?
	// true = yes (not at end of file); false otherwise
	public boolean hasMoreItems()
	{
		return inFile.hasNextLine();
	}

	// Read and return one music item, as as ArrayList<String>
	// Number of attributes will varying depending on type of item
	//	read -- but first three are always the same:
	//	accession number, title, media code
	// Hint: Read in a line, then use string tokenizer to break it
	//	into fields, with ";" (and end of string) as the delimiter
	public ArrayList<String> readItem()
	{
		ArrayList<String> items = new ArrayList<String>();
		
		String line = inFile.nextLine();
		
		String[] stringArray = line.split("; ");
		for (String item : stringArray)
		{
			items.add(item);
		}
		
		return items;
	}

	// Close the file
	public void close()
	{
		inFile.close();
	}
}
