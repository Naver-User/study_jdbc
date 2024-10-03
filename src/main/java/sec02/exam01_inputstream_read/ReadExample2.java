package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

import lombok.Cleanup;


public class ReadExample2 {

	// 파일을 읽는 바이트기반의 입력스트림을 이용해서, 파일데이터를 읽어드리고
	// 이를 출력하되, 이전처럼 바이트 단위로 출력하는게 아니라, 문자열로 만들어서 출력하자!
	public static void main(String[] args) throws Exception {
		@Cleanup InputStream is = new FileInputStream("C:/Temp/test.txt");
		
		int readByteNo;	// 이 변수는, 이전예제와 틀리게, 실제 "바가지"로 읽어드린
						// 바이트의 개수를 보관하는 지역변수
		
		byte[] readBytes = new byte[4];		// 3바이트 크기의 바가지를 이용해서 푸자!!
		
		String data = "";	// 변환된 문자열을 보관할 지역변수 정의
		
		while(true) {	// 무한루트: 파일의 끝을 알 수 없기 때문에...
			readByteNo = is.read(readBytes);	// 3바이트를 담을 수 있는 바가지로 읽어드림
			
			// EOF를 만나면, read(바가지) 메소드는 -1를 반환
			if(readByteNo == -1) break;
			
			// 바가지로 읽어드린 바이트들(최대3개)을 문자열 조각(=Token이라부르죠)
			// 을 누적해서, 계속 문자열로 덧붙입니다.
			
							 // 배열     Offset     Length
							 // -------- ------   ----------  
			data += new String(readBytes,   0,    readByteNo);	// Half-Open
		} // while
		
		System.out.println(data);
	} // main

}
