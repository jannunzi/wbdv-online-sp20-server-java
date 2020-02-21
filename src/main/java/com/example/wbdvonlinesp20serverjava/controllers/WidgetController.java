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

    @GetMapping("/api/widgets/{wid}/update")
    public int updateWidgetNotRestfulBad(
            @PathVariable("wid") int widgetId) {
        Widget widget = new Widget();
        widget.setTitle("New and Improved Title");
        widget.setSize(123);
        return service.updateWidget(widgetId, widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") int widgetId,
                            @RequestBody Widget widget) {
        return service.updateWidget(widgetId, widget);
    }

    @GetMapping("/api/widgets/{wid}/delete")
    public int deleteWidgetNotRestful(@PathVariable("wid") int widgetId) {
        return service.deleteWidget(widgetId);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") int widgetId) {
        return service.deleteWidget(widgetId);
    }

    @GetMapping("/api/widgets/create")
    public Widget createWidgetNotRest() {
        Widget newWidget = new Widget();
        newWidget.setTitle("Not RESTful");
        newWidget.setSize(45);
        return service.createWidget(newWidget);
    }

    @PostMapping("/api/widgets")
    public Widget createWidget(@RequestBody Widget newWidget) {
        return service.createWidget(newWidget);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") int wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") int tid) {
        return service.findWidgetsForTopic(tid);
    }

}
