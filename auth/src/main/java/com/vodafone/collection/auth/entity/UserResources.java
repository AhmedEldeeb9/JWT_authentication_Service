package com.vodafone.collection.auth.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserResourcesKey.class)
@Table(name = "SE_USER_RESOURCES")
public class UserResources {

    @Id
    @Column(name = "USER_CODE")
    private Long userCode;

    @Id
    @Column(name = "RESOURCE_CODE")
    private Long resourceCode;

    @Column(name = "ENABLE_FLAG")
    private Long enableFlag;


    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public Long getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(Long resourceCode) {
        this.resourceCode = resourceCode;
    }

    public Long getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Long enableFlag) {
        this.enableFlag = enableFlag;
    }

}
