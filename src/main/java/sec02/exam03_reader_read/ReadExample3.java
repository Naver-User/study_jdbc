package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

import lombok.Cleanup;

public class ReadExample3 {

	public static void main(String[] args) throws Exception {
		@Cleanup Reader reader = new FileReader("C:/Temp/test1.txt");
		
		int readCharNo;
		
		char[] cbuf = new char[20];		// 바가지
		
		readCharNo = reader.read(cbuf, 0, 10);	// 바가지의 일부만 정해져 쓰자!!!
		
		for(int i=0; i<cbuf.length; i++) {
			System.out.print(cbuf[i]);
		} // for
	} // main

}
