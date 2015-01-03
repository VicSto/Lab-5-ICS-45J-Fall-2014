import java.io.PrintWriter;
import java.io.IOException;

public class IndexFile implements IndexFileInterface
{
	// Sets up requirements for open, write,
	// and close routines for the index file.
	// Note it does not specify that file's location,
	// so the implementing class is free to place
	// the file where needed
	private PrintWriter outFile;
	
	public IndexFile()
	{
		
	}
		
	// Open index file with name indexFileName
	// for sequential writing
	//
	// Opens a sequential text file to accept 
	// output; prints out report headings
	//
	// Throws IOException if index file cannot
	// be opened or other IO problems occur
	public void open(String indexFileName) throws IOException
	{
		outFile = new PrintWriter(indexFileName);
		
		// Print header
		outFile.printf("%-50sACCESSION # MEDIA  ADDITIONAL INFORMATION\n", "TITLE");
		outFile.println("--------------------------------");
	}

	// Writes out the current line of the report,
	// contained in itemToWrite
	public void writeItem(MusicItem itemToWrite)
	{
		// Print to outFile
		outFile.printf("%-50s%-11s %s      %s\n", itemToWrite.getTitle(), itemToWrite.getAccessionNumber(), itemToWrite.getMedia(), itemToWrite.displaySupplementalInfo());
	}

	// closes the index file
	public void close()
	{
		outFile.close();
	}
}
