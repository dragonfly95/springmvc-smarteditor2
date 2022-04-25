package com.system.blog.post.mapper;

import com.system.blog.post.vo.PostVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface PostMapper {

    EgovMap getPost(String postId);


    int writeProcess(PostVO postVO);

    int deleteProcess(String id);

    int updateProcess(PostVO postVO);

}
