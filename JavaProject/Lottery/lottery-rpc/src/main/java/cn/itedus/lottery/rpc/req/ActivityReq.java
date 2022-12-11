package cn.itedus.lottery.rpc.req;

import java.io.Serializable;

/**
 * rpc请求类
 *
 * @author xiaolu
 * @since 2022-12-10
 */
public class ActivityReq implements Serializable {

    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    /**
     * TODO
     *
     * @param activityId activityId
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

}
