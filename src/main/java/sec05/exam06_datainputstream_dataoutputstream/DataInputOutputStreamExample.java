package sec05.exam06_datainputstream_dataoutputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import lombok.Cleanup;


public class DataInputOutputStreamExample {
	
	
	public static void main(String[] args) throws Exception {
		// 기본시트림 생성
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/primitive.dat");
		
		// 데이터 출력 보조스트림 생성
		@Cleanup DataOutputStream dos = new DataOutputStream(fos);
		
		// 기본타입변수또는 값 그대로 출력을 가능하게 해줍니다.
		
		// 1st. data
		dos.writeUTF("홍길동");		// 문자열 출력
		dos.writeDouble(95.5);		// 실수 출력
		dos.writeInt(1);			// 정수 출력
		
		// 2nd. data
		dos.writeUTF("감자바");		// 문자열 출력
		dos.writeDouble(90.3);		// 실수 출력
		dos.writeInt(2);			// 정수 출력
		
		dos.flush(); 				// 강제flush
		
		// --------------
		
		// 파일을 읽을 바이트 기반 입력 기본스트림 생성
		@Cleanup FileInputStream fis = new FileInputStream("C:/Temp/primitive.dat");
		// 데이터 보조스트림 생성
		@Cleanup DataInputStream dis = new DataInputStream(fis);
		
		// 2사람의 데이터를 읽어냅니다.
		// (중요) 파일은 당연히 처음부터 읽습니다.
		for(int i=0; i<2; i++) {
			String name = dis.readUTF();		// 이름 
			double score = dis.readDouble();	// 실수
			int order = dis.readInt();			// 정수
			
			if(i == 1) {
				System.out.println(name + " : " + score + " : " + order);
			} // if-else
			
		} // for
	} // main
	
}

