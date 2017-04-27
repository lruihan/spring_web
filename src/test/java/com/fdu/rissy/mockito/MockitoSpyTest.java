package com.fdu.rissy.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by lins13 on 4/27/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoSpyTest {

    @Spy
    private List<String> spyList = new ArrayList<>();

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_spy_1() {
        spyList.add("one");
        spyList.add("two");
        verify(spyList).add("one");
        verify(spyList).add("two");
        assertEquals(2, spyList.size());
    }

    @Test
    public void test_spy_2() {
        assertEquals(0, spyList.size());
        doReturn(100).when(spyList).size();
        assertEquals(100, spyList.size());
    }
}
