package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;

/**
 * 对外提供抽奖策略接口
 *
 * @author xiaolu
 * @since 2022-12-11
 */
public interface IDrawExec {
    /**
     * doDrawExec
     *
     * @param req req
     * @return DrawResult
     */
    DrawResult doDrawExec(DrawReq req);

}
