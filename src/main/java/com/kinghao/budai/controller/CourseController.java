package com.kinghao.budai.controller;

import com.kinghao.budai.annotation.Auth;
import com.kinghao.budai.dto.request.AddCourseRequest;
import com.kinghao.budai.dto.request.UpdateCourseRequest;
import com.kinghao.budai.dto.request.UpdateUserInfoRequest;
import com.kinghao.budai.entity.Course;
import com.kinghao.budai.enums.UserType;
import com.kinghao.budai.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author Kinghao
 * @Date 2020/10/23 16:06
 * @Version 1.0
 */
@Api(tags = "课程管理")
@RestController
@RequestMapping("/course")
@Validated
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "添加课程")
    @PostMapping("/add")
    public Object addCourse(@Valid AddCourseRequest addCourseRequest){
        courseService.addCourse(addCourseRequest);
        return "Add successfully!";
    }

    @ApiOperation(value = "删除指定课程（管理员）")
    @DeleteMapping("/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id",value = "待删除的课程id",required = true),
    })
    @Auth(value = UserType.ADMINISTRATION)
    public Object deleteCourse(Integer course_id){
        if(courseService.queryCourse(course_id)==null){
            return "Not Found!";
        }
        courseService.deleteCourse(course_id);
        return "Delete Successfully!";
    }

    @ApiOperation(value = "根据id查询课程（参与人数会随机返回）",response = Course.class)
    @GetMapping("/query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id",value = "待查询的课程id",required = true),
    })
    public Object queryCourse(Integer course_id){
        Course course=courseService.queryCourse(course_id);
        if(course==null){
            return "Not Found!";
        }
        return course;
    }

    @ApiOperation(value = "修改相应id的课程信息（管理员）")
    @PutMapping("/update")
    @Auth(UserType.ADMINISTRATION)
    public Object updateCourse(UpdateCourseRequest updateCourseRequest){
        courseService.updateCourse(updateCourseRequest);
        return "Update Successfully!";
    }

    @ApiOperation(value = "查询全部课程",response = List.class)
    @GetMapping("/queryAll")
    public Object queryAllCourses(){
        return courseService.queryAllCourses();
    }

    @ApiOperation(value = "关键字搜索课程",response = List.class)
    @GetMapping("/search")
    public Object searchCourse(String searchWords){
        return courseService.searchCourse(searchWords);
    }
}
