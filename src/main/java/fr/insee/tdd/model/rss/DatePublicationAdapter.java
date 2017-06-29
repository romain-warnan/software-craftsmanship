package fr.insee.tdd.model.rss;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DatePublicationAdapter extends XmlAdapter<String, Date> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM YYYY HH:mm:ss 'GMT'");

    @Override
    public Date unmarshal(String string) {
        LocalDateTime localDate = LocalDateTime.parse(string, formatter);
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public String marshal(Date date) {
        if (date == null) {
            return "";
        }
        Date d = new Date(date.getTime());
        LocalDateTime localDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDate.format(formatter);
    }
}