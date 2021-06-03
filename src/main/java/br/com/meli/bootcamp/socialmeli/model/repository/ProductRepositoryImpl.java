package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;
import br.com.meli.bootcamp.socialmeli.model.dto.ProductDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Override
    public ProductDto getProductById(int productId) throws NotFoundException, IOException {
        List<ProductDto> users = loadDataBase();
        ProductDto result = null;
        if (users != null) {
            Optional<ProductDto> item = users.stream()
                    .filter(productDto -> productDto.getProductId() == productId)
                    .findFirst();
            if (!item.isPresent()) {
                throw new NotFoundException("Product not found!");
            }
            result = item.get();
        }

        return result;
    }

    private List<ProductDto> loadDataBase() throws IOException {

        File file = ResourceUtils.getFile("files/products.json");
        ;
        List<ProductDto> users = null;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<ProductDto>> typeRef = new TypeReference<>() {
        };

        users = objectMapper.readValue(file, typeRef);

        return users;
    }
}
