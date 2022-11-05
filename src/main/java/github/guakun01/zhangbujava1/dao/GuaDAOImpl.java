package github.guakun01.zhangbujava1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import github.guakun01.zhangbujava1.dao.mapper.GuaMapper;
import github.guakun01.zhangbujava1.model.persistence.GuaDO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GuaDAOImpl implements GuaDAO {

    private final GuaMapper guaMapper;

    @Override
    public GuaDO getGuaById(Long id) {
        GuaDO gua = guaMapper.getGuaById(id);
        return gua;
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
    // public int insertGua() {
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
