package sec03.exam02_console;

import java.io.Console;


//@Log4j2
public class ConsoleExample {
	
	public static void main(String[] args) {
		// System.console �����޼ҵ�� ��ü�� ����ϴ�.
		Console console = System.console();
		System.out.println("1. console: {}" + console);
		
		System.out.print("���̵�: ");
		String id = console.readLine();	// �ַܼκ���, ���̵� �Է¹���
		System.out.println("2. id: {}" + id);
		
		System.out.print("�н�����: ");
		// �ַܼκ���, ��ȣ�� �Է¹���. �̶� ��ȣ�� ** ��ǥ�÷� ����
		char[] charPass = console.readPassword();	
		
		String strPassword = new String(charPass);
		System.out.println("3. strPassword: {}" + strPassword);
		
		System.out.println("---------------------");
		System.out.println(id);
		System.out.println(strPassword);
	} // main
	
} // end class

