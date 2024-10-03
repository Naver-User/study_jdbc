package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;


// DTO
@Data
public class Person implements Serializable {
	@Serial private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	
	// 리모델링하기전에는 키가 있엇다!!!
	// 리모델링후에는 키를 없앰
	private double height;
	
	// 민감한 몸무게는 다른 개발자가 복원해서 볼 수 없도록
	// 직렬화에서 제외!!!
	transient private double weight;
	
	private boolean male;
	
	private double eyePower;	// eye: 눈(시), power: 힘(력) => 시력
	
	
	
	
	// 정적필드는 Clazz 객체의 소속 멤버이기 때문에,
	// 우리가 직렬화하는 객체는 Person객체이지, Clazz 객체가 아니기 때문에
	// 처음~~~~~~소주처럼, 소주하고 단 1도 상관이 없습니다.!!!!
	public static final double PI = 3.14159;	// 원주율
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end class
