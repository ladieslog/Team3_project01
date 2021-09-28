package timeThread;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import kjh_Manager.Screening.DestinyMovieSeatDAO;

public class TimeThread {
	public TimeThread() {
		run();
	}

	public void run() {
		DestinyMovieSeatDAO dao = DestinyMovieSeatDAO.getInstance();
		System.out.println(0);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 1);
		Date date = cal.getTime();
		Timestamp ts = new Timestamp(date.getTime());
		int result = dao.deleteScreening(ts);
<<<<<<< HEAD
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======
		
>>>>>>> 489f5f6413a7f2db8a5b8040b6988f1874d86914
	}
}
