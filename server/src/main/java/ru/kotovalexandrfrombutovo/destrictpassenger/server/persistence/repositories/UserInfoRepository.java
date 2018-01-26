package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities.UserInfoEntity;

/**
 * Created by alexkotov on 24.01.18.
 */
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, Long> {
    @Query(value = "select u from UserInfoEntity u where u.phone = ?1")
    UserInfoEntity getUserInfoByPhone(String phone);
}
