package test.tecnico.wolox.main.repositories.remote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

@Repository
public class CommentRepositoryImplRemote implements ICommentRepositoryRemote {

	private String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Object[] findByName(String name) {
		return restTemplate.getForObject(EXTERNAL_API_URL + "/comments?name=" + name, Object[].class);
	}

	@Override
	public List<?> findByUserId(int userId) {

		ArrayNode posts = restTemplate.getForObject(EXTERNAL_API_URL + "/posts?userId=" + userId, ArrayNode.class);

		List<Object> comments = new ArrayList();

		for (JsonNode post : posts) {
			ArrayNode commentsTemp = restTemplate.getForObject(EXTERNAL_API_URL + "/comments?postId=" + post.get("id"), ArrayNode.class);
			for (JsonNode comment : commentsTemp) {
				comments.add(comment);
			}
		}

		return comments;
	}
}
