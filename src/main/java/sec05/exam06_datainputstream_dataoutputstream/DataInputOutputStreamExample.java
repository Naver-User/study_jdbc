package sec05.exam06_datainputstream_dataoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import lombok.Cleanup;


public class DataInputOutputStreamExample {
	
	
	public static void main(String[] args) throws Exception {
		// �⺻��Ʈ�� ����
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.dat");
		
		// ������ ��� ������Ʈ�� ����
		@Cleanup DataOutputStream dos = new DataOutputStream(fos);
		
		// �⺻Ÿ�Ժ����Ǵ� �� �״�� ����� �����ϰ� ���ݴϴ�.
		
		// 1st. data
		dos.writeUTF("ȫ�浿");		// ���ڿ� ���
		dos.writeDouble(95.5);		// �Ǽ� ���
		dos.writeInt(1);			// ���� ���
		
		// 2nd. data
		dos.writeUTF("���ڹ�");		// ���ڿ� ���
		dos.writeDouble(90.3);		// �Ǽ� ���
		dos.writeInt(2);			// ���� ���
		
		dos.flush(); 				// ����flush
		
		// --------------
		
		// ������ ���� ����Ʈ ��� �Է� �⺻��Ʈ�� ����
		@Cleanup FileInputStream fis = new FileInputStream("C:/Temp/primitive.dat");
		// ������ ������Ʈ�� ����
		@Cleanup DataInputStream dis = new DataInputStream(fis);
		
		// 2����� �����͸� �о���ϴ�.
		// (�߿�) ������ �翬�� ó������ �н��ϴ�.
		for(int i=0; i<2; i++) {
			String name = dis.readUTF();		// �̸� 
			double score = dis.readDouble();	// �Ǽ�
			int order = dis.readInt();			// ����
			
			if(i == 1) {
				System.out.println(name + " : " + score + " : " + order);
			} // if-else
			
		} // for
	} // main
	
}

