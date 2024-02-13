package project;

import java.util.Scanner;

public class insertData {
	
	stmt s = new stmt();
	
	void insertData() {
	    try {
	        Scanner in = new Scanner(System.in);

	        System.out.println("데이터를 추가할 테이블을 입력해주세요 : ");
	        String tableName = in.nextLine();
	        if(tableName.equals("book001")) {
	            System.out.println("책의 번호를 입력하세요 >> ");
	            int bookid = in.nextInt();

	            in.nextLine();

	            System.out.println("책의 이름을 입력하세요 >>");
	            String bookname = in.nextLine();
	            System.out.println("출판사를 입력하세요 (출판사를 모른다면 null값도 가능합니다.)>> ");
	            String publisher = in.nextLine();
	            System.out.println("책의 저자를 입력하세요 (저자를 모른다면 null값도 가능합니다.) >> ");
	            String author = in.nextLine();

	            String insertStr = "INSERT INTO " + tableName + " VALUES('" + bookid + "', '" + bookname + "', '" + publisher + "', '" + author + "')";
	            stmt.stmt.executeUpdate(insertStr);
	            System.out.println("데이터 추가 성공!");
	            
	        } else if(tableName.equals("rental")) {
	            System.out.println("책의 번호를 입력하세요 >> ");
	            int bookid = in.nextInt();

	            in.nextLine();

	            System.out.println("책의 대여 여부 >>");
	            String rental = in.nextLine();
	            System.out.println("고객 아이디를 입력하세요 >> ");
	            int custid = in.nextInt();
	            in.nextLine();

	            System.out.println("고객 이름을 입력하세요 >> ");
	            String custname = in.nextLine();
	            System.out.println("핸드폰 번호를 입력하세요 >> ");
	            String phone = in.nextLine();
	            System.out.println("주소를 입력하세요 >> ");
	            String address = in.nextLine();

	            String insertStr = "INSERT INTO " + tableName + " VALUES('" + bookid + "', '" + rental + "', '" + custid + "', '" + custname + "', '"
	                    + phone + "', '" + address + "')";
	            stmt.stmt.executeUpdate(insertStr);
	            System.out.println("데이터 추가 성공!");
	        }

	    } catch(Exception e) {
	        System.out.println("데이터 추가 실패 이유 : " + e.toString());
	    }
	}

}
