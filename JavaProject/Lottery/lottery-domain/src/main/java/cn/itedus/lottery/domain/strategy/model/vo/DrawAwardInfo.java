package cn.itedus.lottery.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 中奖奖品信息
 *
 * @author xiaolu
 * @since 2022-12-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;

}
