package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lombok.Cleanup;


public class NonSerializableParentExample2 {
	
	// Case2: 부모만 Serializable, 자식은 Non-serializable 경우
	//        결론: 부모타입의 Serializable하면 -> 자식과 후손에게도
	//              Serializable 성질이 "상속"되고, 그래서 자식/후손에게도
	//              동일하게 serialVersionUID 필드 선언을 하도록 경고가 떨어집니다.
	//              결과적으로, 부모/자식 객체 모두 잘 직렬화/역직렬화가 됩니다.
	public static void main(String[] args) throws Exception {
		// 1. 파일에 대한 기본 출력스트림 생성
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. 기본스트림에 대한 객체출력보조스트림 생성
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 3. 자식객체 생성 > 객체의 직렬화 수행 
		Child2 child = new Child2();
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
		
		Child2 restoredChild = (Child2) ois.readObject();
		System.out.println(restoredChild);
		System.out.println(restoredChild.field1);
	} // main
	
} // end class

