package com.empik.controller;


import com.empik.model.UserToShow;
import com.empik.protocol.ApiUser;
import com.empik.protocol.GithubApiService;
import com.empik.service.QueryCountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DisplayInfoControllerTests {

    @MockBean
    QueryCountService queryCountService;

    @MockBean
    GithubApiService githubApiService;

    @Autowired
    DisplayInfoController displayInfoController;

    public static final long USER_ID = 123L;
    public static final String USER_LOGIN = "Mac";
    public static final String USER_NAME = "Smith";
    public static final String USER_TYPE = "User";
    public static final String USER_URL = "www.abc.pl/aaa.jpg";
    public static final LocalDateTime USER_CREATION_DATE = LocalDateTime.parse("2022-01-14T15:31:53.000");

    @Before
    public void init() {
        //given
        ApiUser user = new ApiUser();
        user.setId(USER_ID);
        user.setLogin(USER_LOGIN);
        user.setName(USER_NAME);
        user.setType(USER_TYPE);
        user.setAvatarUrl(USER_URL);
        user.setCreatedAt(USER_CREATION_DATE);
        user.setFollowers(3L);
        user.setPublicRepos(1L);
        Mockito.when(githubApiService.getCustomerFromApi("Smith")).thenReturn(user);
    }

    @Test
    public void apiUserMapTest() {
        //when
        UserToShow userToShow = displayInfoController.getUser("Smith");
        //then
        assertEquals(USER_ID, (long) userToShow.getId());
        assertEquals(USER_LOGIN, userToShow.getLogin());
        assertEquals(USER_NAME, userToShow.getName());
        assertEquals(USER_TYPE, userToShow.getType());
        assertEquals(USER_URL, userToShow.getAvatarUrl());
        assertEquals(USER_CREATION_DATE, userToShow.getCreatedAt());
    }

    @Test
    public void increaseQueryCountMethodCallTest() {
        //when
        Mockito.spy(queryCountService);
        displayInfoController.getUser("Smith");
        //then
        Mockito.verify(queryCountService, Mockito.times(1)).increaseQueryCount(any());
    }


}
