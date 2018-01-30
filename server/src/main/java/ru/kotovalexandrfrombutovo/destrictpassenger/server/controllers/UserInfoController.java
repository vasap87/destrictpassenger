package ru.kotovalexandrfrombutovo.destrictpassenger.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kotovalexandrfrombutovo.destrictpassenger.common.DTO.UserInfoDTO;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.persistence.services.IUserInfoPersistenceService;

/**
 * Created by alexkotov on 24.01.18.
 */
@RestController
@RequestMapping("/userservice")
public class UserInfoController {

    @Autowired
    private IUserInfoPersistenceService userInfoPersistenceService;

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<UserInfoDTO> addUser(@RequestBody UserInfoDTO userInfoDTO){
        return new ResponseEntity<UserInfoDTO>(userInfoPersistenceService.saveUserInfo(userInfoDTO), HttpStatus.OK);
    }

    @RequestMapping("/isactive")
    @ResponseBody
    public ResponseEntity<UserInfoDTO> getUserByUuid(@RequestBody String phone){
        UserInfoDTO userInfoDTO = userInfoPersistenceService.getUserByPhone(phone);
        if(userInfoDTO!=null){
            return new ResponseEntity<UserInfoDTO>(userInfoDTO, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<UserInfoDTO>(HttpStatus.BAD_REQUEST);
        }
    }


}
