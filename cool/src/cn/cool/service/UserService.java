package cn.cool.service;

import cn.cool.domain.PageBean;
import cn.cool.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {


    /**
     * 登陆验证
     * @param user
     * @return
     */
    public User login(User user);


    /**
     * 添加user
     * @param user
     */
    public void add(User user);

    /**
     * 根据id删除
     * @param id
     */
    void delUser(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除选中用户
     * @param uids
     */
    void delSelectedUser(String[] uids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
