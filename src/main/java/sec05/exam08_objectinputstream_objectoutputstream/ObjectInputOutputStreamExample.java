package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import lombok.Cleanup;


public class ObjectInputOutputStreamExample {
	
	
	// 1개이상의 Wrapper Type 객체의 직렬화/역직렬화 예제
	public static void main(String[] args) throws Exception {
		// 1. 객체를 직렬화해서 저장할 파일에 대한 기본스트림 생성
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		
		// 2. 객체의 직렬화/역직렬화 수행하는 보조스트림 생성
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);		
		
		// 3. 1개 이상의 기본타입별 레퍼타입 객체의 직렬화
		oos.writeObject(10);	// 오토박싱으로 자동객체 생성
		oos.writeObject(3.14);	// 오토박싱으로 자동객체 생성
		oos.writeObject(new int[] { 1, 2, 3 });	// 배열객체 생성
		oos.writeObject(new String("홍길동"));
		
		oos.flush();	// 강제flush
		
		// -------------------------
		// 객체의 역직렬화를 통해, 한 파일에 저장된 각각의 객체를 복원
		// -------------------------
		
		// 1. 역직렬화할 파일에 대한 기본스트림 생성
		@Cleanup FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		
		// 2. 객체의 역직렬화를 수행하는 보조스트림 연결
		@Cleanup ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 3. 파일에 저장된 객체를, 저장한 순서대로 한 객체씩 복원
		Integer obj1 = (Integer) ois.readObject();	// <--- ***
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[]) ois.readObject();
		String obj4 = (String) ois.readObject();
		
		// 4. 3번을 대체하는 코드로, 안전한 형변환
//		Object obj = ois.readObject();
//		if(obj instanceof Integer integer) {
//			// 안전한 강제형변환
//		} // if
		
		// ----------------------
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(Arrays.toString(obj3));
		System.out.println(obj4);
	} // main
	
} // end class
