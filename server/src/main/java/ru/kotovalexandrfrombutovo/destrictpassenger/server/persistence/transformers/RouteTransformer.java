package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.transformers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities.RouteEntity;

/**
 * Created by alexkotov on 29.11.17.
 */
@Mapper(uses = UserInfoMapper.class)
public interface RouteTransformer {


    RouteEntity routeDtoToEntity(RouteDTO routeDTO);

    RouteDTO routeEntityToDto(RouteEntity routeEntity);
}
