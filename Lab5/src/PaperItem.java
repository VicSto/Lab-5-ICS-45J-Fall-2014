import java.util.ArrayList;

public class PaperItem extends MusicItem
{
	private int pagesCount;
	
	public PaperItem(ArrayList<String> item)
	{
		super(item);
		pagesCount = Integer.parseInt(item.get(3));
	}
	
	public String displaySupplementalInfo()
	{
		return "# of pages: "+ pagesCount;
	}
}
