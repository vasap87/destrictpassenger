package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;

/**
 * Created by alexkotov on 24.01.18.
 */
public interface IUserInfoPersistenceService {
    UserInfoDTO saveUserInfo(UserInfoDTO userInfoEntity);
    UserInfoDTO getUserByPhone(String userUuid);
}
