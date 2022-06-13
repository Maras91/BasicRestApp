package com.empik.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationsService {
    public Double calculate(double followers, double publicRepos) {
        if (followers * (2 + publicRepos) != 0) {
            return 6 / followers * (2 + publicRepos);
        } else {
            return null;
        }
    }
}
