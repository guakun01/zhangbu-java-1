package github.guakun01.zhangbujava1.manager;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import github.guakun01.zhangbujava1.converter.DO2BO.GuaBoConverter;
import github.guakun01.zhangbujava1.dao.GuaDAO;
import github.guakun01.zhangbujava1.exception.InvalidParameterException;
import github.guakun01.zhangbujava1.exception.ResourceNotFoundException;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GuaManagerImpl implements GuaManager {

    /**
     *
     */
    private static final int HASH_ITERATIONS = 3;

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

    @Override
    public GuaBO getGuaByName(String gname) {
        return Optional.ofNullable(guaDAO.getGuaByName(gname))
                .map(guaBOConverter::convert)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("No this gua.(name = %s)", gname)));
    }

    @Override
    public GuaBO signup(String gname, String gid) {
        // 一锁二判三更新
        if (Objects.nonNull(guaDAO.getGuaByName(gname))) {
            throw new InvalidParameterException(String.format("Displayname for gua(%s) has been used.", gname));
        }

        String salt = UUID.randomUUID().toString();
        String encryptedPwd = new Sha256Hash(gid, salt, HASH_ITERATIONS).toBase64();

        GuaDO guaDO = GuaDO.builder()
                .displayName(gname)
                .salt(salt)
                .innerId(encryptedPwd)
                .build();
        guaDAO.insertGua(guaDO);
        

        return guaBOConverter.convert(guaDO);
    }

}
