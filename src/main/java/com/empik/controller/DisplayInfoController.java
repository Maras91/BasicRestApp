package com.empik.controller;

import com.empik.model.UserToShow;
import com.empik.protocol.ApiUser;
import com.empik.protocol.GithubApiService;
import com.empik.service.CalculationsService;
import com.empik.service.QueryCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisplayInfoController {

    @Autowired
    QueryCountService queryCountService;

    @Autowired
    GithubApiService githubApiService;

    @Autowired
    CalculationsService calculationsService;

    @GetMapping("users/{login}")
    public UserToShow getUser(@PathVariable("login") String login) {
        ApiUser apiUser = githubApiService.getCustomerFromApi(login);
        queryCountService.increaseQueryCount(login);
        return new UserToShow(apiUser.getId(),
                apiUser.getLogin(),
                apiUser.getName(),
                apiUser.getType(),
                apiUser.getAvatarUrl(),
                apiUser.getCreatedAt(),
                calculationsService.calculate((double) apiUser.getFollowers(), (double) apiUser.getPublicRepos()));
    }
}
