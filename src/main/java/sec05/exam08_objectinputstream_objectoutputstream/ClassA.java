package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;



public class ClassA implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	int field1;						// 인스턴스 필드
	ClassB field2 = new ClassB();	// 집합관계의 부품필드
	
	// 정적필드 역시, Clazz 객체의 소속멤버이기 때문에,
	// 그래서, 직렬화할 ClassA 타입의 객체 소속이 아니기 때문에,
	// 직렬화대상에서 무조건 제외
	static int field3;				// 정적필드
	
	// 인스턴스필드인데...처음보는 키워드로 transient, 이건 뭐지!???
	// 이 키워드가 붙은 필드는, 객체의 직렬화/역직렬화대상에서 제외시킨다!
	transient int field4;	
	
} // end class

