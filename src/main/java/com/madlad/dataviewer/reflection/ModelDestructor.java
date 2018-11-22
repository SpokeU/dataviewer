package com.madlad.dataviewer.reflection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModelDestructor {

    public <T> List<String> getAvailableFields(Class<T> clazz){
        return Arrays.asList(clazz.getDeclaredFields()).stream().map(field -> field.getName()).collect(Collectors.toList());
    }

}
