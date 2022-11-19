package musicDb.entity;

import java.time.Year;

public class Album {
	private Integer albumId;
	private Integer artistId;
	private String albumName;
	private Year releaseDate;
	private Integer albumRating;
	private String albumNotes;
	
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public Integer getArtistId() {
		return artistId;
	}
	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Year getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Year releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getAlbumRating() {
		return albumRating;
	}
	public void setAlbumRating(Integer albumRating) {
		this.albumRating = albumRating;
	}
	public String toString() {
		return "Id=" + albumId + ", albumNotes=" + albumNotes;
	}
	public String getAlbumNotes() {
		return albumNotes;
	}
	public void setAlbumNotes(String albumNotes) {
		this.albumNotes = albumNotes;
	}
}
