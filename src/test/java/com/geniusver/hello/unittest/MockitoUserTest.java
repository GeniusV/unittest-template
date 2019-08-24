package com.geniusver.hello.unittest;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.when;


/**
 * Created by GeniusV on 2019-08-11.
 */
public class MockitoUserTest {

    @Mock
    User.Wallet mockWallet;

    @InjectMocks
    User user;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNormalUser() {
        when(mockWallet.getBalance()).thenReturn(2);

        String res = user.toString();
        assertNotNull(res);
        assertEquals(user.getMoney(), 2);
        System.out.println(res);

    }

    @Test
    public void testMultiReturn() {
        when(mockWallet.getBalance()).thenReturn(1).thenReturn(2).thenReturn(3);

        assertEquals(1, user.getMoney());
        assertEquals(2, user.getMoney());
        assertEquals(3, user.getMoney());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testException() {
        when(mockWallet.getBalance()).thenThrow(new UnsupportedOperationException());

        user.getMoney();
    }


}