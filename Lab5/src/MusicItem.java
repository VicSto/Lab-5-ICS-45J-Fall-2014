import java.util.ArrayList;

public abstract class MusicItem implements MusicItemInterface
{
	private String accessionNumber;
	private String title;
	private String media;
	
	public MusicItem(ArrayList<String> item)
	{
		accessionNumber = item.get(ACCESSION_NUMBER_POSITION);
		title = item.get(TITLE_POSITION);
		media = item.get(MEDIA_CODE_POSITION);
	}
	
	public abstract String displaySupplementalInfo();
	
	public String getAccessionNumber()
	{
		return accessionNumber;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getMedia()
	{
		return media;
	}
}
