package com.realm.relearn.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// this is the object that will be transmitted to the server
@Data
public class PostRequest {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Long id;
    private String created;
    private String title;
    private String content;
    private String description;
    private UserDTO userDTO;



    public Date getSubmissionDateConverted(String timeZone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return dateFormat.parse(this.created);
    }

    public void setSubmissionDate(Date created, String timeZone){
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        this.created = dateFormat.format(created);
    }
}
