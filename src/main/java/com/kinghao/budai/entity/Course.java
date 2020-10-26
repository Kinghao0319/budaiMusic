package com.kinghao.budai.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


/**
 * @Author Kinghao
 * @Date 2020/10/23 16:00
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    private Integer id;
    private String course_name;
    private String length;
    private String difficulty;
    private String outline;
    private String type;
    private Integer participant_num;
    private String image_url;
    private String video_url;
    private String tag;
    private String midi_url;
}
