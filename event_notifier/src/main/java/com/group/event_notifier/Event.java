package com.group.event_notifier;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    private String id;
    private String eventName;
    //private List<String> eventType;
    private Date eventDescription;
    private Date endingDate;
    private String location;
    private String imgDirectory;

}
