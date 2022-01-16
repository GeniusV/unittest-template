package com.geniusver.test;

import com.geniusver.hello.unittest.AppContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppContextTest extends BaseUnitTest {
    @Test
    void appContextTest() {
        staticMockManager.mockStatic(AppContext.class)
                .when(() -> AppContext.getCurrentUserId())
                .thenReturn(100);
        assertEquals(100, AppContext.getCurrentUserId());
    }
}
