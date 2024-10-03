package sec05.exam01_inputstreamreader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import lombok.Cleanup;


public class InputStreamReaderExample {
	
	// 바이트기반의 InputStream -> 문자기반의 Reader로 변환해주는 보조스트림
	// 우리코드는 어렵게 바이트로 입력수행하는 게 아니라, 문자기반으로 입력받으면
	// 되는 기능을 제공합니다.
	public static void main(String[] args) throws Exception {
//		@Cleanup		// 왜? 절대로 close 하면 안된다! ==> 표준입력
		InputStream is = System.in;
		
		// 보조스트림 하나하나도, 특정기능을 수행하는 기본스트림(추상클래스)의
		// 자식 클래스입니다(Concrete Class) . 때문에 다 사용하고 나면, 당연히
		// 자원객체이니까, 닫으셔야 합니다.
		// (중요) 대신, 기본스트림에 보조스트림 한개 이상을 붙이시면,
		// 반드시, *역순으로* 스트림을 close 해야 합니다.
		
		// 보조스트림을 기본스트림에 붙이는 방법 -> 보조스트림의 생성자에
		//                                          매개변수로 기본/이미 붙어있는 보조스트림
		@Cleanup Reader reader = new InputStreamReader(is);	
		
		int readCharNo;
		
		char[] cbuf = new char[100];	// 바가지: 문자기반의 바가지
		
		while ((readCharNo=reader.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);	// 문자배열->문자열로변환
			System.out.println(data); // 문자열(=Token) 출력
		} // while
		
//		reader.close();
	} // main
	
} // end class

