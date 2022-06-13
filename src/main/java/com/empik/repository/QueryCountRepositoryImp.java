package com.empik.repository;

import com.empik.entity.QueryCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QueryCountRepositoryImp {

    @Autowired
    private QueryCountRepository queryCountRepository;

    public QueryCount findQueriesCountByLogin(String login) {
        return queryCountRepository.findById(login).orElse(null);
    }

    public void saveQueriesCount(QueryCount queryCount) {
        queryCountRepository.save(queryCount);
    }
}
