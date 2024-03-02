package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Bean;

public class Dao {
	public Bean Connection(int id) {

				//DB接続用定数
				String DATABASE_NAME = "sample";
				String PROPATIES = "?characterEncoding=UTF-8"; //timezone指定はエラー吐くらしい
//				String URL = "jdbc:mysql://localhost:3306/sample"; //+ DATABASE_NAME;// + PROPATIES;
				String URL = "jdbc:mysql://db:3306/" + DATABASE_NAME + PROPATIES;
				//DB接続用・ユーザ定数
				String USER = "root";
				String PASS = "root";
				Connection connection = null;
				Bean bean= null;
		
				try {
					//MySQL に接続する
					Class.forName("com.mysql.cj.jdbc.Driver");
					//データベースに接続
					connection = DriverManager.getConnection(URL, USER, PASS);
					PreparedStatement pStatement = connection.prepareStatement("SELECT name FROM employees WHERE id = ? ");
					pStatement.setInt(1, id);
					ResultSet rs = pStatement.executeQuery();
					 bean = new Bean();
					
					if (rs.next()) {
						bean.setName(rs.getString("name"));
					}
		
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (connection != null) {
							// データベースを切断
							connection.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return bean;
	}
}
