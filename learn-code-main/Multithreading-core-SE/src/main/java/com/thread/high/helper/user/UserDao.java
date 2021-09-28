package com.thread.high.helper.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	public int save(User user) {
		String sql = "insert into user values(?,?,?)";
		System.out.println("Sql : " + sql);

		int row = 0;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmailId());

			row = preparedStatement.executeUpdate();

			System.out.println("Query executed - Rows affected - " + row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	public static void cleanTable() {
		String sql = "truncate table user";
		System.out.println("Sql : " + sql);

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				preparedStatement.execute();

			System.out.println("Query executed - DB cleaned - ");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
