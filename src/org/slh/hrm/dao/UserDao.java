package org.slh.hrm.dao;

import org.apache.ibatis.annotations.*;
import org.slh.hrm.dao.provider.UserDynaSqlProvider;
import org.slh.hrm.domain.User;
import static org.slh.hrm.util.common.HrmConstants.USERTABLE;

import java.util.List;
import java.util.Map;;

/**
 * 
 * @ClassName: UserDao
 * @Description: 用户类Dao接口
 * @author Song
 *
 */
public interface UserDao {
	// 根据登陆名和密码查询员工
	@Select("SELECT * FROM " + USERTABLE + " WHERE loginname = #{loginname} AND password = #{password}")
	User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);

	// 根据id查询用户
	@Select("SELECT * FROM " + USERTABLE + " WHERE ID = #{id}")
	User selectById(Integer id);

	// 根据id删除用户
	@Delete("delete from " + USERTABLE + " WHERE ID = #{id}")
	void deleteById(Integer id);

	// 动态修改用户
	@SelectProvider(type = UserDynaSqlProvider.class, method = "updateUser")
	void update(User user);

	// 动态查询
	@SelectProvider(type = UserDynaSqlProvider.class, method = "selectWithParam")
	List<User> selectByPage(Map<String, Object> params);

	// 根据参数查询用户总数
	@SelectProvider(type = UserDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// 动态插入用户
	@SelectProvider(type = UserDynaSqlProvider.class, method = "insertUser")
	void save(User user);
}
