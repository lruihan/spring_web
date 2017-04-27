package com.fdu.rissy.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by lins13 on 4/27/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoWhenThenTest {

    @Mock
    private MyList myList;

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_when_then_1() {
        when(myList.add(anyString())).thenReturn(false);
        boolean added = myList.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    @Test
    public void test_when_then_2() {
        doReturn(false).when(myList).add(anyString());
        boolean added = myList.add(randomAlphabetic(6));
        assertThat(added, is(false));
    }

    @Test(expected = IllegalStateException.class)
    public void test_when_then_3() {
        when(myList.add(anyString())).thenThrow(IllegalStateException.class);
        myList.add(randomAlphabetic(6));
    }

    /**
     * this is for void return type
     */
    @Test(expected = NullPointerException.class)
    public void test_when_then_4() {
        doThrow(NullPointerException.class).when(myList).clear();
        myList.clear();
    }

    @Test(expected = IllegalStateException.class)
    public void test_when_then_5() {
        when(myList.add(anyString()))
                .thenReturn(false)
                .thenThrow(IllegalStateException.class);
        myList.add(randomAlphabetic(6)); //this one will not throw exception
        myList.add(randomAlphabetic(6)); //this one will throw exception
    }

    @Test
    public void test_when_then_6() {
        when(myList.size()).thenCallRealMethod();
        assertThat(myList.size(), equalTo(1));
    }

    @Test
    public void test_when_then_7() {
        doAnswer(invocation -> "Always the same").when(myList).get(anyInt());
        String element = myList.get(1);
        assertThat(element, is(equalTo("Always the same")));
    }
}
