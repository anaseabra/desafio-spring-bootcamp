package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.model.dto.SellerDto;
import br.com.meli.bootcamp.socialmeli.model.dto.UserDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class SellerRepositoryImpl implements SellerRepository{

    @Override
    public SellerDto findById(int sellerId) {
        List<SellerDto> sellerDtos = loadDataBase();
        SellerDto result = null;
        if(sellerDtos != null){
            Optional<SellerDto> item = sellerDtos.stream()
                    .filter(sellerDto -> sellerDto.getSellerId() == sellerId)
                    .findFirst();
            if(item.isPresent()){
                result = item.get();
            }
        }

        return result;
    }

    @Override
    public List<UserDto> findFollowers(int sellerId) {
        SellerDto sellerDto = findById(sellerId);
        List<UserDto> followers = sellerDto.getFollowers();
        return followers;
    }


    private List<SellerDto> loadDataBase() {

        File file = null;
        List<SellerDto> sellerDtos = null;
        try{
            file = ResourceUtils.getFile("src/main/resources/sellers.json");

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<SellerDto>> typeRef = new TypeReference<List<SellerDto>>() {};

            sellerDtos = objectMapper.readValue(file, typeRef);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sellerDtos;
    }
}
