package sec05.exam02_outputstreamwriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import lombok.Cleanup;


public class OutputStreamWriterExample {
	
	// 이번에 사용할 보조스트림은, "바이트기반"의 출력스트림 -> "문자기반"의
	//                              출력스트림으로 변환해줌
	// 그래서, 문자배열 또는 문자열을 바로 출력할 수가 있습니다.
	// 이는, 우리가 프로그램에서 가장 많이 다루는 실질적인 데이터는 주로
	// 문자열이기 때문에, 문자열로 바로 출력할 수 있다면 아주 편하겠죠.
	public static void main(String[] args) throws Exception {
		// 대전제: 출력스트림 
		// (1) 지정된 경로에 파일이 존재하지 않으면 -> 생성한다
		// (2) 지정된 경로에 파일이 미존재하면 -> Overwrite (단, append 모드가 아닐때)
		
		// 기본스트림으로 파일출력스트림(바이트기반) 생성
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		
		// 문자변환보조스트림(문자기반의 출력스트림인 Writer로 변환)
		@Cleanup Writer writer = new OutputStreamWriter(fos);
		
		String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
		writer.write(data);
		
		writer.flush();	// 강제flush -> 출력버퍼에 잔류하는 문자데이터가 존재가능
		System.out.println("파일 저장이 끝났습니다.");
	} // main
}

