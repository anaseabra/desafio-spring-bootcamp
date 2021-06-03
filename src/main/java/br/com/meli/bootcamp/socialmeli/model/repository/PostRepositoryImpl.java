package br.com.meli.bootcamp.socialmeli.model.repository;

import br.com.meli.bootcamp.socialmeli.exception.NotFoundException;
import br.com.meli.bootcamp.socialmeli.model.dto.PostDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository{

    private final File postFile = ResourceUtils.getFile("files/posts.json");
    private final File globalUserFile = ResourceUtils.getFile("files/globalUsers.json");
    private ObjectMapper mapper = new ObjectMapper();

    public PostRepositoryImpl() throws FileNotFoundException {
    }

    @Override
    public PostDto getPostById(int postId) throws NotFoundException, IOException {
        List<PostDto> users = loadDataBase();
        PostDto result = null;
        if (users != null) {
            Optional<PostDto> item = users.stream()
                    .filter(postDto -> postDto.getPostId() == postId)
                    .findFirst();
            if (!item.isPresent()) {
                throw new NotFoundException("Post not found!");
            }
            result = item.get();
        }

        return result;
    }

    @Override
    public PostDto createNewPost(PostDto postDto) throws IOException {
        List<PostDto> users = loadDataBase();

        users.add(postDto);
        mapper.writeValue(postFile, users);

        return postDto;
    }

    private List<PostDto> loadDataBase() throws IOException {

        List<PostDto> users = null;
        TypeReference<List<PostDto>> typeRef = new TypeReference<>() {};

        users = mapper.readValue(postFile, typeRef);

        return users;
    }
}
