package github.guakun01.zhangbujava1.controller;

import github.guakun01.zhangbujava1.converter.BO2VO.GuaVoConverter;
import github.guakun01.zhangbujava1.exception.InvalidParameterException;
import github.guakun01.zhangbujava1.manager.GuaManager;
import github.guakun01.zhangbujava1.model.common.GuaBO;
import github.guakun01.zhangbujava1.model.service.GuaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/gua")
public class GuaController {

    private final GuaManager guaManager;

    private final GuaVoConverter guaVOConverter;

    @Autowired
    public GuaController(
            final GuaManager guaManager,
            final GuaVoConverter guaVOConverter) {
        this.guaManager = guaManager;
        this.guaVOConverter = guaVOConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuaVO> getGuaById(@PathVariable("id") @NotNull Long guaId) {
        if (guaId <= 0) {
            throw new InvalidParameterException("Use incorrect guaid = " + guaId);
        }
        GuaBO guaBO = guaManager.getGuaById(guaId);
        GuaVO res = guaVOConverter.convert(guaBO);
        assert res != null;
        return ResponseEntity.ok(res);
    }

    @PostMapping(value="/signup", produces="application/json", consumes = "application/json")
    public ResponseEntity<GuaVO> signup(@RequestBody GuaVO guaVO) {
        return ResponseEntity.ok(guaVOConverter.convert(guaManager.signup(guaVO.getDisplayName(), guaVO.getInnerId())));
    }

}
