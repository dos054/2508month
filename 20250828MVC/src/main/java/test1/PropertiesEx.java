package test1;

import java.util.Properties;

public class PropertiesEx {

	public static void main(String[] args) {
		// 1. Properties 객체 생성
		Properties props = new Properties();
		
		// 2. 키-값 쌍으로 데이터 설정
		props.setProperty("db.driver", "com.mysql.cj.jdbc.Drivet");
		props.setProperty("db.url", "jdbc:mysql://localhost::3306/mydb");
		props.setProperty("db.username", "user");
		props.setProperty("db.password", "password");
		
		// 3. 설정된 값 읽어오기
		String driver = props.getProperty("db.driver");
		String url = props.getProperty("db.url");
		
		System.out.println("DB Driver: "+ driver);
		System.out.println("DB URL: "+ url);
	}

}
