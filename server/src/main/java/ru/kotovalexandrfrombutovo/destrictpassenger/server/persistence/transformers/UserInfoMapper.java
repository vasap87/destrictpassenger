package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.transformers;

import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities.UserInfoEntity;

/**
 * Created by alexkotov on 26.01.18.
 */
public class UserInfoMapper {

    public UserInfoEntity map(UserInfoDTO dto){
        UserInfoEntity entity = new UserInfoEntity();
        entity.setId(dto.getId());
        entity.setActive(dto.getActive());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setUuid(dto.getUuid());
        return entity;
    }

    public UserInfoDTO map(UserInfoEntity entity){
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(entity.getId());
        dto.setActive(entity.getActive());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setUuid(entity.getUuid());
        return dto;
    }
}
