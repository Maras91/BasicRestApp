package com.empik.service;

import com.empik.entity.QueryCount;
import com.empik.repository.QueryCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryCountService {

    @Autowired
    private QueryCountRepository queryCountService;

    public void increaseQueryCount(String login) {
        QueryCount queryCount = queryCountService.findByLogin(login)
                .orElseGet(() -> new QueryCount(login));
        queryCount.setRequestCount(queryCount.getRequestCount() + 1);
        queryCountService.save(queryCount);
    }
}
