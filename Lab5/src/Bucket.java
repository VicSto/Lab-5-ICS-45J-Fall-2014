import java.util.LinkedList;


public class Bucket implements BucketInterface
{
	LinkedList<MusicItem> items;

	public Bucket()
	{
		this.items = new LinkedList<MusicItem>();
	}
	
	// Add the music item into the this bucket, 
	// in alphabetical order by title
	public void addItem(MusicItem itemToAdd)
	{
		for (int i = 0; i < items.size(); i++)
		{
            MusicItem item = items.get(i);
            
            // Check if string to add is less than current string.
            // If it is, add current string before such string
            if (itemToAdd.getTitle().compareTo(item.getTitle()) < 0)
            {
            	items.add(i, itemToAdd);
            	return;
            }
        }
		
		items.add(itemToAdd);
	}

		
	// Accessor -- get the list
	public LinkedList<MusicItem> getItems()
	{
		return this.items;
	}
}
