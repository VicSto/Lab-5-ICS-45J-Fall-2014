import java.util.ArrayList;

public class VinylItem extends MusicItem
{
	private String recordLabel;
	private int playSpeed;
	
	public VinylItem(ArrayList<String> item)
	{
		super(item);
		recordLabel = item.get(3);
		playSpeed = Integer.parseInt(item.get(4));
	}
	
	public String displaySupplementalInfo()
	{
		return "Label: " + recordLabel + " | RPM: "+ playSpeed;
	}
}

