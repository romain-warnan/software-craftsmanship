package fr.insee.tdd.model.rss;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DatePublicationAdapter extends XmlAdapter<String, Date> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;

    @Override
    public Date unmarshal(String string) {
        LocalDate localDate = LocalDate.parse(string, formatter);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public String marshal(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.format(formatter);
    }
}