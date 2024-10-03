package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

import lombok.Cleanup;

public class WriteExample2 {

	// 출력스트림의 출력메소드에도 "바가지"가 사용가능합니다.
	// 물론, 이전예제에서 배웟지만요...여러분이 어떤 write 메소드를 쓰시더라도,
	// 메모리의 "출력버퍼"에 다 쓰는것이지, 바로 출력스트림에 쓰는게 아니기 때문에,
	// 사실, 성능한 차이는 미미합니다.
	public static void main(String[] args) throws Exception {
		@Cleanup OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		
		// 문자열 -> 바이트 열로 변환 -> 출력버퍼에 바가지(= 배열)채로 써버리자!!!
		byte[] data = "ABC".getBytes();
		os.write(data);	// 바가지(= 바이트배열)채로 출력(to 출력버퍼)
		
		os.flush();		// *****
	} // main

} // end class

