package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities.RouteEntity;

import java.util.List;

/**
 * Created by alexkotov on 29.11.17.
 */
@Transactional
public interface RouteRepository extends CrudRepository<RouteEntity, Long> {
    @Query(value = "select r from RouteEntity r where r.isActive = true")
    List<RouteEntity> getActiveRoutes();

    @Query(value = "select r from RouteEntity r where r.userUuid = ?1")
    List<RouteEntity> getRouteByUser(String userUuid);
}