package ru.kotovalexandrfrombutovo.destrictpassenger.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.enities.UserInfoEntity;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services.IRoutePersistenceService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by alexkotov on 29.11.17.
 */

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private IRoutePersistenceService routePersistenceService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Collection<RouteDTO>> listRoute(@RequestHeader(value = "duration") Integer duration,
                                                          @RequestHeader(value = "locations") List<Integer> locations){
        Collection<RouteDTO> routeDTOCollection = routePersistenceService.getListActiveRoute(duration, locations);
        return new ResponseEntity<Collection<RouteDTO>>(routeDTOCollection, HttpStatus.OK);
    }

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Collection<RouteDTO>> listMineRoute(@RequestBody UserInfoEntity userInfo){
        Collection<RouteDTO> routeDTOCollection = routePersistenceService.getListRouteByUserUuid(userInfo.getUuid());
        return new ResponseEntity<Collection<RouteDTO>>(routeDTOCollection, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<RouteDTO> saveRoute(@RequestBody RouteDTO routeDTO){
        RouteDTO responseRoute = routePersistenceService.saveRoute(routeDTO);
        return new ResponseEntity<RouteDTO>(responseRoute, HttpStatus.OK);
    }



}
