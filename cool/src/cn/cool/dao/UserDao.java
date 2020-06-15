package cn.cool.dao;

import cn.cool.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    public List<User> findAll();

    User findUsernameAndPassword(String username, String password);

    public void add(User user);

    void delUser(int id);

    User findById(int id);

    void update(User user);


    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
