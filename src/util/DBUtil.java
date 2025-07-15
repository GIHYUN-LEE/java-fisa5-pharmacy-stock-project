/* 24시간 365일 실행되는 서버의 실행 코드라 간주
 * - 요청 수와 무관하게 최초 단 한 번만 1회성으로 공유자원 초기화 하는 공통 코드로 간주
 * - db의 driver로딩 로직
 * - 시스템 다운 방지를 위한 리소스 최적화
 * 	: Connection 수는 절대 제한 (유한 자원)
 * - web server 내부에서 설정으로 db server시스템 동시 접속 수 제어 예정
 * - Connection Pool기법 (CP)
 * - Connection 제공, 회수 하는 주체 필요 (javax.sql.DataSource가 할 예정)
 * 
 * 결론
 * 		- driver 로딩 한 번만 실행 보장
 * 		- Connection 객제 반환하는 로직
 * 		- DB의 설정 정보는 별도의 key로 db 접속 정보 매핑해서 properties 파일로 분리
 * 			파일로 분리 
 * 		- 참고
 * 			: 설정 정보를 코드에서 분리하는 원조가 JDBC 
 * 			 -Spring엣선 deafault 파일로 활용 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// 파일로 부터 1byte 단위로 read 하는 기능
import java.io.FileInputStream;
import java.util.Properties;

// properties 피알로 key에서 value로 쏙쏙 뽑는 기능


/*	DBUtil은 편집 불가능한 구조 권장
 * 
 */
public class DBUtil {
	// key로 value값 활용시에만 사용하는 API
	private static Properties dbInfo = new Properties();
	
	private DBUtil() {}
	
	static {
		// 존재하는 파일로 부터 자바 코드로 read하는 API
		try {
			dbInfo.load(new FileInputStream("dbinfo.properties"));
			Class.forName(dbInfo.getProperty("jdbc.driver"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(	dbInfo.getProperty("jdbc.url"),	
											dbInfo.getProperty("jdbc.id"), 	
											dbInfo.getProperty("jdbc.pw"));
	}
	
	// 자원 반환 필수(query)
	/* 예외처리는 내부에서 or 외부에서 처리가 가능함
	 * 내부에서 처리 : 굳이 사용자에게 예외처리된 내용을 알려주지 않아도 됨
	 * 		ex) 자원 반환 같은 내용의 예외처리는 사용자가 몰라도됨 
	 * 외부에서 처리 : 사용자에게 예외 처리된 내용을 알려주어야함
	 * 		ex) 사용자가 쿼리를 날렸을 때 문제가 생겼다면 어떤 문제인지 알수 있도록 예외 처리 해야함
	 */
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	// 자원 반환 필수 (insert/ update / delete)
	public static void close(Connection conn, Statement stmt) {

		try {

			if (stmt != null) {
				stmt.close();
				stmt = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static void main(String [] args) {
		try {
			System.out.println(getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
