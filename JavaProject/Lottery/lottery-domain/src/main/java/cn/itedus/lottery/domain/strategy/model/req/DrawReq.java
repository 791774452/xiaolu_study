package cn.itedus.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 策略请求
 *
 * @author xiaolu
 * @since 2022-12-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawReq {

    /**
     * 用户ID
     */
    private String uId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 防重ID
     */
    private String uuid;
    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }
}
