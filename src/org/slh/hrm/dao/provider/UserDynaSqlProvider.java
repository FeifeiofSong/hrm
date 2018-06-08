package org.slh.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.slh.hrm.domain.User;

import static org.slh.hrm.util.common.HrmConstants.USERTABLE;

/**
 * 
 * @ClassName: UserDynaSqlProvider
 * @Description: User动态SQL提供类
 * @author Song
 *
 */
public class UserDynaSqlProvider {
	// 分页动态查询
	public String selectWithParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USERTABLE);
				if (params.get("user") != null) {
					User user = (User) params.get("user");
					if (user.getUsername() != null && user.getUsername().trim().equals("")) {
						WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if (user.getStatus() != null && user.getStatus().equals("")) {
						WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
					}
				}
			}
		}.toString();
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
		}
		return sql;
	}

	// 动态查询总量
	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if (params.get("user") != null) {
					User user = (User) params.get("user");
					if (user.getUsername() != null && user.getUsername().trim().equals("")) {
						WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if (user.getStatus() != null && user.getStatus().equals("")) {
						WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertUser(User user) {
		return new SQL() {
			{
				INSERT_INTO(USERTABLE);
				if (user.getUsername() != null && !user.getUsername().trim().equals("")) {
					VALUES("username", "#{username}");
				}
				if (user.getStatus() != null && !user.getStatus().equals("")) {
					VALUES("status", "#{status}");
				}
				if (user.getLoginname() != null && !user.getLoginname().trim().equals("")) {
					VALUES("loginname", "#{loginname}");
				}
				if (user.getPassword() != null && !user.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
			}
		}.toString();
	}
	
	//动态更新
	public String updateUser(User user){
		return new SQL(){
			{
				UPDATE(USERTABLE);
				if(user.getUsername() != null && !user.getUsername().trim().equals("")){
					SET(" username = #{username} ");
				}
				if (user.getLoginname() != null && !user.getLoginname().trim().equals("")) {
					SET(" loginname = #{loginname} ");
				}
				if (user.getPassword() != null && !user.getPassword().equals("")) {
					SET(" password = #{password} ");
				}
				if (user.getStatus() != null && !user.getStatus().equals("")) {
					SET(" status = #{status} ");
				}
				if (user.getCreateDate()!= null) {
					SET(" create_date = #{createDate} ");
				}
				WHERE(" id = #{id} ");
				
			}
		}.toString();
	}
}
