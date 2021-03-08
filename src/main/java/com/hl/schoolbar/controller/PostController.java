package com.hl.schoolbar.controller;


import com.github.pagehelper.PageHelper;
import com.hl.schoolbar.entity.Comment;
import com.hl.schoolbar.entity.Post;
import com.hl.schoolbar.service.PostService;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2021-02-26
 */
@Api(tags = "贴子管理")
@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postServiceImpl;

    /**
     * 添加贴子
      * @param post
     * @return
     */
    @ApiOperation(value="添加贴子", notes="post请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "title", value = "标题", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "description", value = "描述", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "content", value = "内容", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "user_id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "school_id", value = "学校id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/insPost",method = RequestMethod.POST)
    public Result insPost(@RequestBody Post post){
        return postServiceImpl.insPost(post);
    }


    /**
     * 查询贴子
     * @param pageBuilder
     * @return
     */
    @ApiOperation(value="查询贴子", notes="post请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "每页大小", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "title", value = "标题", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "content", value = "内容", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "user_id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "school_id", value = "学校id", required = false, dataType = "Integer"),
    })
    @RequestMapping(value = "/selPagePost",method = RequestMethod.POST)
    public Result selPagePost(@RequestBody PageBuilder pageBuilder){
        return postServiceImpl.selPagePost(pageBuilder);
    }

    /**
     * 查询贴子详情
     * @param id
     * @return
     */
    @ApiOperation(value="查询贴子详情", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "贴子id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/selPostInfoById",method = RequestMethod.GET)
    public Result selPostInfoById(Integer id){
        return postServiceImpl.selPostInfoById(id);
    }

    /**
     * 删除贴子
     * @param id
     * @return
     */
    @ApiOperation(value="删除贴子", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "贴子id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/delPostById",method = RequestMethod.GET)
    public Result delPostById(Integer id){
        return postServiceImpl.delPostById(id);
    }

    /**
     * 修改贴子
     * @param post
     * @return
     */
    @ApiOperation(value="修改贴子", notes="post请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "postId", value = "贴子id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "title", value = "标题", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "description", value = "描述", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "content", value = "内容", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/updPost",method = RequestMethod.POST)
    public Result updPost(@RequestBody Post post){
        return postServiceImpl.updPost(post);
    }


    /**
     * 删除评论
     * @param id
     * @return
     */
    @ApiOperation(value="删除评论", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "id", value = "评论id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/delCommentById",method = RequestMethod.GET)
    public Result delCommentById(Integer id){
        return postServiceImpl.delCommentById(id);
    }


    /**
     * 发布评论
     * @param comment
     * @return
     */
    @ApiOperation(value="发布评论", notes="post请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "content", value = "评论内容", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "postId", value = "贴子id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "commentPid", value = "回复主评论id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "replyId", value = "回复的id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/insComment",method = RequestMethod.POST)
    public Result insComment(@RequestBody Comment comment){
        return postServiceImpl.insComment(comment);
    }

    /**
     * 查询评论
     * @param postId
     * @param type
     * @return
     */
    @ApiOperation(value="查询评论", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "postId", value = "贴子id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "type", value = "查询方式 1由新到旧 0由旧到新", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/selComment",method = RequestMethod.GET)
    public Result selComment(Integer postId,Integer type){
        return postServiceImpl.selComment(postId, type);
    }

    /**
     * 点赞点踩操作
     * @param userId
     * @param postId
     * @param type 1点赞数 0 点踩数
     * @param operationType 1 点击 0取消
     * @return
     */
    @ApiOperation(value="点赞点踩操作", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "postId", value = "贴子id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "type", value = "1点赞数 0点踩数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "operationType", value = "操作类型 1点击 0 取消", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/gradeOperation",method = RequestMethod.GET)
    public Result gradeOperation(Integer userId, Integer postId, Integer type, Integer operationType){
        return postServiceImpl.gradeOperation(userId, postId, type, operationType);
    }

    @ApiOperation(value="点赞点踩操作", notes="get请求")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userId", value = "用户id", required = true, dataType = "Integer"),
    })
    @RequestMapping(value = "/selUserGradePost",method = RequestMethod.GET)
    public Result selUserGradePost(Integer userId){
        return postServiceImpl.selUserGradePost(userId);
    }
}
