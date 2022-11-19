DROP TABLE IF EXISTS sideproject;
DROP TABLE IF EXISTS album_genre;
DROP TABLE IF EXISTS musicdb_genre;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS musicdb;

CREATE TABLE musicdb (
	artist_id INT AUTO_INCREMENT NOT NULL,
	artist_name VARCHAR(128) NOT NULL,
	initial_formation TIME,
	artist_rating INT,
	notes TEXT,
	active BOOLEAN,
	PRIMARY KEY (artist_id)
);

CREATE TABLE genre (
	genre_id INT AUTO_INCREMENT NOT NULL,
	genre_name VARCHAR(64) NOT NULL,
	PRIMARY KEY (genre_id)
);

CREATE TABLE album (
	album_id INT AUTO_INCREMENT NOT NULL,
	artist_id INT NOT NULL,
	album_name VARCHAR(128) NOT NULL,
	release_date TIME NOT NULL,
	album_rating INT NOT NULL,
	album_notes TEXT,
	PRIMARY KEY (album_id)
);

CREATE TABLE musicdb_genre (
	artist_id INT NOT NULL,
	genre_id INT NOT NULL,
	FOREIGN KEY (artist_id) REFERENCES musicdb (artist_id) ON DELETE CASCADE,
	FOREIGN KEY (genre_id) REFERENCES genre (genre_id) ON DELETE CASCADE,
	UNIQUE KEY (artist_id, genre_id)
	
);

CREATE TABLE album_genre (
	album_id INT NOT NULL,
	genre_id INT NOT NULL,
	FOREIGN KEY (album_id) REFERENCES album (album_id) ON DELETE CASCADE,
	FOREIGN KEY (genre_id) REFERENCES genre (genre_id) ON DELETE CASCADE,
	UNIQUE KEY (album_id, genre_id)
	
);

CREATE TABLE sideproject (
	sideproject_id INT AUTO_INCREMENT NOT NULL,
	artist_id INT NOT NULL,
	sideproject_name VARCHAR(64) NOT NULL,
	PRIMARY KEY (sideproject_id),
	FOREIGN KEY (artist_id) REFERENCES musicdb (artist_id) ON DELETE CASCADE
);