package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.model.dto.SellerDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository {

    SellerDto findById(int sellerId);
    List<UserDto> findFollowers (int sellerId);


}
