package com.grinyov.spring.rest_client.web;

import com.google.common.collect.ImmutableList;
import com.grinyov.spring.rest_client.model.StackOverflowWebsite;
import com.grinyov.spring.rest_client.service.StackoverflowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vgrinyov.
 */
@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {

    @Mock
    private StackoverflowService stackoverflowService;
    @InjectMocks
    StackOverflowController soc;

//    @Before
//    public void setUp() throws Exception {
//        soc = new StackOverflowController();
//    }

    @Test
    public void getListofProviders() throws Exception {
        // prepare section

        StackOverflowWebsite website = new StackOverflowWebsite();

        when(stackoverflowService.findAll()).thenReturn(ImmutableList.of());

        // testing section

        List<StackOverflowWebsite> listOfProviders =  soc.getListOfProviders();

        // validate section

        verify(stackoverflowService).findAll();
    }

}