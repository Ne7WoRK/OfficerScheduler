import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Test {
	
	public static void main (String[] args) throws ParseException {
		
        String today = new SimpleDateFormat("EEEE", new Locale("bg")).format(Calendar.getInstance().getTime());
        System.out.println("Днес е: " + today.substring(0, 1).toUpperCase() + today.substring(1));
	}
	

}
