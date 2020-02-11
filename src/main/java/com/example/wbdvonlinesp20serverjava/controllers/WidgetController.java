package com.example.wbdvonlinesp20serverjava.controllers;

import com.example.wbdvonlinesp20serverjava.models.Widget;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    List<Widget> widgets = new ArrayList<Widget>();

    {
        Widget w1 = new Widget();
        Widget w2 = new Widget();
        w1.setTitle("Widget 1");
        w1.setId("123");
        w1.setType("HEADING");
        w2.setTitle("Widget 2");
        w2.setId("234");
        w2.setType("PARAGRAPH");
        widgets.add(w1);
        widgets.add(w2);
    }

    @DeleteMapping("/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") String widgetId) {
        widgets = widgets.stream()
                .filter(w -> !w.getId().equals(widgetId)).collect(Collectors.toList());
        return 1;
    }

    @PostMapping("/widgets")
    public Widget createWidget(@RequestBody Widget newWidget) {
        widgets.add(newWidget);
        return newWidget;
    }

    @GetMapping("/widgets")
    public List<Widget> findAllWidgets() {
        return widgets;
    }
}
