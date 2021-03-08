import exUser_servlet.util.SHA256Util;

public class PassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pass = SHA256Util.getEncSHA256("1234");
		
		System.out.println(pass);

	}

}
