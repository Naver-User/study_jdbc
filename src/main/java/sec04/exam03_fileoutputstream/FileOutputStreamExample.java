package sec04.exam03_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import lombok.Cleanup;

public class FileOutputStreamExample {
	
	
	// 파일 복사 프로그램을 바이트기반의 기본 입/출력스트림으로 만들어보자!!
	public static void main(String[] args) throws Exception {
		String sourceFileName = "C:/temp/1.jpg";
		String targetFileName = "C:/temp/2.jpg";
		
		// 소스파일에 대한 바이트 기반 입력스트림 생성
		@Cleanup FileInputStream fis = new FileInputStream(sourceFileName);
		
		// 타겟파일에 대한 바이트 기반 출력스트림 생성
		@Cleanup FileOutputStream fos = new FileOutputStream(targetFileName);
		
		// 소스파일에 읽은 데이터를 바로, 출력파일에 쓰면 됩니다!
		// 소스파일의 EOF를 만날 때까지, 위 행위를 반복하면 됩니다!
		int readByteNo;
		
		byte[] readBytes = new byte[100];	// 바가지의 크기
		
		// 소스파일을 바가지채로 읽어내고, 바가지채로 바로 출력파일에 씁니다.
		while( (readByteNo = fis.read(readBytes) ) != -1 ) {	// -1, EOF
			// 이때 바로 write(배열, offset, length) 메소드가 필요하다!!!
			fos.write(readBytes, 0, readByteNo);	// 타겟파일에 그대로 씀
		} // while
		
		fos.flush();	// 출력버퍼 강제flush 수행		
		System.out.println("Copy Done.");
	} // main
	
} // end class

