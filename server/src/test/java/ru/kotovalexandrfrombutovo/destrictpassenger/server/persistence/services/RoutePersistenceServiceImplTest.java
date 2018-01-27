package ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.utils.JpaConfiguration;

import static org.junit.Assert.*;

/**
 * Created by vasap87 on 27.01.18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaConfiguration.class)
@Transactional
public class RoutePersistenceServiceImplTest {

    private final UserInfoDTO userInfoDTO = TestHelper.getUserInfoDTO();

    @Autowired
    private IRoutePersistenceService routePersistenceService;
    @Autowired
    private IUserInfoPersistenceService userInfoPersistenceService;

    @Test
    public void saveRoute() throws Exception {
        RouteDTO routeDTO = TestHelper.getRouteDTO();
        routeDTO.setUser(userInfoDTO);

        assertNull(routeDTO.getId());

        userInfoPersistenceService.saveUserInfo(userInfoDTO);

        RouteDTO savedRouteDTO = routePersistenceService.saveRoute(routeDTO);

        assertNotNull(savedRouteDTO);
        assertNotNull(savedRouteDTO.getId());
        assertEquals(savedRouteDTO.getUser().getUuid(),userInfoDTO.getUuid());

    }
}