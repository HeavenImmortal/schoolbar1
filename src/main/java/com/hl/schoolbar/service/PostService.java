package com.hl.schoolbar.service;

import com.hl.schoolbar.entity.Comment;
import com.hl.schoolbar.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2021-02-26
 */
public interface PostService extends IService<Post> {

    /**
     * 添加贴子
     * @param post
     * @return
     */
    Result insPost(Post post);

    /**
     * 分页查询贴子
     * @param pageBuilder
     * @return
     */
    Result selPagePost(PageBuilder pageBuilder);

    /**
     * 修改贴子
     * @param post
     * @return
     */
    Result updPost(Post post);

    /**
     * 删除帖子
     * @param id
     * @return
     */
    Result delPostById(Integer id);

    /**
     * 查询贴子详情
     * @param id
     * @return
     */
    Result selPostInfoById(Integer id);

    /**
     * 删除评论
     * @param id
     * @return
     */
    Result delCommentById(Integer id);

    /**
     * 查询评论
     * @param comment
     * @return
     */
    Result insComment(Comment comment);

    /**
     * 查询评论
     * @param postId
     * @param type 1 由新到旧 0由旧到新
     * @return
     */
    Result selComment(Integer postId,Integer type);

    /**
     * 对点赞或点踩进行操作
     * @param userId
     * @param postId
     * @param type 1.表示点赞 0表示点踩
     * @param operationType 1表示点击 0表示取消
     * @return
     */
    Result gradeOperation(Integer userId,Integer postId,Integer type,Integer operationType);
}
