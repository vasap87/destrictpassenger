package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by alexkotov on 29.11.17.
 */
public interface IRoutePersistenceService {

    RouteDTO saveRoute(RouteDTO routeDTO);
    void deleteRoute(RouteDTO routeDTO);
    Set<RouteDTO> getListRouteByUserUuid(String userUuid);
    Set<RouteDTO> getListActiveRoute(int duration, int location);
}
