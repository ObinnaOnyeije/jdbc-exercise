package jdbcExercise;

import java.sql.*;

public class DatabaseConnection {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sql_exercise";
		Connection conn = DriverManager.getConnection(url, "testAccount", "password");
		try {
			System.out.println(conn);
			
			PreparedStatement statement = conn.prepareStatement("Select * from my_albums");
			
			ResultSet result = statement.executeQuery();
			
			System.out.println("My_Albums:");
			while(result.next()) {
				String id = result.getString("id");
				String albumName = result.getString("album_name");
				String albumArtist = result.getString("album_artist");
				System.out.println(id + ": " + albumArtist + " - " + albumName);
			}
		} finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}

}
