package com.example.wbdvonlinesp20serverjava.services;

import com.example.wbdvonlinesp20serverjava.models.Widget;
import com.example.wbdvonlinesp20serverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    public int deleteWidget(Integer widgetId) {
        return 1;
    }

    public Widget createWidget(Widget newWidget) {
        return newWidget;
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>)widgetRepository.findAll();
    }

    public List<Widget> findWidgetsForTopic(int topicId) {
        return widgetRepository.findWidgetsForTopic(topicId);
    }

    public int updateWidget(String widgetId, Widget updateWidget) {
        return 0;
    }
}
