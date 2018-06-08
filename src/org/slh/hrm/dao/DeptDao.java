package org.slh.hrm.dao;

import static org.slh.hrm.util.common.HrmConstants.DEPTTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.slh.hrm.dao.provider.DeptDynaSqlProvider;
import org.slh.hrm.domain.Dept;

/**
 * 
 * @ClassName: DeptDao
 * @Description:部门类dao接口
 * @author Song
 *
 */
public interface DeptDao {
	// 动态查询
	@SelectProvider(type = DeptDynaSqlProvider.class, method = "selectWhitParam")
	List<Dept> selectByPage(Map<String, Object> params);

	@SelectProvider(type = DeptDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	@Select("select * from " + DEPTTABLE + " ")
	List<Dept> selectAllDept();

	@Select("select * from " + DEPTTABLE + " where ID = #{id}")
	Dept selectById(int id);

	// 根据id删除部门
	@Delete(" delete from " + DEPTTABLE + " where id = #{id} ")
	void deleteById(Integer id);

	// 动态插入部门
	@SelectProvider(type = DeptDynaSqlProvider.class, method = "insertDept")
	void save(Dept dept);

	// 动态修改部门
	@SelectProvider(type = DeptDynaSqlProvider.class, method = "updateDept")
	void update(Dept dept);
}
