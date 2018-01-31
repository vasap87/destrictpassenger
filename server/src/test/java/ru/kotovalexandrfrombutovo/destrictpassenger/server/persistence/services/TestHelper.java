package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.LocationENUM;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;

import java.util.UUID;

/**
 * Created by vasap87 on 27.01.18.
 */
public class TestHelper {
    public static UserInfoDTO getUserInfoDTO() {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName("test user name");
        userInfoDTO.setUuid(UUID.randomUUID().toString());
        userInfoDTO.setActive(true);
        userInfoDTO.setPhone("+7(999)123-12-12");
        return userInfoDTO;
    }

    public static RouteDTO getRouteDTO() {
        UserInfoDTO userInfoDTO = getUserInfoDTO();
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setActive(true);
        routeDTO.setUser(userInfoDTO);
        routeDTO.setFromRoute("froooom");
        routeDTO.setToRoute("toooo");
        routeDTO.setLocation(LocationENUM.BUTOVSKIEALLEI);
        routeDTO.setStartDateTime(System.currentTimeMillis()+1000*60*5);
        return routeDTO;
    }
}
