package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;
import br.com.meli.bootcamp.socialmeli.model.dto.ProductDto;

import java.io.IOException;

public interface ProductRepository {

    ProductDto getProductById (int productId) throws NotFoundException, IOException;


}
