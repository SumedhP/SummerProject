package summerproject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.*;

import summerproject.Calendar.GoogleCalendar;

/* class to demonstarte use of Calendar events list API */
public class CalendarQuickstart {

	public static void main(String... args) throws IOException, GeneralSecurityException {

		GoogleCalendar service = new GoogleCalendar();

		// List the next 10 events from the primary calendar.
		DateTime now = new DateTime(System.currentTimeMillis());

		Event newEvent = new Event();
		newEvent.setSummary("burger");
		newEvent.setLocation("IHOP");
		newEvent.setStart(new EventDateTime().setDate(now));
		newEvent.setEndTimeUnspecified(true);

		System.out.println(newEvent);

		System.out.println("This has happened");

		service.calendar.events().insert("Sumedh", newEvent).execute();

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