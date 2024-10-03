package sec05.exam02_outputstreamwriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import lombok.Cleanup;


public class OutputStreamWriterExample {
	
	// �̹��� ����� ������Ʈ����, "����Ʈ���"�� ��½�Ʈ�� -> "���ڱ��"��
	//                              ��½�Ʈ������ ��ȯ����
	// �׷���, ���ڹ迭 �Ǵ� ���ڿ��� �ٷ� ����� ���� �ֽ��ϴ�.
	// �̴�, �츮�� ���α׷����� ���� ���� �ٷ�� �������� �����ʹ� �ַ�
	// ���ڿ��̱� ������, ���ڿ��� �ٷ� ����� �� �ִٸ� ���� ���ϰ���.
	public static void main(String[] args) throws Exception {
		// ������: ��½�Ʈ�� 
		// (1) ������ ��ο� ������ �������� ������ -> �����Ѵ�
		// (2) ������ ��ο� ������ �������ϸ� -> Overwrite (��, append ��尡 �ƴҶ�)
		
		// �⺻��Ʈ������ ������½�Ʈ��(����Ʈ���) ����
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		
		// ���ں�ȯ������Ʈ��(���ڱ���� ��½�Ʈ���� Writer�� ��ȯ)
		@Cleanup Writer writer = new OutputStreamWriter(fos);
		
		String data = "����Ʈ ��� ��Ʈ���� ���� ��� ��Ʈ������ ��ȯ";
		writer.write(data);
		
		writer.flush();	// ����flush -> ��¹��ۿ� �ܷ��ϴ� ���ڵ����Ͱ� ���簡��
		System.out.println("���� ������ �������ϴ�.");
	} // main
}

