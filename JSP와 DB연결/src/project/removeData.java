package project;

import java.util.Scanner;

public class removeData {
	
	stmt s = new stmt();

	void removeData() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.print("쿼리를 삭제할 테이블을 입력하세요 >> ");
			s.tableName = in.nextLine();
			
			System.out.println("삭제할 쿼리의 bookid를 입력하세요 >> ");
			int num = in.nextInt();
			
			String removeStr = "DELETE FROM " + s.tableName + " where bookid='"+ num + "'";
			stmt.stmt.executeUpdate(removeStr);
			System.out.println("데이터 삭제 성공!");
		} catch(Exception e) {
			System.out.println("데이터 삭제 실패 이유 : " + e.toString());
		}
	}
	
}
