package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import com.example.wbdvonlinesp20serverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;

    @PutMapping("/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") String widgetId,
                            @RequestBody Widget widget) {
        return 1;
    }

    @DeleteMapping("/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") int widgetId) {
        return 1;
    }

    @PostMapping("/widgets")
    public Widget createWidget(@RequestBody Widget newWidget) {
        return null;
    }

    @GetMapping("/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") int tid) {
        return service.findWidgetsForTopic(tid);
    }

}
