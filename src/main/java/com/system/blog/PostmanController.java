package com.system.blog;

import com.system.blog.post.mapper.PostMapper;
import com.system.blog.post.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
public class PostmanController {

    @Autowired
    private PostMapper postMapper;

    // 조회
    @RequestMapping(value = "postman", method = RequestMethod.GET)
    private @ResponseBody List<PostVO> getPost() {
        List<PostVO> search = postMapper.getSearch();
//        return ResponseEntity.ok().body(search);
        return search;
    }

    // 등록
    @RequestMapping(value = "postman", method = RequestMethod.POST)
    private @ResponseBody PostVO save(@RequestBody PostVO postVO) {
        postMapper.writeProcess(postVO);
        return postVO;
    }
    // 수정
    @RequestMapping(value = "postman/{id}", method = RequestMethod.PUT)
    private @ResponseBody ResponseVO update(@RequestBody PostVO postVO) {
        postMapper.updateProcess(postVO);
        return new ResponseVO("SAVED");
    }

    // 삭제
    @RequestMapping(value = "postman/{id}", method = RequestMethod.DELETE)
    private @ResponseBody ResponseVO delete(@PathVariable String id) {
        postMapper.deleteProcess(id);
        return new ResponseVO("DELETED");
    }
}


