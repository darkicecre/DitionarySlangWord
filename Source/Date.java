package Main;
// test
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
public class Date{
	private LocalDate date;
	private LocalTime time;
	public Date(){
		date = LocalDate.now();
		time=LocalTime.now();
	}
	public String getDateTime(){
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String s=time.format(timeFormatter);
		DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("MMMM/dd/yyyy");
        return date.format(dateFormatter2)+" "+s;
    }
 
}
