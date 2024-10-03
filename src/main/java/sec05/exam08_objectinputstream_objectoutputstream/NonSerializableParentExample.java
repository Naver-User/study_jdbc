package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.Cleanup;


public class NonSerializableParentExample {
	
	// Case1: �θ�� Non-serializable, �ڽĸ� Serializable ���
	//        ��ü�� ����ȭ/������ȭ > ������ �ڽİ�ü�� �ǰ�, �θ�ü�� �Ұ�
	//                                 ������ ������ �ʴ´�
	//        �ڽİ�ü�� ����ȭ/������ȭ �ȴ�!!!
	public static void main(String[] args) throws Exception {
		// 1. ���Ͽ� ���� �⺻ ��½�Ʈ�� ����
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. �⺻��Ʈ���� ���� ��ü��º�����Ʈ�� ����
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 3. �ڽİ�ü ���� > ��ü�� ����ȭ ���� 
		Child child = new Child();
		child.field1 = "ȫ�浿";	// ��ӹ��� �ʵ� �ʱ�ȭ
		child.field2 = "ȫ���";	// �ڽİ��� �ʵ� �ʱ�ȭ
		
		// 4. �ڽİ�ü�� ����ȭ �� ���Ͽ� ���
		oos.writeObject(child);
		
		oos.flush();		// ����flush
		
		// --------------------
		// ���Ͽ� ����� �ڽİ�ü�� ������ȭ �� ����
		// --------------------
		
		@Cleanup FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		@Cleanup ObjectInputStream ois = new ObjectInputStream(fis);
		
		Child restoredChild = (Child) ois.readObject();
		System.out.println(restoredChild);
		System.out.println(restoredChild.field1);
		
//		System.out.println("field1: " + v.field1);
//		System.out.println("field2: " + v.field2);
	} // main
	
} // end class

