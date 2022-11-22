package musicDb.entity;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Artist {
	private Integer artistId;
	private String artistName;
	private Integer initialFormation;
	private Double artistRating;
	private String notes;
	private Boolean active; 
	
	private List<Album> albums = new LinkedList<>();
	private List<SideProject> sideProjects = new LinkedList<>();
	private List<Genre> genres = new LinkedList<>();
	
	public String toString() {
		String artist = "";
		
		artist += "\n   ID=" + artistId;
		artist += "\n   artistName=" + artistName;
		artist += "\n   initialFormation=" + initialFormation;
		artist += "\n   artistRating=" + artistRating;
		artist += "\n   notes=" + notes;
		artist += "\n   active=" + active;
		
		artist += "\n   Albums:";
		
		for(Album album : albums) {
			artist += "\n   " + album;
		}
		
		artist +="\n   Side Projects:";
		
		for(SideProject sideproject : sideProjects) {
			artist += "\n   " + sideproject;
		}
		
		artist += "\n   Genre:";
		
		for(Genre genre : genres) {
			artist += "\n   " + genre;
		}
		
		return artist;
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

	public Integer getInitialFormation() {
		return initialFormation;
	}

	public void setInitialFormation(Integer initialFormation) {
		this.initialFormation = initialFormation;
	}

	public Double getArtistRating() {
		return artistRating;
	}

	public void setArtistRating(Double artistRating) {
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

