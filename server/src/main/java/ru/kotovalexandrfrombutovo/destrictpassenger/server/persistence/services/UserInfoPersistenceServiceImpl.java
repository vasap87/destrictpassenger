package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories.UserInfoRepository;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.transformers.UserInfoTransformer;

/**
 * Created by alexkotov on 24.01.18.
 */
@Service
public class UserInfoPersistenceServiceImpl implements IUserInfoPersistenceService {

    private UserInfoTransformer transformer;

    @Autowired
    private UserInfoRepository repository;

    public UserInfoPersistenceServiceImpl() {
        transformer = Mappers.getMapper(UserInfoTransformer.class);
    }

    @Override
    public UserInfoDTO saveUserInfo(UserInfoDTO userInfoDTO) {
        return transformer.userInfoEntityToDto(repository.save(transformer.userInfoDtoToEntity(userInfoDTO)));
    }

    @Override
    public UserInfoDTO getUserByPhone(String phoneNumber) {
        return transformer.userInfoEntityToDto(repository.getUserInfoByPhone(phoneNumber));
    }
}
