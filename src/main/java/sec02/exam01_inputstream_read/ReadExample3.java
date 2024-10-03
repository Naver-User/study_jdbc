package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;


public class ReadExample3 {

	// 파일에 연결된 바이트기반의 입력스트림으로, 파일을 읽어드리는 예제
	// 바가지 크기를 8바이트로 크게 하고, 바가지의 일부분만으로 바이트를 읽어들이는 경우
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		
		int readByteNo;
		byte[] readBytes = new byte[8];			// 바가지
		               //        바가지      Offset   Length
					   //---    ---------   --------  ---
		readByteNo = is.read(   readBytes,     2,      3   );
		
//		readByteNo = is.read(   readBytes,     0,      8   );
//		readByteNo = is.read(readBytes);
		
		// ----------------------------------------------------------
		// |   0   |   1   |   2   |   3    |  4    |   5    |   6   |   7   |
		// -----------------------------------------------------------
		
		
		for(int i=0; i<readBytes.length; i++) {
			System.out.println(readBytes[i]);
		} // for
		
		is.close();		
		
	} // main

} // end class

