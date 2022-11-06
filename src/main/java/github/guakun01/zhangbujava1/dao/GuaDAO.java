package github.guakun01.zhangbujava1.dao;

import github.guakun01.zhangbujava1.model.persistence.GuaDO;

public interface GuaDAO {
    // 获取单个对象的方法使用 get 做前缀
    GuaDO getGuaById(Long id);

    // 获取单个对象的方法使用 get 做前缀
    GuaDO getGuaByName(String gname);

    // // 获取多个对象的方法用 list 做前缀，复数结尾
    // List<GuaDO> listGuas();

    // // 获取统计值的方法用 count 做前缀
    // int countGua();

    // // 插入的方法使用 save/insert 做前缀
    // int insertGua();

    // // 删除的方法使用 delete/remove 做前缀
    // int removeGua();

    // // 修改的方法使用 update 做前缀
    // int updateGua();
}
