package com.system.blog.post.mapper;

import com.system.blog.post.vo.PostVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostMapper {

    PostVO getPost(String postId);


    int writeProcess(PostVO postVO);

    int deleteProcess(@Param("id") String id, @Param("userId") String userId);

    int updateProcess(PostVO postVO);

    List<PostVO> getSearch();

}
