package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;

import lombok.ToString;


@ToString

// Serializable Marker(or Tag) 인터페이스를 구현한다!
// -> 객체의 직렬화/역직렬화 가능!!!
public class Parent2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String field1;

} // end class
