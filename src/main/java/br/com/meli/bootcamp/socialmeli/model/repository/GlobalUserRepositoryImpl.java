package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.Utils.SocialMeliUtils;
import br.com.meli.bootcamp.socialmeli.exception.UserNotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.GlobalUserDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDetail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class GlobalUserRepositoryImpl implements GlobalUserRepository {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public GlobalUserDto findGlobalUserById(int userId) throws UserNotFoundException, IOException {
        List<GlobalUserDto> users = loadDataBase();
        GlobalUserDto result = null;
        if (users != null) {
            Optional<GlobalUserDto> item = users.stream()
                    .filter(userDto -> userDto.getUserId() == userId)
                    .findFirst();
            if (!item.isPresent()) {
                throw new UserNotFoundException("User not found!");
            }
            result = item.get();
        }

        return result;
    }

    @Override
    public GlobalUserDto findSellerUserById(int userId) throws IOException, Exception {
        List<GlobalUserDto> users = loadDataBase();
        GlobalUserDto result = null;
        if (users != null) {
            Optional<GlobalUserDto> item = users.stream()
                    .filter(sellerUser -> sellerUser.getUserId() == userId && sellerUser.isSeller())
                    .findFirst();
            if (!item.isPresent()) {
                throw new Exception("Seller not found!");
            }
            result = item.get();
        }

        return result;
    }

    @Override
    public GlobalUserDto followSellerUser(int userId, GlobalUserDto sellerUser) throws Exception {
        File file = ResourceUtils.getFile("files/globalUsers.json");
        List<GlobalUserDto> userDtoList = loadDataBase();

        GlobalUserDto user = this.findGlobalUserById(userId);

        int indexGlobalUser = userDtoList.indexOf(user);
        int indexSellerUser= userDtoList.indexOf(sellerUser);
        if (!user.getFollowed().contains(sellerUser)) {
            user.getFollowed().add(SocialMeliUtils.getUserDetails(sellerUser));
            sellerUser.getFollowers().add(SocialMeliUtils.getUserDetails(user));
        }
        userDtoList.set(indexGlobalUser, user);
        userDtoList.set(indexSellerUser, sellerUser);
        mapper.writeValue(file, userDtoList);
        return user;
    }

    private List<GlobalUserDto> loadDataBase() throws IOException {

        File file = ResourceUtils.getFile("files/globalUsers.json");
        ;
        List<GlobalUserDto> users = null;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<GlobalUserDto>> typeRef = new TypeReference<List<GlobalUserDto>>() {
        };

        users = objectMapper.readValue(file, typeRef);

        return users;
    }


}
