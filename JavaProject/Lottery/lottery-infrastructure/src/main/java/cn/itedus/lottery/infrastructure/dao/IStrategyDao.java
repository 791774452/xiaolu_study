package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * 配置表mapper
 *
 * @author xiaolu
 * @since 2022-12-11
 */
@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);

}
