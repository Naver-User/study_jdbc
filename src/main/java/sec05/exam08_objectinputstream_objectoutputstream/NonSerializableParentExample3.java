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
		
		// 1. 파일에 대한 기본 출력스트림 생성
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. 기본스트림에 대한 객체출력보조스트림 생성
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// 3. 자식객체 생성 > 객체의 직렬화 수행 
		Child3 child = new Child3();
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
		
		Child3 restoredChild = (Child3) ois.readObject();
		System.out.println(restoredChild);
		System.out.println(restoredChild.field1);
	} // main
	
} // end class

