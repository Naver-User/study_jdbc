package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import lombok.Cleanup;


public class ObjectInputOutputStreamExample {
	
	
	// 1���̻��� Wrapper Type ��ü�� ����ȭ/������ȭ ����
	public static void main(String[] args) throws Exception {
		// 1. ��ü�� ����ȭ�ؼ� ������ ���Ͽ� ���� �⺻��Ʈ�� ����
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. ��ü�� ����ȭ/������ȭ �����ϴ� ������Ʈ�� ����
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);		
		
		// 3. 1�� �̻��� �⺻Ÿ�Ժ� ����Ÿ�� ��ü�� ����ȭ
		oos.writeObject(10);	// ����ڽ����� �ڵ���ü ����
		oos.writeObject(3.14);	// ����ڽ����� �ڵ���ü ����
		oos.writeObject(new int[] { 1, 2, 3 });	// �迭��ü ����
		oos.writeObject(new String("ȫ�浿"));
		
		oos.flush();	// ����flush
		
		// -------------------------
		// ��ü�� ������ȭ�� ����, �� ���Ͽ� ����� ������ ��ü�� ����
		// -------------------------
		
		// 1. ������ȭ�� ���Ͽ� ���� �⺻��Ʈ�� ����
		@Cleanup FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		
		// 2. ��ü�� ������ȭ�� �����ϴ� ������Ʈ�� ����
		@Cleanup ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 3. ���Ͽ� ����� ��ü��, ������ ������� �� ��ü�� ����
		Integer obj1 = (Integer) ois.readObject();	// <--- ***
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[]) ois.readObject();
		String obj4 = (String) ois.readObject();
		
		// 4. 3���� ��ü�ϴ� �ڵ��, ������ ����ȯ
//		Object obj = ois.readObject();
//		if(obj instanceof Integer integer) {
//			// ������ ��������ȯ
//		} // if
		
		// ----------------------
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(Arrays.toString(obj3));
		System.out.println(obj4);
	} // main
	
} // end class
