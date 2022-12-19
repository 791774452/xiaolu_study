package cn.itedus.lottery.domain.activity.model.res;

import cn.itedus.lottery.common.Result;

/**
 * 活动参与结果
 *
 * @author xiaolu
 * @since 2022-12-17
 */
public class PartakeResult extends Result {

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }
}
