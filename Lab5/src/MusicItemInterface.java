// MusicItemInterface.java
// ICS 45J Lab Assignment 5
//
// Coded by Norman Jacobson, August 2012


import java.util.*;

// MusicItem contains the fields common to all music items:
//	accession number, title, media code
// The class is used as the basis of all music item types,
//	but since there is no non-specific music item, the class
//	is abstract
abstract interface MusicItemInterface
{
	// Category codes
	public static final String PAPER = "P";
	public static final String COMPACT = "C";
	public static final String VINYL = "V";
	public static final String WAX_CYLINDER = "W";

	// ..and where in input array they are located
	public static final int ACCESSION_NUMBER_POSITION = 0;
	public static final int TITLE_POSITION = 1;
	public static final int MEDIA_CODE_POSITION = 2;


	// Construct a music item from item
	// position 0: accession number
	// position 1: title
	// position 2: media code
	// public MusicItem(ArrayList<String> item)

	
	// Force each media type to provide its supplemental
	// information in a form suitable for printing
	public abstract String displaySupplementalInfo();

	// Accessors
	public String getAccessionNumber();
	
	public String getTitle();
	
	public String getMedia();
}