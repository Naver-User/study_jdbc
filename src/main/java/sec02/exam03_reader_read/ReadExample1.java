package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

import lombok.Cleanup;

public class ReadExample1 {

	public static void main(String[] args) throws Exception {
		// 문자기반의 입력스트림을 생성(파일에 대해서)
		@Cleanup Reader reader = new FileReader("C:/Temp/test.txt");
		
		int readData;	// 4바이트 정수
		
		while( true ) {	// 무한루프
			readData = reader.read();	// 한"문자"씩 읽어냄		
			if(readData == -1) break;	// 탈출조건: 파일의 끝을 만나면(EOF)
			
			// 4바이트 정수를 2바이트로 형변환해서 출력
			System.out.print((char) readData);	// 문자로 출력
		} // while	
	} // main

} // end class

