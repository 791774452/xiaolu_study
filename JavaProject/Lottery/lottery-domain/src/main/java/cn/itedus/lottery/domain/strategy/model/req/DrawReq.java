package cn.itedus.lottery.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 策略请求
 *
 * @author xiaolu
 * @since 2022-12-11
 */
@Data
@AllArgsConstructor
public class DrawReq {

    // 用户ID
    private String uId;

    // 策略ID
    private Long strategyId;

}
