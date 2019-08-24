package com.geniusver.hello.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by GeniusV on 2019-08-24.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Car.class, User.class})
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

    @Test
    public void testStatic() {
        user = PowerMockito.spy(user);
        mockStatic(Car.class);

        when(Car.createCar()).thenReturn(new Car(1));
        assertEquals(1, Car.createCar().getPrice());

        when(Car.createCar()).thenReturn(new Car(100));
        assertEquals(100, user.byCar().getPrice());
    }


    @Test
    public void testVariable() throws Exception {
        user = spy(user);

        Car car = mock(Car.class);
        when(car.getPrice()).thenReturn(1000);
        whenNew(Car.class).withArguments(anyInt()).thenReturn(car);

        assertEquals(1000, user.buildCar().getPrice());
    }

    @Test
    public void testVoidDoNothing() {
        user = PowerMockito.spy(user);

        doNothing().when(user).setUsername(anyString());

    }


    @Test
    public void testVoidDoSomething() {
        user = spy(user);

        doAnswer(new Answer<User>() {
            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                invocationOnMock.getArguments()[0] = "tttttt";
                invocationOnMock.callRealMethod();
                return user;
            }
        }).when(user).setUsername(anyString());

        user.setUsername("test");

        assertEquals("tttttt", user.getUsername());
    }

    @Test
    public void testPrivateField() {
        user = spy(user);

        doAnswer(new Answer<User>() {
            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                field(User.class, "username").set(user, "tttttt");
                return user;
            }
        }).when(user).setUsername(anyString());

        user.setUsername("test");

        assertEquals("tttttt", user.getUsername());
    }


}
