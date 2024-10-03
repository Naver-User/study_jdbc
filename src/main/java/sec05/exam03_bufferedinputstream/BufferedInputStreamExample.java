package sec05.exam03_bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import lombok.Cleanup;


public class BufferedInputStreamExample {
	
	// �⺻��/��½�Ʈ���� �����������Ʈ������ BufferedInput/OutputStream,
	// BufferedReader/Writer �� �̿��Ͽ�, ��/��� ������ ��������ϴ� ����� �����!!
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		// ----- ù��°�� ������Ʈ���� ����ȵǰ�, �⺻��Ʈ�������� �Է¼���
		{
			@Cleanup FileInputStream fis1 = 
						new FileInputStream("C:/temp/OracleXE213_Win64.zip");
			
			start = System.currentTimeMillis();		// ���۽ð� ����
			
				// (1) �⺻��Ʈ�����κ���, �� ����Ʈ�� �д� ���
				while(fis1.read() != -1); // �о ����Ʈ�� �ϴ� ���� ����
				
			end = System.currentTimeMillis();
			
			System.out.println("1. ������� �ʾ��� ��: " + (end - start) + "ms");			
		} // ��������Ǻ��1
		
		{
			@Cleanup FileInputStream fis2 = 
				new FileInputStream("C:/temp/OracleXE213_Win64.zip");
			
			// ������� ������Ʈ���� ����
			@Cleanup BufferedInputStream bis = 
				new BufferedInputStream(fis2);
			
			start = System.currentTimeMillis();

				// (1) �⺻��Ʈ�����κ���, �� ����Ʈ�� �д� ���
				while(bis.read() != -1); // �о ����Ʈ�� �ϴ� ���� ����
				
			end = System.currentTimeMillis();
			System.out.println("2. ������� ��: " + (end-start) + "ms");			
		} // ��������Ǻ��2
		
	} // main

	
} // end class

