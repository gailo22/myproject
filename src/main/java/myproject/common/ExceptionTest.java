package myproject.common;

class ExceptionTest {
	
	public static void main(String[] args) {
		System.out.println("start");
		try {
			throwException();
			return;
		} catch (Exception e) {
			System.out.println("catch Exception");
		} finally {
			System.out.println("finally");
		}
		System.out.println("end");
	}

	private static void throwException() throws Exception  {
		System.out.println("throwException");
		throw new Exception();
	}
}

// output:
//start
//throwException
//catch Exception
//finally
//end