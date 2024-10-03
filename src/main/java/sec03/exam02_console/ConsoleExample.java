package sec03.exam02_console;

import java.io.Console;


//@Log4j2
public class ConsoleExample {
	
	public static void main(String[] args) {
		// System.console 정적메소드로 객체를 얻습니다.
		Console console = System.console();
		System.out.println("1. console: {}" + console);
		
		System.out.print("아이디: ");
		String id = console.readLine();	// 콘솔로부터, 아이디를 입력받음
		System.out.println("2. id: {}" + id);
		
		System.out.print("패스워드: ");
		// 콘솔로부터, 암호를 입력받음. 이때 암호는 ** 별표시로 나옴
		char[] charPass = console.readPassword();	
		
		String strPassword = new String(charPass);
		System.out.println("3. strPassword: {}" + strPassword);
		
		System.out.println("---------------------");
		System.out.println(id);
		System.out.println(strPassword);
	} // main
	
} // end class

