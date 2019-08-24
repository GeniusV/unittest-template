package com.geniusver.hello.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by GeniusV on 2019-08-24.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(User.class)
public class PowermockUserTest {

    @Mock
    private User.Wallet wallet;

    @InjectMocks
    private User user;

    @Test
    public void testPrivate() throws Exception {
        user = PowerMockito.spy(user);
        when(user, "getPrivateMoney").thenReturn(500);
        when(wallet.getBalance()).thenReturn(1000);
        assertEquals(1500, user.getTotalMoney());
    }


}
