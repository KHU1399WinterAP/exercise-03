import java.sql.*;
import java.util.Scanner;

public class Main {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/school";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";
	
	private static final Scanner INPUT = new Scanner(System.in);
	
	public static void main(String[] args) {
		try {
			var connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
			
			for (int i = 1; i <= 3; i++) {
				addStudent(connection, i);
				
				System.out.println();
				System.out.println("-".repeat(30));
				System.out.println();
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void addStudent(Connection connection, int index) throws SQLException {
		System.out.println("STUDENT #" + index);
		
		System.out.print("ID   : ");
		var id = INPUT.nextLine();
		
		System.out.print("Name : ");
		var name = INPUT.nextLine();
		
		System.out.print("Phone: ");
		var phone = INPUT.nextLine();
		
		System.out.print("Major: ");
		var major = INPUT.nextLine();
		
		if (id.isBlank() || name.isBlank() || phone.isBlank() || major.isBlank())
			throw new IllegalArgumentException("None of the above fields can be blank!");
		
		var statement = connection.prepareStatement("INSERT INTO student value(?, ?, ?, ?)");
		statement.setString(1, id);
		statement.setString(2, name);
		statement.setString(3, phone);
		statement.setString(4, major);
		
		statement.executeUpdate();
	}
}
