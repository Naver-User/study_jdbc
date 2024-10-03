package sec05.exam01_inputstreamreader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import lombok.Cleanup;


public class InputStreamReaderExample {
	
	// ����Ʈ����� InputStream -> ���ڱ���� Reader�� ��ȯ���ִ� ������Ʈ��
	// �츮�ڵ�� ��ư� ����Ʈ�� �Է¼����ϴ� �� �ƴ϶�, ���ڱ������ �Է¹�����
	// �Ǵ� ����� �����մϴ�.
	public static void main(String[] args) throws Exception {
//		@Cleanup		// ��? ����� close �ϸ� �ȵȴ�! ==> ǥ���Է�
		InputStream is = System.in;
		
		// ������Ʈ�� �ϳ��ϳ���, Ư������� �����ϴ� �⺻��Ʈ��(�߻�Ŭ����)��
		// �ڽ� Ŭ�����Դϴ�(Concrete Class) . ������ �� ����ϰ� ����, �翬��
		// �ڿ���ü�̴ϱ�, �����ž� �մϴ�.
		// (�߿�) ���, �⺻��Ʈ���� ������Ʈ�� �Ѱ� �̻��� ���̽ø�,
		// �ݵ��, *��������* ��Ʈ���� close �ؾ� �մϴ�.
		
		// ������Ʈ���� �⺻��Ʈ���� ���̴� ��� -> ������Ʈ���� �����ڿ�
		//                                          �Ű������� �⺻/�̹� �پ��ִ� ������Ʈ��
		@Cleanup Reader reader = new InputStreamReader(is);	
		
		int readCharNo;
		
		char[] cbuf = new char[100];	// �ٰ���: ���ڱ���� �ٰ���
		
		while ((readCharNo=reader.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);	// ���ڹ迭->���ڿ��κ�ȯ
			System.out.println(data); // ���ڿ�(=Token) ���
		} // while
		
//		reader.close();
	} // main
	
} // end class

