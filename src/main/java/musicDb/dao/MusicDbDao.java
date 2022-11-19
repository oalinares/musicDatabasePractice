package musicDb.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import musicDb.musicDb;
import musicDb.entity.Artist;
import musicDb.dao.DbConnection;
import musicDb.exception.DbException;
import provided.util.DaoBase;

public class MusicDbDao extends DaoBase {
	private static final String MUSICDB_TABLE = "musicdb";
	private static final String ARTIST_TABLE = "artist";
	private static final String ALBUM_TABLE = "album";
	private static final String GENRE_TABLE = "genre";
	private static final String SIDEPROJECT_TABLE = "sideproject";
	private static final String GENRE_MUSICDB_TABLE = "artist_genre";
	private static final String GENRE_ALBUM_TABLE = "album_genre";

/**
 * Inserts the Artist including the name, formation of band or solo date, a rating of the 
 * artist, notes about the style and general idea about them, and last if they are still 
 * active and playing
 * @param artist
 * @return 
 */
public Artist insertArtist(Artist artist) {
	// @formatter:off
	String sql = ""
			+ "INSERT INTO " + ARTIST_TABLE + " "
			+ "(artist_name, initial_formation, artist_rating, notes, active) "
			+ "VALUES "
			+ "(?, ?, ?, ?, ?)";
	// @formatter:on
	try(Connection conn = DbConnection.getConnection()) {
		startTransaction(conn);
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			setParameter(stmt, 1, artist.getArtistName(), String.class);
			setParameter(stmt, 2, artist.getInitialFormation(), Time.class);
			setParameter(stmt, 3, artist.getArtistRating(), BigDecimal.class);
			setParameter(stmt, 4, artist.getNotes(), String.class);
			setParameter(stmt, 5, artist.getActive(), Boolean.class);
			
			stmt.executeUpdate();
			
			Integer artistId = getLastInsertId(conn, ARTIST_TABLE);
			commitTransaction(conn);
			artist.setArtistId(artistId);
			return artist;
		} catch(Exception e) {
			rollbackTransaction(conn);
			throw new DbException(e);
		}
	} catch(SQLException e) {
		throw new DbException(e);
	}
}

}
	