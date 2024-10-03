package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class ReadExample1 {

	public static void main(String[] args) throws Exception {		
		@Cleanup InputStream is = new FileInputStream("C:/Temp/test.txt");
		
		int readByte;
		
		while(true) {
			readByte = is.read();
			
			if(readByte == -1) break;
			
//			System.out.print((char) readByte);
			System.out.println((char) readByte);
		} // while
	} // main

} // end class

