package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class NonSerializableParentExample3 {
	
	// Case3: 
	public static void main(String[] args) throws Exception {
		log.trace("main({}) invoked.", Arrays.toString(args));
		
		// 1. ���Ͽ� ���� �⺻ ��½�Ʈ�� ����
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. �⺻��Ʈ���� ���� ��ü��º�����Ʈ�� ����
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 3. �ڽİ�ü ���� > ��ü�� ����ȭ ���� 
		Child3 child = new Child3();
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
		
		Child3 restoredChild = (Child3) ois.readObject();
		System.out.println(restoredChild);
		System.out.println(restoredChild.field1);
	} // main
	
} // end class

