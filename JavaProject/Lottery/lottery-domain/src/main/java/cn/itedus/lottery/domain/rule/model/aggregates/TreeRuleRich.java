package cn.itedus.lottery.domain.rule.model.aggregates;

import cn.itedus.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.itedus.lottery.domain.rule.model.vo.TreeRootVO;
import lombok.Data;

import java.util.Map;

/**
 * 规则树聚合
 *
 * @author xiaolu
 * @since 2022-12-20
 */
@Data
public class TreeRuleRich {

    /**
     * 树根信息
     */
    private TreeRootVO treeRoot;
    /**
     * 树节点ID -> 子节点
     */
    private Map<Long, TreeNodeVO> treeNodeMap;

}
