package dong.shop.common;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/fragment")
    public String template() {
        return "template/fragment/fragmentMain";
    }


    @GetMapping("/layout")
    public String layout(Model model) {
        return "template/layout/layoutMain";
    }

    @GetMapping("/extend")
    public String extend(Model model) {
        return "template/layoutExtend/layoutExtendMain";
    }

}
