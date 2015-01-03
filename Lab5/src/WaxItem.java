
import java.util.ArrayList;

public class WaxItem extends MusicItem
{
	private String maker;
	
	public WaxItem(ArrayList<String> item)
	{
		super(item);
		maker = item.get(3);
	}
	
	public String displaySupplementalInfo()
	{
		return "Maker: " + maker;
	}
}
