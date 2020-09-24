package no.ssb.api.ssbbilapi.utils;

import org.springframework.format.datetime.DateFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Dato {
    static SimpleDateFormat simpleDateTimeFormatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static LocalDate StringToDate(String datostring) throws ParseException {
        return LocalDate.parse(datostring, dateFormatter);
    }

    public static LocalDateTime StringToDateTime(String datostring) throws ParseException {
        return LocalDateTime.parse(datostring, dateTimeFormatter);
    }

    public static java.sql.Date StringToSqlDate(String datostring) throws ParseException {
        Date dato = simpleDateTimeFormatter.parse(datostring);
        return new java.sql.Date(dato.getTime());
    }



}
