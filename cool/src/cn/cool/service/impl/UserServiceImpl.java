package cn.cool.service.impl;

import cn.cool.dao.UserDao;
import cn.cool.dao.impl.UserDaoImpl;
import cn.cool.domain.PageBean;
import cn.cool.domain.User;
import cn.cool.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }

    @Override
    public User login(User user) {
        return  userDao.findUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public void add(User user) {
         userDao.add(user);
    }

    @Override
    public void delUser(String id) {
        userDao.delUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if(uids!=null&&uids.length>0){
            for (String uid : uids) {
                userDao.delUser(Integer.parseInt(uid));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        PageBean<User> pb=new PageBean<User>();
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        //上一页到底判断
        if(currentPage<=0){
            currentPage=1;
        }
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRow(rows);
        //查询总的记录数
        int totalCount = userDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //计算总的页码数
        int totalPage = (totalCount % rows)==0 ? totalCount/rows : totalCount/rows+1;
        pb.setTotalPage(totalPage);
        //下一页到底判断
        if(currentPage>=totalPage){
            currentPage=totalPage;
            pb.setCurrentPage(currentPage);
        }
        //调用Dao查询list集合
        //开始计算索引值
        int start=(currentPage-1)*rows;
        List<User> list=userDao.findByPage(start,rows,condition);
        pb.setList(list);
        return pb;
    }


}
