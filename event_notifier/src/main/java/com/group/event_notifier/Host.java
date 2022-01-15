package com.group.event_notifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Host {
  @Id
  private String id;
  private String companyName;
  private String companyEmail;
  private String companyPassword;
  private String companyTelePhone;
}
