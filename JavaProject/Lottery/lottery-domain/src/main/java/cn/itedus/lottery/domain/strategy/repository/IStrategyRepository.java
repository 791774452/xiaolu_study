package cn.itedus.lottery.domain.strategy.repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVO;

import java.util.List;

/**
 * 策略领域服务SQL
 *
 * @author xiaolu
 * @since 2022-12-11
 */
public interface IStrategyRepository {

    /**
     * 查询策略配置
     * @param strategyId strategyId
     * @return StrategyRich
     */
    StrategyRich queryStrategyRich(Long strategyId);

    /**
     * 查询奖品
     *
     * @param awardId awardId
     * @return Award
     */
    AwardBriefVO queryAwardInfo(String awardId);

    /**
     * 排除奖品ID
     *
     * @param strategyId strategyId
     * @return List<String>
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return           扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
