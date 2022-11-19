package musicDb;

import java.sql.Connection;

import musicDb.dao.DbConnection;

public class musicDb {

public static void main(String[] args) {
	Connection conn = DbConnection.getConnection();
}
}