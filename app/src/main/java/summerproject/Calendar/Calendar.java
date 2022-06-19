package summerproject.Calendar;

import java.util.Date;
import java.util.List;

import com.google.api.services.calendar.model.Event;

public interface Calendar {
    
    public List<Event> getEvents();

    public List<Event> getEvents(Date startTime);

    public boolean addEvent(Event event);

    public boolean deleteEvent(String eventId);

}
