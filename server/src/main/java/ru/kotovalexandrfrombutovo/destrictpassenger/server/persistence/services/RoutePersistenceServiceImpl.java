package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories.RouteRepository;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.transformers.RouteTransformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alexkotov on 29.11.17.
 */
@Service
public class RoutePersistenceServiceImpl implements IRoutePersistenceService {

    private RouteTransformer transformer;

    @Autowired
    private RouteRepository repository;

    public RoutePersistenceServiceImpl() {
        transformer = Mappers.getMapper(RouteTransformer.class);
    }

    public RouteDTO saveRoute(RouteDTO routeDTO) {
        return transformer.routeEntityToDto(repository.save(transformer.routeDtoToEntity(routeDTO)));
    }

    public void deleteRoute(RouteDTO routeDTO) {
        repository.delete(routeDTO.getId());
    }

    public Set<RouteDTO> getListRouteByUserUuid(String userUuid) {
        Set<RouteDTO> result = new HashSet<>();
        repository.getRouteByUser(userUuid).forEach(route -> result.add(transformer.routeEntityToDto(route)));
        return result;
    }

    public Set<RouteDTO> getListActiveRoute() {
        Set<RouteDTO> result = new HashSet<>();
        repository.getActiveRoutes().forEach(route -> result.add(transformer.routeEntityToDto(route)));
        return result;
    }
}
