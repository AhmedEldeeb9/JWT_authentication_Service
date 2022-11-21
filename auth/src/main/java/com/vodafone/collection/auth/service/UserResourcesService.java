package com.vodafone.collection.auth.service;


import com.vodafone.collection.auth.entity.Configuration;
import com.vodafone.collection.auth.repo.ConfigurationRepository;
import com.vodafone.collection.auth.repo.UserResourcesRepository;
import com.vodafone.collection.auth.utility.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserResourcesService {


    @Autowired
    private UserResourcesRepository userResourcesRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String generateToken(String userName) throws Exception {

        String token = "";

        Long userId = userResourcesRepository.findUserCodeByName(userName);
        List<Long> allUserResources = userResourcesRepository.getAllUserResources(userId);
        List<Long> allUserTeamResources = userResourcesRepository.getAllUserTeamResources(userId);
        List<Long> allUserDepartmentResources = userResourcesRepository.getAllDepartmentResources(userId);
        HashSet<Long> userFinalResources = new HashSet<>(allUserResources);
        userFinalResources.addAll(allUserDepartmentResources);
        userFinalResources.addAll(allUserTeamResources);
        token = jwtTokenUtil.generateToken(userName, (ArrayList<Long>) userFinalResources.stream().collect(Collectors.toList()));

        return token;

    }

}
