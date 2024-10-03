package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import lombok.Cleanup;


public class SerializableExample {
	
	// 객체의 직렬화(Serialization)를 통한, 객체의 파일 저장 예제
	// 객체의 직렬화를 수행하는 ObjectOutputStream 이란 보조스트림을 이용해야 합니다.
	public static void main(String[] args) throws Exception {
		
		// (1) 기본스트림으로 FileOutputStream 생성
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// (2) 객체직렬화 보조스트림 생성
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);		
		
		// (3) 직렬화할 객체를 생성 및 필드 초기화 수행
		ClassA classA = new ClassA();	// 객체생성
		
		// 참고로, 필드 초기화는 생성자를 통해서 하지 않고, 명시적으로
		// 필드에 직접 접근해서 초기화하기로 합니다.
		classA.field1 = 1;				// 필드 초기화 
		classA.field2.field1 = 2;		// 필드 초기화
		ClassA.field3 = 3;				// 정적필드 초기화 <--- ***
		classA.field4 = 4;				// 필드 초기화
		
		// (4) 여기서부터, 객체직렬화 보조스트림의 메소드를 이용해서
		//     객체직렬화 수행 및 객체를 파일에 저장합니다.
		oos.writeObject(classA);		// 객체의 직렬화 및 출력스트림에 출력
		
		oos.flush();					// 강제Flush 수행
		
		// ----------------------------------------//
		
//		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		ClassA v = (ClassA) ois.readObject();
//		System.out.println("field1: " + v.field1);
//		System.out.println("field2.field1: " + v.field2.field1);
//		System.out.println("field3: " + v.field3);
//		System.out.println("field4: " + v.field4);
	}
}
