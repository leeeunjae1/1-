package project;

import java.util.Scanner;

public class changeData {
	
	stmt s = new stmt();
	
	void changeData() {
		try {
			Scanner in = new Scanner(System.in);			
			System.out.println("수정할 데이터 테이블을 입력하시오: ");
			s.tableName = in.nextLine();
			System.out.println("어느 필드를 수정할 것인지 입력하시오: ");
			String field = in.nextLine();
			System.out.println("수정 할 data를 입력하시오: ");
			String updatedate = in.nextLine();
			String changeStr = "UPDATE " + s.tableName + " SET " + field + "= " + updatedate;
			stmt.stmt.executeUpdate(changeStr);
			System.out.println("데이터 변경 성공!");
		} catch(Exception e) {
			System.out.println("데이터 변경 실패 이유 : " + e.toString());
		}
	}


}
