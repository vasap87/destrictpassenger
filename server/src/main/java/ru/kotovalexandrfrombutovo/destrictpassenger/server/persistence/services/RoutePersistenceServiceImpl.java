package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories.RouteRepository;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.transformers.RouteTransformer;

import java.util.ArrayList;
import java.util.List;

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

    public void saveRoute(RouteDTO routeDTO) {
        repository.save(transformer.routeDtoToEntity(routeDTO));
    }

    public void deleteRoute(RouteDTO routeDTO) {
        repository.delete(routeDTO.getId());
    }

    public List<RouteDTO> getListRouteByUserUuid(String userUuid) {
        List<RouteDTO> result = new ArrayList<>();
        repository.getRouteByUser(userUuid).forEach(route -> result.add(transformer.routeEntityToDto(route)));
        return result;
    }

    public List<RouteDTO> getListActiveRoute() {
        List<RouteDTO> result = new ArrayList<>();
        repository.getActiveRoutes().forEach(route -> result.add(transformer.routeEntityToDto(route)));
        return result;
    }
}
