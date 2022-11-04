package github.guakun01.zhangbujava1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import github.guakun01.zhangbujava1.converter.BO2VO.GuaVOConverter;
import github.guakun01.zhangbujava1.manager.GuaManager;
import github.guakun01.zhangbujava1.model.service.GuaVO;

@RestController
@RequestMapping("/api/v1/gua")
public class GuaController {

    private final GuaManager guaManager;

    private final GuaVOConverter guaVOConverter;

    @Autowired
    public GuaController(
            final GuaManager guaManager,
            final GuaVOConverter guaVOConverter) {
        this.guaManager = guaManager;
        this.guaVOConverter = guaVOConverter;
    }

    @GetMapping("/{id}")
    public GuaVO getGuaById(@PathVariable("id") Long guaId) {
        return guaVOConverter.convert(guaManager.getGuaById(guaId));
    }

}
