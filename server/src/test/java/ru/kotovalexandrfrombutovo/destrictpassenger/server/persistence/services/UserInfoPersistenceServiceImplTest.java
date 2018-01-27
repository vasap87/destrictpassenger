package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.utils.JpaConfiguration;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by vasap87 on 27.01.18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaConfiguration.class)
@Transactional
public class UserInfoPersistenceServiceImplTest {

    private final String phone = "1234567890";
    private final String userUuid = UUID.randomUUID().toString();

    @Autowired
    private IUserInfoPersistenceService userInfoPersistenceService;

    @Test
    public void saveUserInfo() throws Exception {
        UserInfoDTO userInfoDTO = TestHelper.getUserInfoDTO();
        UserInfoDTO savedUserInfoDTO = userInfoPersistenceService.saveUserInfo(userInfoDTO);

        assertNull(userInfoDTO.getId());
        assertNotNull(savedUserInfoDTO);
        assertNotNull(savedUserInfoDTO.getId());
    }

    @Test
    public void getUserByPhone() throws Exception {
        UserInfoDTO userInfoDTO1 = TestHelper.getUserInfoDTO();
        UserInfoDTO userInfoDTO2 = TestHelper.getUserInfoDTO();
        UserInfoDTO userInfoDTO3 = TestHelper.getUserInfoDTO();
        userInfoDTO3.setPhone(phone);
        userInfoDTO3.setUuid(userUuid);
        userInfoPersistenceService.saveUserInfo(userInfoDTO1);
        userInfoPersistenceService.saveUserInfo(userInfoDTO2);
        userInfoPersistenceService.saveUserInfo(userInfoDTO3);

        UserInfoDTO searchUserInfoDTO = userInfoPersistenceService.getUserByPhone(phone);

        assertNotNull(searchUserInfoDTO);
        assertNotNull(searchUserInfoDTO.getId());
        assertEquals(searchUserInfoDTO.getUuid(),userUuid);

    }

}