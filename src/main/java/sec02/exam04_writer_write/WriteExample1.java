package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;

import lombok.Cleanup;


public class WriteExample1 {

	public static void main(String[] args) throws Exception {
		
		@Cleanup Writer writer = new FileWriter("C:/Temp/test1.txt", true);
		
		//        String.getBytes();
		// 문자열 ------------------> 바이트배열
		
		//        String.toCharArray();
		// 문자열 ------------------> 문자배열
		char[] data = "이순신장군".toCharArray();
		
		for(int i=0; i<data.length; i++) {
			writer.write(data[i]);	// 문자열을 가지고 변환한 문자기반의 바가지채로 출력버퍼에 씀
		} // for
		
		writer.flush();	// 강제flush를 통해, 출력버퍼에 잔류가능한 문자데이터를 강제출력
	} // main

}
