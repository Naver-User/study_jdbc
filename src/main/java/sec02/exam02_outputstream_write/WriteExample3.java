package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

import lombok.Cleanup;

public class WriteExample3 {

	public static void main(String[] args) throws Exception {
		@Cleanup OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		
		// 바가지 채로 부는것은 같은데, 바가지 전체를 붓는게 아니라,
		// 이미 정해진 바가지의 일부만 붙는 write 메소드
		byte[] data = "ABC".getBytes();
//		         배열  offset length
		os.write(data,   1,    2);	// 바가지의 일부만 붓자!!
		
//		os.write(data,   0,    data.length - 1);	// 바가지(=배열)전체를 붓는거와 같다
		
		
		os.flush();		/**** 강제flush  */
	} // main

} // end class
