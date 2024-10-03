package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;


@Log4j2
@ToString

// Case3 - 자식만 객체의 직렬화/역직렬화 가능
//         부모클래스 수정불가(소스가 없거나, 소스 자체를 얻을 수 없는 상황)
public class Child3
	extends Parent3
	implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String field2;
	
	
	// 직렬화가 불가능한 부모객체도 함께, 직렬화 하게 만들려면,
	// 아래의 2개의 메소드를 반드시 선언하셔야 합니다.
	// 그리고, 각각의 메소드에서 부모객체도 직렬화가 되도록
	// "수동으로" 직렬화 시킴
	
	// (1) 아래의 2개의 메소드를 직렬화가 가능한 자식타입에서 선언
	// (2) 아래의 2개의 메소드의 출처: 자바언어스펙에서 언급된 방법
	// (3) 아래의 2개의 메소드는 상위타입에서 상속된 메소드가 아니다!-> @Override로 못붙임
	// (4) 아래의 2개의 메소드의 시그니쳐는 반드시 아래대로 선언하셔야 합니다.
	//     (임의대로 바꾸면 안된다)
	// (5) 직렬화가 가능한 자식객체에 아래의 2개 메소드가 선언되어 있다면,
	//     JVM이 자식객체의 직렬화 수행시, 아래의 2개 메소드를 자동으로 호출(콜백)합니다.
	//     바로, "수동으로라도 부모객체의 직렬화를 할수 있는 기회를 부여"
	
	// 1. 수동 직렬화 메소드
	private void writeObject(ObjectOutputStream out) throws IOException {
		log.trace(">>>>>>> writeObject({}) invoked.", out);
		
	   out.writeUTF(field1);			// (2) : 부모필드의 직렬화 수동으로 수행
	   
	   // 이미 직렬화가 가능한 Serializable 한 자식객체를 그대로 직렬화 시키는 메소드
	   // (JVM이 수행했던 직렬화 로직을 그대로 실행)
	   out.defaultWriteObject();		// (1) : 직렬화가 애시당초 가능한 자식객체의 직렬화 수행 
	} // writeObject

	// 2. 수동 역직렬화 메소드
	private void readObject(ObjectInputStream in)
		throws IOException, ClassNotFoundException {
		log.trace(">>>>>>> readObject({}) invoked.", in);
		
		// (1) 직렬화된 순서대로, 부모필드부터 직렬화했으니,
		//     역직렬화할 때, 부모필드부터 역직렬화하고, 다음에 자식객체를 역직렬화
	   this.field1 = in.readUTF();
	   // (2) 자식객체를 한번에 역직렬화시킴(쯕, JVM이 대신할 일을 구현한 메소드)
	   in.defaultReadObject();
	} // readObject
	
} // end class

