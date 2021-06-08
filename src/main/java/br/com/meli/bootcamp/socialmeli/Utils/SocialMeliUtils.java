package br.com.meli.bootcamp.socialmeli.Utils;

import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDetail;

public abstract class SocialMeliUtils {

    public static UserDetail getUserDetails(GlobalUserDto globalUserDto){
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(globalUserDto.getUserId());
        userDetail.setUserName(globalUserDto.getUserName());
        return userDetail;
    }
}
