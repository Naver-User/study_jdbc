package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import lombok.Cleanup;


public class DoSerialize {
	
	
	public static void main(String[] args) throws Exception {		
		@Cleanup FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");		
		@Cleanup ObjectOutputStream oos = new ObjectOutputStream(fos);		
		
		Person yoseph = new Person();
		
		yoseph.setName("Yoseph");
		yoseph.setAge(23);
		yoseph.setHeight(172.5);
		yoseph.setWeight(59.5);
		yoseph.setMale(true);
		
		System.out.println(yoseph);
		
		oos.writeObject(yoseph);		// 객체의 직렬화 및 출력스트림에 출력		
		oos.flush();					// 강제Flush 수행
	} // main
	
} // end class


