package sec01.exam0;

public class main {
	public static void dbwork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
	}

	public static void main(String[] args) {
		dbwork(new OracleDao());
		dbwork(new MysqlDao());
		
	}

}
