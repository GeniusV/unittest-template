package com.geniusver.hello.unittest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by GeniusV on 2019-08-11.
 */

// for junit 5
@ExtendWith(MockitoExtension.class)
class MockitoUserTest {

    @Mock
    User.Wallet mockWallet;

    @InjectMocks
    User user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testNormalUser() {
        when(mockWallet.getBalance()).thenReturn(2);

        String res = user.toString();
        assertNotNull(res);
        System.out.println(res);

    }


}