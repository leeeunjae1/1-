package project;

import java.sql.ResultSet;
import java.util.Scanner;

public class rentalbook {
	
	stmt s = new stmt();
	
	void rentalbook() {
	    try {
	        Scanner in = new Scanner(System.in);
	        System.out.println("== 도서목록 조회 ==");

	        String a = "rental";
	        String searchtable = a;
	        String viewStr1 = "SELECT rental.bookid, rental.rental, book001.bookname " +
	                "FROM rental " +
	                "JOIN book001 ON rental.bookid = book001.bookid";

	        ResultSet result1 = stmt.stmt.executeQuery(viewStr1);

	        System.out.println("bookid\tbookname\trental");
	        while (result1.next()) {
	            System.out.print(result1.getInt("bookid") + "\t" + result1.getString("bookname") + "\t" + result1.getInt("rental")
	        + "\n");
	            System.out.println("=============================================");
	        }

	        System.out.println("대여할 도서목록의 bookid를 입력해주세요 >> ");
	        int wantnum = in.nextInt();

	        result1.beforeFirst();

	        boolean found = false;
	        while (result1.next()) {
	            if (result1.getInt("bookid") == wantnum && result1.getInt("rental") == 1) {
	                String changeStr = "UPDATE " + searchtable + " SET rental = 0 WHERE bookid = " + wantnum;
	                stmt.stmt.executeUpdate(changeStr);
	                System.out.println("책 대여 완료");
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("이미 다른 사람이 대여중인 책 입니다. 대여할 수 없습니다.");
	        }

	    } catch (Exception e) {
	        System.out.println("데이터 변경 실패 이유 : " + e.toString());
	    }
	}		
	
	void returnbook() {
	    try {
	        Scanner in = new Scanner(System.in);
	        System.out.println("== 도서목록 조회 ==");

	        String a = "rental";
	        String searchtable = a;
	        String viewStr1 = "SELECT rental.bookid, rental.rental, book001.bookname " +
	                "FROM rental " +
	                "JOIN book001 ON rental.bookid = book001.bookid";

	        ResultSet result1 = stmt.stmt.executeQuery(viewStr1);

	        System.out.println("bookid\tbookname\trental");
	        while (result1.next()) {
	            System.out.print(result1.getInt("bookid") + "\t" + result1.getString("bookname") + "\t" + result1.getInt("rental")
		        + "\n");
	        }

	        System.out.println("반납할 도서목록의 bookid를 입력해주세요 >> ");
	        int wantnum = in.nextInt();

	        result1.beforeFirst();

	        boolean found = false;
	        while (result1.next()) {
	            if (result1.getInt("bookid") == wantnum && result1.getInt("rental") == 0) {
	                String changeStr = "UPDATE " + searchtable + " SET rental = 1 WHERE bookid = " + wantnum;
	                stmt.stmt.executeUpdate(changeStr);
	                System.out.println("책 반납 완료");
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("이미 반납된 책이거나 존재하지 않는 책입니다. 반납할 수 없습니다.");
	        }

	    } catch (Exception e) {
	        System.out.println("데이터 변경 실패 이유 : " + e.toString());
	    }
	}

}