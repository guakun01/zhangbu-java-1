package github.guakun01.zhangbujava1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import github.guakun01.zhangbujava1.dao.mapper.GuaMapper;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;
import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuaDAOImpl implements GuaDAO {

    private final GuaMapper guaMapper;
    private int insertGua;

    @Override
    public GuaDO getGuaById(Long id) {
        GuaDO gua = guaMapper.getGuaById(id);
        return gua;
    }

    @Override
    public GuaDO getGuaByName(String gname) {
        GuaDO gua = guaMapper.getGuaByName(gname);
        return gua;
    }

    @Override
    public void insertGua(GuaDO newGua) {
        var row = guaMapper.insertGua(newGua);
        log.debug("Result: {}, use information: {}", row, newGua);
    }

    // @Override
    // public List<GuaDO> listGuas() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public int countGua() {
    //     // TODO Auto-generated method stub
    //     return 0;
    // }

    // @Override
    // public int removeGua() {
    //     // TODO Auto-generated method stub
    //     return 0;
    // }

    // @Override
    // public int updateGua() {
    //     // TODO Auto-generated method stub
    //     return 0;
    // }

}
