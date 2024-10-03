package sec04.exam04_file_writer;

import java.io.File;
import java.io.FileWriter;

import lombok.Cleanup;


public class FileWriterExample {
	
	// ���ڱ���� ��½�Ʈ�� Writer�� �̿��ؼ�, ��������� �غ���!!!
	public static void main(String[] args) throws Exception {
		// File Ÿ���� ó������.
		File file = new File("C:/Temp/test.txt");	
		
		// ��½�Ʈ��: ����Ʈ/���ڱ���̵�, �̸� �˰��־�� �Ѵ�:
		//  (1) ������ ����� ������ ������ -> ���� ����
		//  (2) ������ ����� ������ ������ -> ���������� ��� ���� ����, ó������ �ٽþ���
		@Cleanup FileWriter fw = new FileWriter(file, true);	// true: append (�߰�)
		
		// ���ڿ� �״�� ��¹��ۿ� ��°���
		fw.write("�ƴϷ��Ӥ�����98����7��9��799������9 " + "\r\n");
		fw.write("896������������!@#$$$%^**((" + "\r\n");
		
		fw.flush();
		
		System.out.println("ǥ�����");
		System.err.println("ǥ�ؿ���");
		
	} // main
}

