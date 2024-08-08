package com.system.blog.post.mapper;

import com.system.blog.config.PageVO;
import com.system.blog.post.vo.PostVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import java.util.List;

public interface PostMapper {

    PostVO getPost(String postId);


    int writeProcess(PostVO postVO);

    int deleteProcess(String id);

    int updateProcess(PostVO postVO);

    List<PostVO> getSearch(PageVO page);

    int getTotal(PageVO page);

    /** 이전게시물     */
    PostVO prevPost(String postId);

    /* 다음게시물 */
    PostVO nextPost(String postId);
}
