package sec04.exam04_file_reader;

import java.io.FileReader;


public class FileReaderExample {
	
	// "문자기반"의 입력스트림인 Reader 를 이용해보자!!!
	public static void main(String[] args) throws Exception {
		// Step1. 파일에 대한 문자기반의 입력스트림을 생성
		FileReader fr = new FileReader("C:/temp/test.txt");
		
		int readCharNo;	// 파일입력스트림으로부터, 읽어낸 문자의 개수를 저장
		
		// 문자타입의 배열을 사용한다!!!
		char[] cbuf = new char[100];	// 바가지
		
		while ( ( readCharNo=fr.read(cbuf) ) != -1) {	// if EOF(-1)
			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);
		} // while
		
		fr.close();
	}
}

