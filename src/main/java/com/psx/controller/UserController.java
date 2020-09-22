package com.psx.controller;


import com.psx.exceptions.InnertalException;
import com.psx.model.User;
import com.psx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2020-09-20
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @PostMapping("/getUser")
    public User getUser(){
        return userService.getById(1);
    }

    @PostMapping("/findAllUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) throws InnertalException {
        userService.save(user);
        return "注册成功!";
    }


    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) throws InnertalException{
        userService.update();
        return "修改成功";
    }

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletRequest request,
                      HttpServletResponse response){
        System.out.println(user);
        List<User> list = userService.list(null);
        /* Map<String, Object> resultMap = new HashMap<>();*/
        if(list != null && list.size() > 0){
            // 表示系统中有这样的用户
            // 得到用户
            user = list.get(0);
            // 把用户的信息保存到session中
            // 得到session
            HttpSession session = request.getSession();
            // 把用户信息保存到session中,便于以后操作其它功能之前判断用户是否已经登录
            session.setAttribute("user", user);
           /* Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("companyId", "010");
            dataMap.put("companyName", "ujiuye");
            //生成token并存入数据返回
            String token = JwtUtils.createJwt(user.getUid() + "",user.getName(),
                    dataMap);


            resultMap.put("token", token);
            resultMap.put("user", user);
            resultMap.put("msg", "登陆成功");
            return resultMap;*/


        }

        System.out.println(user);
        return user;
    }

}
