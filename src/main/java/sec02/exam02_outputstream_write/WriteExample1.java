package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import lombok.Cleanup;


public class WriteExample1 {

	// 파일에 데이터를 출력 -> FileOutputStream 예제
	public static void main(String[] args) throws Exception {		
		@Cleanup OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		
		// "ABC" 문자열을 파일에 출력하자!!!
		byte[] data = "ABC".getBytes();		// ***: 문자열 => 바이트 열로 변환해주는 메소드
		
		for(int i=0; i<data.length; i++) {
			os.write(data[i]);	// 한 바이트씩 출력!!!
		} // for
		
		// 자바I/O에서, 오로지 출력스트림에만, "출력버퍼"를 가지고 있습니다.
		// "출력버퍼(출력용 작은 임시메모리)": (1) 출력속도를 높이고, (2) 출력스트림에
		// 출력바이트열을 한꺼번에 부어버려서, 출력스트림의 속도를 대폭향상
		// 하지만, 자바입출력은 출력스트림에만 출력버퍼를 만들어 놓았고, 이 출력버퍼
		// 의 크기 기본 8KB입니다.(이 버퍼가 다 차면, 자동으로 출력스트림에 한꺼번에
		// 부어버리는데, 이를 Auto-flushing 이라고 합니다.)
		
		os.flush();	// 강제로 출력버퍼에 잔류하는 바이트들을 출력스트림에 부어버려라!!		
	} // main

} // end class

