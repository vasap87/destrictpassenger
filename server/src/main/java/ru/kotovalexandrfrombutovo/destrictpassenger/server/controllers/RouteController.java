package ru.kotovalexandrfrombutovo.destrictpassenger.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.RouteDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services.IRoutePersistenceService;

import java.util.Collection;

/**
 * Created by alexkotov on 29.11.17.
 */

@RestController
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private IRoutePersistenceService routePersistenceService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Collection<RouteDTO>> listRoute(){
        Collection<RouteDTO> routeDTOCollection = routePersistenceService.getListActiveRoute();
        return new ResponseEntity<Collection<RouteDTO>>(routeDTOCollection, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<RouteDTO> saveRoute(@RequestBody RouteDTO routeDTO){
        RouteDTO responseRoute = routePersistenceService.saveRoute(routeDTO);
        return new ResponseEntity<RouteDTO>(responseRoute, HttpStatus.OK);
    }



}
