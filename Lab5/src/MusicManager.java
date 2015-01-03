import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.net.URL;

public class MusicManager implements MusicManagerInterface
{
	private MusicList musicList; 
	
	// Constructs the music list
	public MusicManager()
	{
		// Ask user if the file is on disk or on the web
		System.out.print("Enter D for disk or W for web: ");
		
		Scanner inScanner = new Scanner(System.in);
		String input = inScanner.nextLine().toLowerCase();
		
		MusicFile musicFile = new MusicFile();
		
		if (input.charAt(0) == 'd')
		{
			// Reading file from disk
			try
			{
				musicFile.open("music.txt");
			}
			catch (IOException e)
			{
				System.out.print("Error 404: File not found!");
				musicFile.close();
				return;
			}			
		}
		else if (input.charAt(0) == 'w')
		{
			// Reading from Web
			try
			{
				musicFile.open("http://www.ics.uci.edu/~rkwang/Fall_2014_ICS45J/LabManual/Lab5/music.txt");
			}
			catch (IOException e)
			{
				System.out.print("Error 404: URL not found: " + e.getMessage());
				musicFile.close();
			}
			catch (Exception e)
			{
				System.out.print("Error opening file: " + e.getMessage());
			}
			
		}
		else
		{
			// Unspecified value
			// Exit with an error message
			System.out.print("Wrong input! Please enter D for disk or W for web!");
		}
		
		// Create new music list
		musicList = new MusicList();
		
		// Add items to music list from input file
		while (musicFile.hasMoreItems())
		{
			// Read a line
			ArrayList<String> items =  musicFile.readItem();
			
			// Construct MusicItem object
			MusicItem musicItem;
			String mediaType = items.get(MusicItem.MEDIA_CODE_POSITION);
			
			if (mediaType.equalsIgnoreCase(MusicItem.COMPACT))
			{
				musicItem = new CompactItem(items);
			}
			else if (mediaType.equalsIgnoreCase(MusicItem.PAPER))
			{
				musicItem = new PaperItem(items);
			}
			else if (mediaType.equalsIgnoreCase(MusicItem.VINYL))
			{
				musicItem = new VinylItem(items);
			}
			else
			{
				musicItem = new WaxItem(items);
			}
			
			musicList.addItem(musicItem);
			
//			System.out.println(musicItem.getTitle());
//			System.out.println(musicItem.getAccessionNumber());
//			System.out.println(musicItem.getMedia());
		}
		
		// Close file
		musicFile.close();
	}
	
	// Prepares an index file from an incoming list of music items;
	// displays to the screen the media category counts
	// and a total count of items processed.
	public void makeIndexAndDisplayCounts()
	{
		// Write to file
		IndexFile indexFile = new IndexFile();
		try
		{
			indexFile.open("index.txt");
		}
		catch (IOException e)
		{
			System.out.print("Error writing to file: " + e.getMessage());
			indexFile.close();
		}

		// Iterate over buckets
		for (Bucket bucket : musicList.getBuckets())
		{
			for (MusicItem musicItem : bucket.getItems())
			{
				// Write music item nicely to the outfile
				indexFile.writeItem(musicItem);
			}
		}

		// Close outFile
		indexFile.close();
		
		System.out.println("\nWriten output to file: index.txt\n");
		System.out.println("Total Paper Media item count: " + musicList.getPaperItemCount());
		System.out.println("Total Compact Media item count: " + musicList.getCompactMediaItemCount());
		System.out.println("Total Vinyl Media item count: " + musicList.getVinylItemCount());
		System.out.println("Total WaxCylinder Media item count: " + musicList.getWaxCylinderItemCount());
		System.out.println("Total Media Item count: " + musicList.getTotalItemCount());
	}
}
