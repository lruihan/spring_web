package com.fdu.rissy.mockito;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.*;

/**
 * Created by lins13 on 4/27/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoVerifyTest {

    @Mock
    private MyList myList;

    @BeforeClass
    public static void setup() {

    }
    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void test_verify_1() {
       myList.size();
       verify(myList).size();
    }
    @Test
    public void test_verify_2() {
        myList.size();
        verify(myList, times(1)).size();
    }

    @Test
    public void test_verify_3() {
        verifyZeroInteractions(myList);
    }
    @Test(expected = NoInteractionsWanted.class)
    public void test_verify_4() {
        myList.size();
        myList.clear();
        verify(myList).size();
        verifyNoMoreInteractions(myList);
    }
    @Test
    public void test_verify_5() {
        myList.size();
        myList.add("param");
        myList.clear();

        InOrder inOrder = Mockito.inOrder(myList);
        inOrder.verify(myList).size();
        inOrder.verify(myList).add("param");
        inOrder.verify(myList).clear();
    }
    @Test
    public void test_verify_6() {
        myList.size();
        verify(myList, never()).clear();
    }

    @Test
    public void test_verify_7() {
        myList.clear();
        myList.clear();
        myList.clear();

        verify(myList, atLeast(1)).clear();
        verify(myList, atMost(10)).clear();
    }

    @Test
    public void test_verify_8() {
        myList.addAll(Lists.newArrayList("someElement"));
        ArgumentCaptor<List> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(myList).addAll(argumentCaptor.capture());
        List<String> capturedArgument = (List<String>) argumentCaptor.getValue();
        assertThat(capturedArgument, hasItem("someElement"));
    }
}
