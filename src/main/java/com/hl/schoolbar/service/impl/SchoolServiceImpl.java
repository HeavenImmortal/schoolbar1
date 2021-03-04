package com.hl.schoolbar.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hl.schoolbar.entity.School;
import com.hl.schoolbar.mapper.SchoolMapper;
import com.hl.schoolbar.service.SchoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hl.schoolbar.utils.PageBuilder;
import com.hl.schoolbar.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2021-02-04
 */
@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;

    /**
     * 添加学校
     * @param school
     * @return
     */
    @Override
    public Result insSchool(School school) {
        //设置学校的基础信息
        school.setIsDelete(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String  res = simpleDateFormat.format(date);
        System.out.println("============================"+res);
        school.setCreateDate(res);

        int i = schoolMapper.insSchool(school);
        if(i==1){
            return Result.ok("添加成功");
        }else {
            return Result.error("添加失败");
        }
    }

    /**
     * 修改学校信息
     * @param school
     * @return
     */
    @Override
    public Result updSchool(School school) {
        int i = schoolMapper.updSchool(school);
        if(i==1){
            return Result.ok("修改成功");
        }else {
            return Result.error("修改失败");
        }
    }

    /**
     * 删除学校
     * @param id
     * @return
     */
    @Override
    public Result delSchoolById(Integer id) {
        int i = schoolMapper.delSchoolById(id);
        if(i==1){
            return Result.ok("删除成功");
        }else {
            return Result.error("删除失败");
        }
    }

    /**
     * 分页查询学校
     * @param pageBuilder
     * @return
     */
    @Override
    public Result selPageSchool(PageBuilder pageBuilder) {
        System.out.println(pageBuilder);
        PageHelper.startPage(pageBuilder.getPageNum(),pageBuilder.getPageSize());
        List<HashMap<String,Object>> schoolList = schoolMapper.selPageSchool(pageBuilder.getSchoolQueryConditions());
        PageInfo<HashMap<String,Object>> pageInfo = new PageInfo<>(schoolList);
        return Result.ok().put("pageInfo",pageInfo);
    }

}
