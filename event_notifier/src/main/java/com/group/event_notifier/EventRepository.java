package com.group.event_notifier;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EventRepository extends CrudRepository< Event, Long>{
  
}
