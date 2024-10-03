package sec05.exam03_bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import lombok.Cleanup;


public class BufferedInputStreamExample {
	
	// 기본입/출력스트림에 성능향상보조스트림으로 BufferedInput/OutputStream,
	// BufferedReader/Writer 를 이용하여, 입/출력 성능을 대폭향상하는 방법을 배우자!!
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		// ----- 첫번째는 보조스트림이 적용안되고, 기본스트림만으로 입력수행
		{
			@Cleanup FileInputStream fis1 = 
						new FileInputStream("C:/temp/OracleXE213_Win64.zip");
			
			start = System.currentTimeMillis();		// 시작시간 측정
			
				// (1) 기본스트림으로부터, 한 바이트씩 읽는 경우
				while(fis1.read() != -1); // 읽어낸 바이트로 하는 일은 없음
				
			end = System.currentTimeMillis();
			
			System.out.println("1. 사용하지 않았을 때: " + (end - start) + "ms");			
		} // 사용자정의블록1
		
		{
			@Cleanup FileInputStream fis2 = 
				new FileInputStream("C:/temp/OracleXE213_Win64.zip");
			
			// 성능향상 보조스트림을 적용
			@Cleanup BufferedInputStream bis = 
				new BufferedInputStream(fis2);
			
			start = System.currentTimeMillis();

				// (1) 기본스트림으로부터, 한 바이트씩 읽는 경우
				while(bis.read() != -1); // 읽어낸 바이트로 하는 일은 없음
				
			end = System.currentTimeMillis();
			System.out.println("2. 사용했을 때: " + (end-start) + "ms");			
		} // 사용자정의블록2
		
	} // main

	
} // end class

