package com.geniusver.test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseUnitTest {
    protected StaticMockManager staticMockManager = new StaticMockManager();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        staticMockManager.cleanup();
    }
}
