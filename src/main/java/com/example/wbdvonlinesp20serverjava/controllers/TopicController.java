package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Topic;
import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.TopicRepository;
import com.example.wbdvonlinesp20serverjava.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    // DO NOT USE THIS - ONLY FOR ACADEMIC PURPOSE
    @GetMapping("/api/topics/{tid}/widgets/create")
    public Widget createWidgetForTopicBad(
            @PathVariable("tid") Integer tid) {
        Widget newWidget = new Widget();
        newWidget.setTitle("Dont do this");
        newWidget.setSize(111);
        return topicService.createWidgetForTopic(tid, newWidget);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidgetForTopic(
            @PathVariable("tid") Integer tid,
            @RequestBody Widget newWidget) {
        return topicService.createWidgetForTopic(tid, newWidget);
    }

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }
}
