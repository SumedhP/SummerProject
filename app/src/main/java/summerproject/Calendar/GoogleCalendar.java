package summerproject.Calendar;

import java.util.Date;
import java.util.List;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;

public class GoogleCalendar implements summerproject.Calendar.Calendar{
    
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    
    private final NetHttpTransport HTTP_TRANSPORT;
    
    private final Calendar calendar;

    public GoogleCalendar(){
        HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        calendar = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    @Override
    public List<Event> getEvents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Event> getEvents(Date startTime) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addEvent(Event event) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteEvent(String eventId) {
        // TODO Auto-generated method stub
        return false;
    }
}
