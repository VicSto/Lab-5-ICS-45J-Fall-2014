import java.util.ArrayList;

public class CompactItem extends MusicItem
{
	private int trackCount;
	private int releaseYear;
	
	public CompactItem(ArrayList<String> item)
	{
		super(item);
		trackCount = Integer.parseInt(item.get(3));
		releaseYear = Integer.parseInt(item.get(4));
	}
	
	public String displaySupplementalInfo()
	{
		return "# of tracks: " + trackCount + " | Year released: "+ releaseYear;
	}
}
