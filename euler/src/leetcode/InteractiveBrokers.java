package leetcode;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;

public class InteractiveBrokers {

	private static final char SEPARATOR = 0x20;
	private static final int MESSAGE_TYPE =1;
	
	private final Character m_value = 'a';
	
	public String toString() {
		return "" + m_value;
	}
	public static void main(String[] args) {
		try {
			Field f = InteractiveBrokers.class.getDeclaredField("m_value");
			f.setAccessible(true);
			InteractiveBrokers a= new InteractiveBrokers();
			f.set(a,(char) 'b');
			System.out.println(a);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			if(b == 0x90) {
				System.out.print("We found it");
			}
		}
		
		try {
			HttpURLConnection connection = (HttpURLConnection)new URL("http://www.google.com/nohelp").openConnection();
			if(connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println("Page not found");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
