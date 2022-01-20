package com.group.event_notifier;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;




@Data
@Entity
public class OldEvent{
  @Id
    private String id;
    private String eventName;
    private String type1;
    private String type2;
    private String type3;
    private String type4;
    private String type5;
    private String eventDescription;
    private Date endingDate;
    private String location;
    private String imgDirectory;
    private String organizationId;
  
}

