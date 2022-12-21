package cn.itedus.lottery.domain.rule.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 决策物料
 *
 * @author xiaolu
 * @since 2022-12-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionMatterReq {

    /**
     * 规则树ID
     */
    private Long treeId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 决策值
     */
    private Map<String, Object> valMap;

}
