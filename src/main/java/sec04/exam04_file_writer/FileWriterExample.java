package sec04.exam04_file_writer;

import java.io.File;
import java.io.FileWriter;

import lombok.Cleanup;


public class FileWriterExample {
	
	// 문자기반의 출력스트림 Writer를 이용해서, 파일출력을 해보자!!!
	public static void main(String[] args) throws Exception {
		// File 타입이 처음나옴.
		File file = new File("C:/Temp/test.txt");	
		
		// 출력스트림: 바이트/문자기반이든, 미리 알고있어야 한다:
		//  (1) 지정된 경로의 파일이 없으면 -> 새로 생성
		//  (2) 지정된 경로의 파일이 있으면 -> 기존파일의 모든 내용 삭제, 처음부터 다시쓴다
		@Cleanup FileWriter fw = new FileWriter(file, true);	// true: append (추가)
		
		// 문자열 그대로 출력버퍼에 출력가능
		fw.write("아니러ㅣㅇㄴㄹ98ㅇㄴ7ㄹ9ㅇ799ㄹㅇㄴ9 " + "\r\n");
		fw.write("896ㅇㄹㅇㄴ랑ㄴ!@#$$$%^**((" + "\r\n");
		
		fw.flush();
		
		System.out.println("표준출력");
		System.err.println("표준에러");
		
	} // main
}

