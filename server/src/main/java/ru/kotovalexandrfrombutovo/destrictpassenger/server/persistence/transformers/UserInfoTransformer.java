package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.transformers;

import org.mapstruct.Mapper;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities.UserInfoEntity;

/**
 * Created by alexkotov on 24.01.18.
 */
@Mapper
public interface UserInfoTransformer {

    UserInfoEntity userInfoDtoToEntity(UserInfoDTO userInfoDTO);
    UserInfoDTO userInfoEntityToDto(UserInfoEntity userInfoEntity);

}
