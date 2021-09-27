package timeThread;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import kjh_Manager.Screening.DestinyMovieSeatDAO;

public class TimeThread extends Thread{
	public TimeThread() {
		start();
	}
	
	public void run() {
		DestinyMovieSeatDAO dao = DestinyMovieSeatDAO.getInstance();
		while(true) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, 1);
			Date date = cal.getTime();
			Timestamp ts = new Timestamp(date.getTime());
			int result = dao.deleteScreening(ts);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
