package com.fdu.rissy.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockSettings;
import org.mockito.exceptions.verification.TooLittleActualInvocations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by lins13 on 4/27/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoMockTest {

//    @Mock(name="myMock")
//    private MyList myList;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_mock_1() {
        MyList myList = mock(MyList.class);
        when(myList.add(anyString())).thenReturn(false);
        boolean added = myList.add(randomAlphabetic(6));
        verify(myList).add(anyString());
        assertThat(added, is(false));
    }

    @Test
    public void test_mock_2() {
        MyList myList = mock(MyList.class, "myMock");
        when(myList.add(anyString())).thenReturn(false);
        myList.add(randomAlphabetic(6));
        thrown.expect(TooLittleActualInvocations.class);
        thrown.expectMessage(containsString("myMock.add"));

        verify(myList, times(2)).add(anyString());
    }

    @Test
    public void test_mock_3() {
        MyList myList = mock(MyList.class, new CustomerAnswer());
        boolean added = myList.add(randomAlphabetic(6));
        verify(myList).add(anyString());
        assertThat(added, is(false));
    }

    @Test
    public void test_mock_4() {
        MockSettings mockSettings = withSettings().defaultAnswer(new CustomerAnswer());
        MyList myList = mock(MyList.class, mockSettings);
        boolean added = myList.add(randomAlphabetic(6));
        verify(myList).add(anyString());
        assertThat(added, is(false));
    }
    private static class CustomerAnswer implements Answer<Boolean> {

        @Override
        public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
            return false;
        }
    }
}
