package com.training.sportsbetting.service.json;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.training.sportsbetting.domain.SportEvent;

@Service
public class SportEventReader {

    private final static Logger LOG = LoggerFactory.getLogger(SportEventReader.class);
    private final static Type SPORT_EVENT_LIST_TYPE = new TypeToken<ArrayList<SportEvent>>() {
    }.getType();
    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .create();

    public List<SportEvent> readFromJson(String fileName) {
        List<SportEvent> sportEvents = new ArrayList<>();
        try (Reader reader = new FileReader(fileName)) {
            sportEvents = gson.fromJson(reader, SPORT_EVENT_LIST_TYPE);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } catch (JsonSyntaxException e) {
            LOG.error("Invalid json string, cannot be parse to get sport events. File: " + fileName + " " + e.getMessage());
        }
        return sportEvents;
    }

}
