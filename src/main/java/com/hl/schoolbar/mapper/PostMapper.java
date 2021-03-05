package com.hl.schoolbar.mapper;

import com.hl.schoolbar.entity.Comment;
import com.hl.schoolbar.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hl.schoolbar.utils.PostQueryConditions;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2021-02-26
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 分页查询贴子
     * @param postQueryConditions
     * @return
     */
    List<HashMap<String ,Object>> selPagePost(@Param("postQueryConditions") PostQueryConditions postQueryConditions);


    /**
     * 查看贴子详情
     * @param id
     * @return
     */
    HashMap<String,Object> selPostInfoById(@Param("id")Integer id);

    /**
     * 添加贴子
     * @param post
     * @return
     */
    int insPost(@Param("post")Post post);

    /**
     * 修改贴子
     * @param post
     * @return
     */
    int updPost(@Param("post")Post post);

    /**
     * 删除贴子
     * @param id
     * @return
     */
    int delPost(@Param("id")Integer id);

    /**
     * 查询评论数
     * @param postId
     * @return
     */
    int selCommentNum(@Param("postId")Integer postId);

    /**
     * 查询贴子点赞数
     * @param postId
     * @return
     */
    int selPostPraiseNum(@Param("postId")Integer postId);

    /**
     * 查询贴子点踩数
     * @param postId
     * @return
     */
    int selPostStepOnNum(@Param("postId")Integer postId);

    /**
     * 查询主评论
     * @param postId
     * @param type 1表示由新到旧 0表示由旧到新
     * @return
     */
    List<HashMap<String ,Object>> selParentComment(@Param("postId")Integer postId,@Param("type") Integer type);

    /**
     * 查询子评论
     * @param commentPid
     * @return
     */
    List<HashMap<String ,Object>> selSonCommentByCommentPid(@Param("commentPid")Integer commentPid);

    /**
     * 删除评论
     * @param id
     * @return
     */
    int delCommentById(@Param("id")Integer id);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    int insComment(@Param("comment")Comment comment);


    /**
     * 用户点赞或点踩
     * @param userId
     * @param postId
     * @param type 1为点赞 0为点踩
     * @return
     */
    int insUserPostGrade(@Param("userId")Integer userId,@Param("postId")Integer postId,@Param("type")Integer type);

    /**
     * 用户取消点赞或点踩
     * @param userId
     * @param postId
     * @param type 1为点赞 0为点踩
     * @return
     */
    int delUserPostGrade(@Param("userId")Integer userId,@Param("postId")Integer postId,@Param("type")Integer type);

    /**
     * 查询用户与评价过的贴子关联
     * @param userId
     * @return
     */
    List<HashMap<String ,Object>> selUserGradePost(@Param("userId")Integer userId);
}
