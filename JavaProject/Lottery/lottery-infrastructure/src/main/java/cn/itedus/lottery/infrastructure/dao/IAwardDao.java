package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * 奖品表mapper
 *
 * @author xiaolu
 * @since 2022-12-11
 */
@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);

}
