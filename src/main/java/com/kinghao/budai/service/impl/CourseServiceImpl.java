package com.kinghao.budai.service.impl;

import com.kinghao.budai.dto.request.AddCourseRequest;
import com.kinghao.budai.dto.request.UpdateCourseRequest;
import com.kinghao.budai.dto.request.UpdateUserInfoRequest;
import com.kinghao.budai.entity.Course;
import com.kinghao.budai.mapper.CourseMapper;
import com.kinghao.budai.service.CourseService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @Author Kinghao
 * @Date 2020/10/23 16:08
 * @Version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Resource(type = CourseMapper.class)
    private CourseMapper courseMapper;

    @Override
    public void addCourse(AddCourseRequest addCourseRequest) {
        Course newCourse=Course
                .builder()
                .course_name(addCourseRequest.getCourse_name())
                .length(addCourseRequest.getLength())
                .difficulty(addCourseRequest.getDifficulty())
                .image_url(addCourseRequest.getImage_url())
                .video_url(addCourseRequest.getVideo_url())
                .tag(addCourseRequest.getTag())
                .outline(addCourseRequest.getOutline())
                .type(addCourseRequest.getType())
                .midi_url(addCourseRequest.getMidi_url())
                .build();//参与人数不用存，随机生成
        courseMapper.insertSelective(newCourse);
    }

    @Override
    public void deleteCourse(Integer course_id) {
        courseMapper.deleteByPrimaryKey(course_id);
    }

    @Override
    public Course queryCourse(Integer course_id) {
        Course rt=courseMapper.selectByPrimaryKey(course_id);
        if(rt==null){
            return null;
        }

        rt.setParticipant_num(new Random().nextInt(500)+100);//[100,600)

        return rt;
    }

    @Override
    public void updateCourse(UpdateCourseRequest updateCourseRequest) {
        Integer course_id=updateCourseRequest.getId();
        Course course=Course
                .builder()
                .course_name(updateCourseRequest.getCourse_name())
                .length(updateCourseRequest.getLength())
                .difficulty(updateCourseRequest.getDifficulty())
                .image_url(updateCourseRequest.getImage_url())
                .video_url(updateCourseRequest.getVideo_url())
                .outline(updateCourseRequest.getOutline())
                .type(updateCourseRequest.getType())
                .tag(updateCourseRequest.getTag())
                .midi_url(updateCourseRequest.getMidi_url())
                .build();
        Example example=new Example(Course.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("id",course_id);
        courseMapper.updateByExampleSelective(course,example);
    }

    @Override
    public List<Course> queryAllCourses() {
        return courseMapper.selectAll();
    }

    @Override
    public List<Course> searchCourse(String searchWords) {
        String[] words=searchWords.split(" ");
        Example example=new Example(Course.class);
        Example.Criteria criteria=example.createCriteria();
        for(String word:words){
            criteria.andLike("tag","%"+word+"%");
        }
        return courseMapper.selectByExample(example);
    }
}
