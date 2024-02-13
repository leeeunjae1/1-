package project;

import java.sql.ResultSet;
import java.util.Scanner;

public class viewData {
	
	stmt s = new stmt();
	
	void viewData() {
	    try {
	        Scanner in = new Scanner(System.in);
	        System.out.println("== user 테이블 조회 ==");
	        System.out.println("조회할 테이블을 입력하시오: ");
	        String searchtable = in.nextLine();
	        if(searchtable.equals("book001")) {
	            String viewStr1 = "SELECT * FROM " + searchtable;
	            ResultSet result1 = stmt.stmt.executeQuery(viewStr1);

	            System.out.println("bookid\tbookname\tpublisher\tauthor");
	            while(result1.next()) {
	                System.out.print(result1.getInt("bookid") + "\t" + result1.getString("bookname")
	                                 + "\t\t" + result1.getString("publisher") + "\t" + result1.getString("author") +"\n");
	            }
	            
	            System.out.println("");
	            System.out.println("데이터 조회 성공!");
	        } else if(searchtable.equals("rental")) {
	            String viewStr1 = "SELECT custid, custname, phone, address  FROM " + searchtable;
	            ResultSet result1 = stmt.stmt.executeQuery(viewStr1);

	            System.out.println("custid\tcustname\tphone\taddress");
	            while(result1.next()) {
	                System.out.print(result1.getInt("custid") + "\t" + result1.getString("custname") + "\t" + result1.getString("phone")
	                                 + "\t"+ result1.getString("address")  +"\n");
	            }
	            
	            System.out.println("");
	            System.out.println("데이터 조회 성공!");
	        }
	    } catch(Exception e) {
	        System.out.println("데이터 조회 실패 이유 : " + e.toString());
	    }
	}

}
