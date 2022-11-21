package com.vodafone.collection.auth.repo;

import com.vodafone.collection.auth.entity.UserResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserResourcesRepository extends JpaRepository<UserResources, Long> {


    @Query(value = "SELECT UR.RESOURCE_CODE" +
            "  FROM SE_USER_RESOURCES UR" +
            "  WHERE UR.USER_CODE = :userId" +
            "  AND UR.ENABLE_FLAG = 1", nativeQuery = true)
    public List<Long> getAllUserResources(@Param("userId") Long userId);


    @Query(value = "SELECT DR.RESOURCE_CODE" +
            "  FROM SE_DEPARTMENT_RESOURCES DR , APP_USER_TEAMS UT" +
            "  WHERE DR.DEPARTMENT_CODE = UT.DEPT_CODE" +
            "  AND UT.USER_CODE = :userId" +
            "  AND UT.EXPIRE_DATE IS NULL" +
            "  AND DR.RESOURCE_CODE NOT IN (" +
            "          SELECT S.RESOURCE_CODE" +
            "          FROM SE_TEAM_RESOURCES S ,APP_USER_TEAMS UT" +
            "          WHERE S.TEAM_CODE = UT.TEAM_CODE" +
            "          AND UT.USER_CODE = :userId" +
            "          AND UT.EXPIRE_DATE IS NULL" +
            "          AND S.ENABLE_FLAG = 0" +
            "          UNION" +
            "          SELECT UR.RESOURCE_CODE" +
            "          FROM SE_USER_RESOURCES UR" +
            "          WHERE UR.USER_CODE = :userId" +
            "          AND UR.ENABLE_FLAG = 0)", nativeQuery = true)
    public List<Long> getAllDepartmentResources(@Param("userId") Long UserId);

    @Query(value = "SELECT S.RESOURCE_CODE" +
            "  FROM SE_TEAM_RESOURCES S ,APP_USER_TEAMS UT" +
            "  WHERE S.TEAM_CODE = UT.TEAM_CODE" +
            "  AND UT.USER_CODE = :userId" +
            "  AND UT.EXPIRE_DATE IS NULL" +
            "  AND S.ENABLE_FLAG = 1" +
            "  AND   S.RESOURCE_CODE   NOT IN  (" +
            "                  SELECT UR.RESOURCE_CODE" +
            "                 FROM SE_USER_RESOURCES UR" +
            "                 WHERE UR.USER_CODE = :userId" +
            "                 AND UR.ENABLE_FLAG = 0)", nativeQuery = true)
    public List<Long> getAllUserTeamResources(@Param("userId") Long UserId);


    @Query(value = "SELECT USER_CODE" +
            "                         FROM APP_USER_DATA" +
            "                         WHERE USER_NAME = :userName", nativeQuery = true)
    public Long findUserCodeByName(@Param("userName") String userName);


}
