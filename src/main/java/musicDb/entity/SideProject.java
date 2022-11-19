package musicDb.entity;

public class SideProject {
	private Integer sideProjectId;
	private Integer artistId;
	private String sideProjectName;
	
	public Integer getSideProjectId() {
		return sideProjectId;
	}
	public void setSideProjectId(Integer sideProjectId) {
		this.sideProjectId = sideProjectId;
	}
	public Integer getArtistId() {
		return artistId;
	}
	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}
	public String toString() {
		return "Id=" + sideProjectId + ", sideProjectName=" + sideProjectName;
	}
	public String getSideProjectName() {
		return sideProjectName;
	}
	public void setSideProjectName(String sideProjectName) {
		this.sideProjectName = sideProjectName;
	}
}
