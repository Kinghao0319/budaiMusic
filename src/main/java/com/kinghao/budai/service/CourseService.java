package com.kinghao.budai.service;

import com.kinghao.budai.dto.request.AddCourseRequest;
import com.kinghao.budai.dto.request.UpdateCourseRequest;
import com.kinghao.budai.dto.request.UpdateUserInfoRequest;
import com.kinghao.budai.entity.Course;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @Author Kinghao
 * @Date 2020/10/23 16:08
 * @Version 1.0
 */
public interface CourseService {
    void addCourse(AddCourseRequest addCourseRequest);

    void deleteCourse(Integer course_id);

    Course queryCourse(Integer course_id);

    void updateCourse(UpdateCourseRequest updateCourseRequest);

    List<Course> queryAllCourses();

    List<Course> searchCourse(String searchWords);
}
