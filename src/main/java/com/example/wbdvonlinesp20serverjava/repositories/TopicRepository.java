package com.example.wbdvonlinesp20serverjava.repositories;

import com.example.wbdvonlinesp20serverjava.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository
        extends CrudRepository<Topic, Integer> {
}
