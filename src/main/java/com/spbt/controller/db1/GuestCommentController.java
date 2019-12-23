package com.spbt.controller.db1;

import com.spbt.entity.db1.GuestComment;
import com.spbt.query.db1.GuestCommentQuery;
import com.spbt.service.db1.IGuestCommentService;
import com.spbt.utils.GsonUtil;
import com.spbt.utils.ResponseUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/guest_comment")
public class GuestCommentController {
    private static final Logger logger = LogManager.getLogger(GuestCommentController.class);

    @Autowired
    private IGuestCommentService guestCommentService;

    @RequestMapping("/search")
    public void search(HttpServletResponse response, HttpServletRequest request, GuestCommentQuery query) {
        try {
            List<GuestComment> list = guestCommentService.serach(query);
            ResponseUtils.renderJSON(response, GsonUtil.gsonString(list));
        } catch (Exception e) {
            logger.error("GuestCommentController.search Error:" + e.getMessage());
        }
    }

}
