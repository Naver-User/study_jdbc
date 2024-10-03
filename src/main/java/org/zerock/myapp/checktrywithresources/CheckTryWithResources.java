package org.zerock.myapp.checktrywithresources;

import java.sql.SQLException;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class CheckTryWithResources {
	
	public static void main(String[] args) {
		
		try {
			Resource1 res1 = new Resource1();
			Resource2 res2 = new Resource2();
			Resource3 res3 = new Resource3();
			
			// 1st. location: Here, throw Exception.
//			if(true) throw new Exception("1st. location");
			
			try (res1; res2; res3) {
				// Do something....
				
				// 2nd. location: Here, throw SQLException
				throw new SQLException("2nd. location");
			} // try-with-resources
		} catch(SQLException e) {
			log.info("SQLException occurred.");
		} catch(Exception e) {
			log.info("Exception occurred.");
		} // try-multiple-catch

	} // main

} // end class

//=================
@Log4j2
@NoArgsConstructor
class Resource1 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		log.info("1. close() invoked.");
	} // close
	
} // end class

//=================
@Log4j2
@NoArgsConstructor
class Resource2 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		log.info("2. close() invoked.");
	} // close
	
} // end class

//=================
@Log4j2
@NoArgsConstructor
class Resource3 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		log.info("3. close() invoked.");
		
		throw new RuntimeException("Resource #3");
	} // close
	
} // end class


