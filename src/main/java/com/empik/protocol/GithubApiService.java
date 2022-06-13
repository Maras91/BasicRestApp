package com.empik.protocol;

import com.empik.exeption.UserNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubApiService {

    RestTemplate restTemplate = new RestTemplate();

    public ApiUser getCustomerFromApi(String login) {
        RequestEntity<Void> request = RequestEntity
                .get("https://api.github.com/users/{login}", login)
                .accept(MediaType.APPLICATION_JSON).build();

        ResponseEntity<ApiUser> response;
        try {
            response = restTemplate.exchange(request, ApiUser.class);
        } catch (HttpClientErrorException e) {
            throw new UserNotFoundException(e.getMessage());
        }


        return response.getBody();
    }
}
