package musicDb.service;

import musicDb.dao.MusicDbDao;
import musicDb.entity.Artist;

public class MusicDbService {
		private MusicDbDao musicDbDao = new MusicDbDao();
		
		public Artist insertArtist(Artist artist) {
			return musicDbDao.insertArtist(artist);
		}
}
