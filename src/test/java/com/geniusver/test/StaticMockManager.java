package com.geniusver.test;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class StaticMockManager {
    private final Map<Class, MockedStatic> mockedStaticMap = new HashMap<>();


    public <T> MockedStatic<T> mockStatic(Class<T> type) {
        MockedStatic existedMock = mockedStaticMap.get(type);
        if (existedMock != null) {
            return existedMock;
        }
        MockedStatic<T> mockedStatic = Mockito.mockStatic(type);
        mockedStaticMap.put(type, mockedStatic);
        return mockedStatic;
    }

    public void cleanup() {
        mockedStaticMap.values().forEach(mockedStatic -> mockedStatic.close());
        mockedStaticMap.clear();
    }
}
