import java.util.ArrayList;

// The list of music items (an ArrayList of 26 cells,
// representing the letters A to Z, with each cell 
// a Bucket that contains a list of MusicItems whose
// title all start with the letter the cell represents,
// and in sorted order by title.

public class MusicList implements MusicListInterface
{

	// Make a bucket for each of the 26 list locations;
	// Set counts of items to zero
	private ArrayList<Bucket> buckets;
	private int totalItemCount;
	private int paperItemCount;
	private int compactMediaItemCount;
	private int vinylItemCount;
	private int waxCylinderItemCount;
	
	public MusicList()
	{
		buckets = new ArrayList<Bucket>();
		
		for (int i = 0; i < BUCKET_COUNT; i++)
		{
			Bucket bucket = new Bucket();
			buckets.add(bucket);
		}
	}
	
	// Add an item into the correct bucket in the list
	// Bucket to use is one corresponding to first letter in title
	// Increment the appropriate media count
	public void addItem(MusicItem item)
	{
		char letter = item.getTitle().toUpperCase().charAt(0);
		
		// Add to proper bucket
		int bucketIndex = letter - A_CHAR_VAL;
		Bucket bucket = buckets.get(bucketIndex);
		bucket.addItem(item);
		
		// Increment count
		totalItemCount += 1;
		
		if (item.getMedia().equalsIgnoreCase(MusicItem.PAPER))
		{
			paperItemCount += 1;
		}
		else if (item.getMedia().equalsIgnoreCase(MusicItem.COMPACT))
		{
			compactMediaItemCount += 1;
		}
		else if (item.getMedia().equalsIgnoreCase(MusicItem.VINYL))
		{
			vinylItemCount += 1;
		}
		else
		{
			waxCylinderItemCount += 1;
		}		
	}
		
	public ArrayList<Bucket> getBuckets()
	{
		return buckets;
	}
		
	public int getTotalItemCount()
	{
		return totalItemCount;
	}
		
	public int getPaperItemCount()
	{
		return paperItemCount;
	}
		
	public int getCompactMediaItemCount()
	{
		return compactMediaItemCount;
	}
		
	public int getVinylItemCount()
	{
		return vinylItemCount;
	}
		
	public int getWaxCylinderItemCount()
	{
		return waxCylinderItemCount;
	}
}
