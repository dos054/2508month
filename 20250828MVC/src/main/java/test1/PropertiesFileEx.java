package test1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileEx {

	public static void main(String[] args) {
		Properties props = new Properties();
		
		//propertiers 파일 로드
		try (FileInputStream fis = new FileInputStream("C:\\_dev5\\workspace\\20250828MVC\\src\\main\\java\\test1\\example.properties")){
			props.load(fis);	//파일에서 설정을 불러옵니다.
			System.out.println("Loades from file:");
			System.out.println("DB Host: "+ props.getProperty("db.host"));
			System.out.println("DB Port: "+ props.getProperty("db.port"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
