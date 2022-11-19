package musicDb.entity;

import java.time.Year;
import java.util.LinkedList;
import java.util.List;

public class MusicDb {
	private Integer artistId;
	private String artistName;
	private Year initialFormation;
	private Integer artistRating;
	private String notes;
	private Boolean active; 
	
	private List<Album> albums = new LinkedList<>();
	private List<SideProject> sideProjects = new LinkedList<>();
	private List<Genre> genres = new LinkedList<>();
	
	public String toString() {
		String musicdb = "";
		
		musicdb += "\n   ID=" + artistId;
		musicdb += "\n   artistName=" + artistName;
		musicdb += "\n   initialFormation=" + initialFormation;
		musicdb += "\n   artistRating=" + artistRating;
		musicdb += "\n   notes=" + notes;
		musicdb += "\n   active=" + active;
		
		musicdb += "\n   Albums:";
		
		for(Album album : albums) {
			musicdb += "\n   " + album;
		}
		
		musicdb +="\n   Side Projects:";
		
		for(SideProject sideproject : sideProjects) {
			musicdb += "\n   " + sideproject;
		}
		
		musicdb += "\n   Genre:";
		
		for(Genre genre : genres) {
			musicdb += "\n   " + genre;
		}
		
		return musicdb;
		}

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Year getInitialFormation() {
		return initialFormation;
	}

	public void setInitialFormation(Year initialFormation) {
		this.initialFormation = initialFormation;
	}

	public Integer getArtistRating() {
		return artistRating;
	}

	public void setArtistRating(Integer artistRating) {
		this.artistRating = artistRating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Album> getAlbums() {
		return albums;
	}
	
	public List<SideProject> getSideProjects() {
		return sideProjects;
}
	
	public List<Genre> getGenres() {
		return genres;
	}	
}

