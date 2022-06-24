package summerproject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.*;

import summerproject.Calendar.GoogleCalendar;

/* class to demonstarte use of Calendar events list API */
public class CalendarQuickstart {
	

	public static void main(String... args) throws IOException, GeneralSecurityException {
	
		GoogleCalendar service = new GoogleCalendar();

		// List the next 10 events from the primary calendar.
		DateTime now = new DateTime(System.currentTimeMillis());
		Events events = service.calendar.events().list("primary")
				.setMaxResults(10)
				.setTimeMin(now)
				.setOrderBy("startTime")
				.setSingleEvents(true)
				.execute();

		List<Event> items = events.getItems();

		if (items.isEmpty()) {
			System.out.println("No upcoming events found.");
		} else {
			System.out.println("Upcoming events");
			for (Event event : items) {
				DateTime start = event.getStart().getDateTime();
				if (start == null) {
					start = event.getStart().getDate();
				}
				System.out.printf("%s (%s)\n", event.getSummary(), start);
			}
		}

	}
}