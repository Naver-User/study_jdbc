package sec05.exam08_objectinputstream_objectoutputstream;

import lombok.ToString;


@ToString

// Case2 - Serializable 인터페이스 구현하지않음 -> 객체의 직렬화/역직렬화 불가
//         결론: 
public class Child2 extends Parent2 {
	private static final long serialVersionUID = 1L;
	
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

