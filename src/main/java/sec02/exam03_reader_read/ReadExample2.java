package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

import lombok.Cleanup;

public class ReadExample2 {

	// 문자기반의 입/출력을 할 때에, "바가지(배열)"를 사용할때,
	// 바이트기반 -> byte[] 되고, 문자기반 -> char[]이 됩니다!!! <--- ***
	public static void main(String[] args) throws Exception {
		@Cleanup Reader reader = new FileReader("C:/Temp/test.txt");
		
		int readCharNo;
		
		// 바가지로 한번에 읽어들이는 문자개수를 증가시키자!!!
		char[] cbuf = new char[200000];		// 최대 2개의 문자를 저장가능한 배열(바가지)
		
		String data = "";
		
		while( true ) {
			readCharNo = reader.read(cbuf);	// 바가지로 읽자!!(바가지 전체사용)
			if(readCharNo == -1) break;
			
			// 읽은 문자데이터 -> String (문자열)로 변환 및 누적
			data += new String(cbuf, 0, readCharNo);
		} // while
		
		System.out.println(data);	
	} // main

} // end class
