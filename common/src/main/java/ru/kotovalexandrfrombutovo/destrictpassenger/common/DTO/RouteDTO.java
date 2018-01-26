package ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to define route.
 * Alexandr Kotov 29.11.2017
 */
public class RouteDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("user")
    private UserInfoDTO user;
    @JsonProperty("fromRoute")
    private String fromRoute;
    @JsonProperty("toRoute")
    private String toRoute;
    @JsonProperty("startDateTime")
    private Long startDateTime;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("isDriver")
    private Boolean isDriver;

    public Boolean getDriver() {
        return isDriver;
    }

    public void setDriver(Boolean driver) {
        isDriver = driver;
    }

    public RouteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfoDTO getUser() {
        return user;
    }

    public void setUser(UserInfoDTO user) {
        this.user = user;
    }

    public String getFromRoute() {
        return fromRoute;
    }

    public void setFromRoute(String fromRoute) {
        this.fromRoute = fromRoute;
    }

    public String getToRoute() {
        return toRoute;
    }

    public void setToRoute(String toRoute) {
        this.toRoute = toRoute;
    }

    public Long getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Long startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

}
