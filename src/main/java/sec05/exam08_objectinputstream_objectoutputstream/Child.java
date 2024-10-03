package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serial;
import java.io.Serializable;

import lombok.ToString;


@ToString

// Serializable 인터페이스 구현 -> 객체의 직렬화/역직렬화 가능 
public class Child
	extends Parent
	implements Serializable {
	
	// 현업에서는, 아래의 serialVersionUID 필드를 반드시 선언하고
	// 대신 값은 1L로 고정시켜버립니다. (관행)
	@Serial private static final long serialVersionUID = 1L;
	
	public String field2;
	
	
	/**
	private void writeObject(ObjectOutputStream out) throws IOException {
	   out.writeUTF(field1);
	   out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	   field1 = in.readUTF();
	   in.defaultReadObject();
	}
	*/
	
} // end class

