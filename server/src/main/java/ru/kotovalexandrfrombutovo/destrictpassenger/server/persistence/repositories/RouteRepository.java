package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities.RouteEntity;

import java.util.List;

/**
 * Created by alexkotov on 29.11.17.
 */
@Transactional
public interface RouteRepository extends CrudRepository<RouteEntity, Long> {
    @Query(nativeQuery = true, value = "select r.* from RouteEntity r where r.isActive = true and r.location in :locations and ((r.startDateTime - CAST((EXTRACT(EPOCH FROM now())*1000) as bigint))/60000) > - :duration" )
    List<RouteEntity> getActiveRoutes(@Param("duration") Integer diration, @Param("locations") List<Integer> locationIds);

    @Query(value = "select r from RouteEntity r where r.user = (select u from UserInfoEntity u where u.uuid = ?1)")
    List<RouteEntity> getRouteByUser(String userUuid);
}
