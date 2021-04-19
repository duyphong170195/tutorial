package com.example.projecttest.repo;

import com.example.projecttest.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepo extends CrudRepository<Subscriber, Long> {
}
