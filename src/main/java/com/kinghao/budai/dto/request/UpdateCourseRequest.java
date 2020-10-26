package com.kinghao.budai.dto.request;

import com.kinghao.budai.dto.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author Kinghao
 * @Date 2020/10/23 21:30
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCourseRequest implements BaseRequest {

    @ApiModelProperty(value = "待修改课程的id",required = true)
    @NotNull
    private Integer id;

    @ApiModelProperty(value = "课程名称")
    private String course_name;

    @ApiModelProperty("时长")
    private String length;

    @ApiModelProperty("难度")
    private String difficulty;

    @ApiModelProperty("课程大纲")
    private String outline;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("图片路径")
    private String image_url;

    @ApiModelProperty("视频路径")
    private String video_url;

    @ApiModelProperty("标签（用于后续搜索功能）")
    private String tag;

    @ApiModelProperty("midi文件路径")
    private String midi_url;

}
