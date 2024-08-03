package com.system.blog.post.service;


import com.system.blog.Idgenerator;
import com.system.blog.config.PageVO;
import com.system.blog.post.mapper.PostMapper;
import com.system.blog.post.vo.PostVO;
import com.system.blog.user.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<PostVO> posts(PageVO page) {
        page.setTotal(postMapper.getTotal(page));

        int paramPage = page.getPage();
        int dbLastPage = page.getLastPage();

        if (paramPage > dbLastPage) {
            throw new RuntimeException("마지막 페이지가 아닙니다");
        }
        return postMapper.getSearch(page);
    }

    public PostVO view(String postId) {
        return postMapper.getPost(postId);
    }

    public int writeProcess(LoginVO loginVO, PostVO postVO) {
        postVO.setId(Idgenerator.getId());
        postVO.setUserId(loginVO.getUserId());
        return postMapper.writeProcess(postVO);
    }
}
