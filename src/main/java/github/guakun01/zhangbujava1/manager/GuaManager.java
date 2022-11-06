package github.guakun01.zhangbujava1.manager;

import github.guakun01.zhangbujava1.model.common.GuaBO;

public interface GuaManager {
    
    GuaBO getGuaById(Long id);

    GuaBO getGuaByName(String gname);
}
