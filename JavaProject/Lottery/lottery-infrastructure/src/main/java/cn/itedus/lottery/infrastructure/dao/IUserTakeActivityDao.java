package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户领取活动表DAO
 *
 * @author xiaolu
 * @since 2022-12-15
 */
@Mapper
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    void insert(UserTakeActivity userTakeActivity);

}
