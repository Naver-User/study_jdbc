package sec05.exam08_objectinputstream_objectoutputstream;

import lombok.ToString;


@ToString

// Serializable Marker(or Tag) 인터페이스를 구현하고 잇지 않습니다.
// -> 객체의 직렬화/역직렬화 불가!!!
public class Parent {
	public String field1;

} // end class
