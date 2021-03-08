package com.hl.schoolbar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.schoolbar.entity.Comment;
import com.hl.schoolbar.entity.Post;
import com.hl.schoolbar.mapper.PostMapper;
import com.hl.schoolbar.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-02-26
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Resource
    private PostMapper postMapper;

    /**
     * 添加贴子
     * @param post
     * @return
     */
    @Override
    public Result insPost(Post post) {
        try{
            System.out.println(post);
            //设置数据
            post.setIsDelete(0);
            post.setCreateDate(System.currentTimeMillis());
            int i = postMapper.insPost(post);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("添加失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("添加失败");
        }
    }

    /**
     * 分页查询贴子
     * @param pageBuilder
     * @return
     */
    @Override
    public Result selPagePost(PageBuilder pageBuilder) {
        PageHelper.startPage(pageBuilder.getPageNum(),pageBuilder.getPageSize());
        List<HashMap<String ,Object>> postList = postMapper.selPagePost(pageBuilder.getPostQueryConditions());
        for(int i = 0 ;i<postList.size();i++){
            int postId = Integer.parseInt(postList.get(i).get("postId").toString());
            System.out.println(postList.get(i));
            int commentNum = postMapper.selCommentNum(postId);
            postList.get(i).put("commentNum",commentNum);
            int praiseNum = postMapper.selPostPraiseNum(postId);
            postList.get(i).put("praiseNum",praiseNum);
            int setpOnNum = postMapper.selPostStepOnNum(postId);
            postList.get(i).put("setpOnNum",setpOnNum);
        }

        PageInfo<HashMap<String ,Object>> pageInfo = new PageInfo<>(postList);
        return Result.ok().put("pageInfo",pageInfo);
    }

    /**
     * 修改贴子
     * @param post
     * @return
     */
    @Override
    public Result updPost(Post post) {
        try{
            int i  = postMapper.updPost(post);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("修改失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("修改失败");
        }
    }

    /**
     * 删除贴子
     * @param id
     * @return
     */
    @Override
    public Result delPostById(Integer id) {
        try{
            int i  = postMapper.delPost(id);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }

    /**
     * 查询贴子详情
     * @param id
     * @return
     */
    @Override
    public Result selPostInfoById(Integer id) {
        HashMap<String ,Object> postInfo = postMapper.selPostInfoById(id);
        int postId = Integer.parseInt(postInfo.get("postId").toString());
        int commentNum = postMapper.selCommentNum(postId);
        postInfo.put("commentNum",commentNum);
        int praiseNum = postMapper.selPostPraiseNum(postId);
        postInfo.put("praiseNum",praiseNum);
        int setpOnNum = postMapper.selPostStepOnNum(postId);
        postInfo.put("setpOnNum",setpOnNum);
        return Result.ok().put("postInfo",postInfo);
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
    @Override
    public Result delCommentById(Integer id) {
        try{
            int i = postMapper.delCommentById(id);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("删除失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("删除失败");
        }
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public Result insComment(Comment comment) {
        try{
            comment.setCreateDate(System.currentTimeMillis());
            int floor = 1;
            if(comment.getReplyId()==0){
                floor = postMapper.selectFloorByPostId(comment.getPostId());
            }
            comment.setFloor(floor);
            int i = postMapper.insComment(comment);
            if(i==1){
                return Result.ok();
            }else {
                return Result.error("回复失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            return Result.error("回复失败");
        }
    }

    /**
     * 查询评论
     * @param postId
     * @param type 1 由新到旧 0由旧到新
     * @return
     */
    @Override
    public Result selComment(Integer postId, Integer type) {
        List<HashMap<String ,Object>> commentList = postMapper.selParentComment(postId,type);
        commentList.forEach(e->{
            int commentPid = Integer.parseInt(e.get("commentId").toString());
            List<HashMap<String ,Object>> sonCommentList = postMapper.selSonCommentByCommentPid(commentPid,postId);
            e.put("isHasSonComment",false);
            if(sonCommentList.size()!=0){
                e.put("isHasSonComment",true);
            }
            e.put("sonCommentList",sonCommentList);
        });
        return Result.ok().put("commentList",commentList);
    }

    /**
     * 对点赞数或点踩数的操作
     * @param userId
     * @param postId
     * @param type 1.表示点赞 0表示点踩
     * @param operationType 1表示点击 0表示取消
     * @return
     */
    @Override
    public Result gradeOperation(Integer userId, Integer postId, Integer type, Integer operationType) {
       try{
            if(operationType==1){
                int i = postMapper.insUserPostGrade(userId, postId, type);
                if(i==1){
                    return Result.ok();
                }else {
                    if(type==1){
                        return Result.error("点赞失败");
                    }else {
                        return Result.error("点踩失败");
                    }
                }
            }
            else {
                int i = postMapper.delUserPostGrade(userId, postId, type);
                if(i==1){
                    return Result.ok();
                }else {
                    if(type==1){
                        return Result.error("取消点赞失败");
                    }else {
                        return Result.error("取消点踩失败");
                    }
                }
            }
       }catch(Exception e){
           e.printStackTrace();
            return Result.error("系统异常");
       }
    }

    /**
     * 查询用户与评价贴子的关联
     * @param userId
     * @return
     */
    @Override
    public Result selUserGradePost(Integer userId) {
        List<HashMap<String ,Object>> gradePostList = postMapper.selUserGradePost(userId);
        return Result.ok().put("gradePostList",gradePostList);
    }
}
