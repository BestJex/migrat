package com.ymy.xxb.migrat.module.biz.produce.entity;

import com.ymy.xxb.migrat.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 通知节点实体类
 *
 */
@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InformNodeDO extends BaseVo{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户
	 */
	@ApiModelProperty(value = "用户", name="user", dataType="String")
	private String user;

	/**
	 * 适用模块
	 */
	@ApiModelProperty(value = "适用模块", name="applyModule", dataType="String", required = true)
	private String applyModule;
	
	/**
	 * 节点名称
	 */
	@ApiModelProperty(value = "节点名称", name = "nodeName", dataType = "String", required = true)
	private String nodeName;

	/**
	 * 节点别名
	 */
	@ApiModelProperty(value = "节点别名", name="nodeAlias", dataType="String")
	private String nodeAlias;
	
	/**
     * 排序
     */
	@ApiModelProperty(value = "排序", name="sort", dataType="Integer")
    private Integer sort;

	/**
     * 状态
     */
	@ApiModelProperty(value = "状态", name="state", dataType="Integer", notes="1：启用  0：禁用" , required = true)
    private Integer state;

	/**
	 * 模板集合
	 */
	@ApiModelProperty(value = "模板集合", name="list", dataType="List")
	private List<InformTemplateDO> informTemplates;


}
