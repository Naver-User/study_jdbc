package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;


// 이 클래스 역시, Serialiable Tag 인터페이스를 구현하고 있기 때문에,
// 객체의 직렬화/역직렬화의 대상이 되는 객체를 생성할 수 있는 클래스입니다.
public class ClassB implements Serializable {
	int field1;		// 인스턴스 필드
	
} // end class



