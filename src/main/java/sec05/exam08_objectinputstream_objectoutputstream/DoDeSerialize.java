package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class DoDeSerialize {

	
	public static void main(String[] args) throws Exception {		
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 역직렬화 수행
		Person yoseph = (Person) ois.readObject();
		System.out.println(yoseph);
		System.out.println(Person.PI);
	} // main

}
