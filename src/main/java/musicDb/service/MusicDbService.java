package musicDb.service;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import musicDb.dao.MusicDbDao;
import musicDb.entity.Artist;
import musicDb.exception.DbException;

public class MusicDbService {
	private static final String SCHEMA_FILE = "musicdb_schema.sql";
	private static final String DATA_FILE = "musicdb_data.sql";
	
	
	private MusicDbDao musicDbDao = new MusicDbDao();
		
	public Artist insertArtist(Artist artist) {
		return musicDbDao.insertArtist(artist);
	}

	public void createAndPopulateTables() {
		loadFromFile(SCHEMA_FILE);
		loadFromFile(DATA_FILE);
	}
	private void loadFromFile(String fileName) {
		String content = readFileContent(fileName);
		List<String> sqlStatements = convertContentToSqlStatements(content);
		musicDbDao.executeBatch(sqlStatements);
	}

	private List<String> convertContentToSqlStatements(String content) {
		content = removeComments(content);
		content = replaceWhitespaceSequencesWithSingleSpace(content);
		
		return extractLinesFromContent(content);
	}

	private String readFileContent(String fileName) {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
			return Files.readString(path);
		} catch (Exception e) {
			throw new DbException(e);
		}
	}
}
