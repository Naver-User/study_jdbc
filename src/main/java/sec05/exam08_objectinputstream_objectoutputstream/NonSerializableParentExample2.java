package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.Cleanup;


public class NonSerializableParentExample2 {
	
	// Case2: �θ� Serializable, �ڽ��� Non-serializable ���
	//        ���: �θ�Ÿ���� Serializable�ϸ� -> �ڽİ� �ļտ��Ե�
	//              Serializable ������ "���"�ǰ�, �׷��� �ڽ�/�ļտ��Ե�
	//              �����ϰ� serialVersionUID �ʵ� ������ �ϵ��� ��� �������ϴ�.
	//              ���������, �θ�/�ڽ� ��ü ��� �� ����ȭ/������ȭ�� �˴ϴ�.
	public static void main(String[] args) throws Exception {
		// 1. ���Ͽ� ���� �⺻ ��½�Ʈ�� ����
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. �⺻��Ʈ���� ���� ��ü��º�����Ʈ�� ����
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 3. �ڽİ�ü ���� > ��ü�� ����ȭ ���� 
		Child2 child = new Child2();
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
		
		Child2 restoredChild = (Child2) ois.readObject();
		System.out.println(restoredChild);
		System.out.println(restoredChild.field1);
	} // main
	
} // end class

