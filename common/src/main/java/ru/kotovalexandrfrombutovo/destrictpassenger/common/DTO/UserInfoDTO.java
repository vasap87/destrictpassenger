package ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alexkotov on 24.01.18.
 */
public class UserInfoDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("name")
    private String name;
    @JsonProperty("isActive")
    private Boolean isActive;


    public UserInfoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
