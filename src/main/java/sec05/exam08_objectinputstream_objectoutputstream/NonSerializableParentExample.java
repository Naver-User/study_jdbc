package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.Cleanup;


public class NonSerializableParentExample {
	
	// Case1: 부모는 Non-serializable, 자식만 Serializable 경우
	//        객체의 직렬화/역직렬화 > 오로지 자식객체만 되고, 부모객체는 불가
	//                                 오류가 나지는 않는다
	//        자식객체만 직렬화/역직렬화 된다!!!
	public static void main(String[] args) throws Exception {
		// 1. 파일에 대한 기본 출력스트림 생성
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. 기본스트림에 대한 객체출력보조스트림 생성
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 3. 자식객체 생성 > 객체의 직렬화 수행 
		Child child = new Child();
		child.field1 = "홍길동";	// 상속받은 필드 초기화
		child.field2 = "홍삼원";	// 자식고유 필드 초기화
		
		// 4. 자식객체의 직렬화 및 파일에 출력
		oos.writeObject(child);
		
		oos.flush();		// 강제flush
		
		// --------------------
		// 파일에 저장된 자식객체를 역직렬화 및 복원
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

