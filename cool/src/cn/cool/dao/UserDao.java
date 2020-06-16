package cn.cool.dao;

import cn.cool.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public interface UserDao {


    User findUsernameAndPassword(String username, String password);//根据账号，密码查询user

    public void add(User user);//添加user

    void delUser(int id);//根据id删除user

    User findById(int id);//根据id查询user

    void update(User user);//根据传入的user修改这个user


    int findTotalCount(Map<String, String[]> condition);//根据输入条件查询相关user总数

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);//根据输入条件查询相关user信息
}
