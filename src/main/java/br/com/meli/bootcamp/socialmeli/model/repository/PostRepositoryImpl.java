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
import java.util.ArrayList;
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
        List<PostDto> posts = loadDataBase();
        PostDto result = null;
        if (posts != null) {
            Optional<PostDto> item = posts.stream()
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
    public List<PostDto> getPromoPosts(int userId) throws IOException {
        List<PostDto> promoPosts = new ArrayList<>();

        List<PostDto> posts = loadDataBase();

        if(posts != null){
            for (PostDto post: posts){
                if(post.getUserId() == userId && post.isHasPromo()){
                    promoPosts.add(post);
                }
            }
        }

        return promoPosts;
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
