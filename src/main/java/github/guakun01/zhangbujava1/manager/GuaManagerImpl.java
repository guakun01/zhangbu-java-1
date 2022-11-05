package github.guakun01.zhangbujava1.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import github.guakun01.zhangbujava1.converter.DO2BO.GuaBoConverter;
import github.guakun01.zhangbujava1.dao.GuaDAO;
import github.guakun01.zhangbujava1.exception.ResourceNotFoundException;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GuaManagerImpl implements GuaManager {

    private final GuaDAO guaDAO;

    private final GuaBoConverter guaBOConverter;

    @Autowired
    public GuaManagerImpl(
            final GuaDAO guaDAO,
            final GuaBoConverter guaBOConverter) {
        this.guaDAO = guaDAO;
        this.guaBOConverter = guaBOConverter;
    }

    @Override
    public GuaBO getGuaById(Long id) {
        log.info(String.format("Get gua(id = %d)", id));
        GuaDO gua = Optional.ofNullable(guaDAO.getGuaById(id))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No this gua.(id = %d)", id)));
        return guaBOConverter.convert(gua);
    }

}
