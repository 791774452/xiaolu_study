package cn.itedus.lottery.domain.rule.model.vo;

import lombok.Data;

/**
 * 规则树根配置
 *
 * @author xiaolu
 * @since 2022-12-20
 */
@Data
public class TreeRootVO {

    /** 规则树ID */
    private Long treeId;
    /** 规则树根ID */
    private Long treeRootNodeId;
    /** 规则树名称 */
    private String treeName;

    @Override
    public String toString() {
        return "TreeRootVO{" +
                "treeId=" + treeId +
                ", treeRootNodeId=" + treeRootNodeId +
                ", treeName='" + treeName + '\'' +
                '}';
    }
}
