package github.guakun01.zhangbujava1.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import github.guakun01.zhangbujava1.converter.DO2BO.GuaBOConverter;
import github.guakun01.zhangbujava1.dao.GuaDAO;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GuaManagerImpl implements GuaManager {

    private final GuaDAO guaDAO;

    private final GuaBOConverter guaBOConverter;

    @Autowired
    public GuaManagerImpl(
            final GuaDAO guaDAO,
            final GuaBOConverter guaBOConverter) {
        this.guaDAO = guaDAO;
        this.guaBOConverter = guaBOConverter;
    }

    @Override
    public GuaBO getGuaById(Long id) {
        log.info(String.format("get gua where id = %d", id));
        return guaBOConverter.convert(guaDAO.getGuaById(id));
    }

}
