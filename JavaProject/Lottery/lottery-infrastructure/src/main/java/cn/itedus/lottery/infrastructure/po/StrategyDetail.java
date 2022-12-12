package cn.itedus.lottery.infrastructure.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 策略明细po
 *
 * @author xiaolu
 * @since 2022-12-11
 */
@Data
public class StrategyDetail {

    /**
     * 自增ID
     */
    private String id;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 奖品数量
     */
    private String awardCount;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;
}
