package cn.bugstack.middleware.db.router;

/**
 * 数据源基础配置
 *
 * @author xiaolu
 * @since 2022-12-17
 */
public class DBRouterBase {

    private String tbIdx;

    public String getTbIdx() {
        return DBContextHolder.getTBKey();
    }

}
