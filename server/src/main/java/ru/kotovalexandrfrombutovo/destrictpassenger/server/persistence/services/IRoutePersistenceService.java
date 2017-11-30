package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;

import java.util.List;

/**
 * Created by alexkotov on 29.11.17.
 */
public interface IRoutePersistenceService {

    void saveRoute(RouteDTO routeDTO);
    void deleteRoute(RouteDTO routeDTO);
    List<RouteDTO> getListRouteByUserUuid(String userUuid);
    List<RouteDTO> getListActiveRoute();
}
