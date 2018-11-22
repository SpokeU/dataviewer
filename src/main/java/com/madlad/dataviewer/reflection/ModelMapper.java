package com.madlad.dataviewer.reflection;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ModelMapper {

    @Autowired
    private ObjectMapper jacksonMapper;

    public <T> T map(Class<T> clazz, Map<String, String> map){
        return jacksonMapper.convertValue(map, clazz);
    }

}
