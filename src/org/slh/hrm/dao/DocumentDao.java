package org.slh.hrm.dao;

import static org.slh.hrm.util.common.HrmConstants.DOCUMENTTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.slh.hrm.dao.provider.DocumentDynaSqlProvider;
import org.slh.hrm.domain.Document;

/**
 * 
    * @ClassName: DocumentDao  
    * @Description: 下载文档类Dao接口  
    * @author Song  
    *
 */
public interface DocumentDao {
	// 动态查询
		@SelectProvider(type=DocumentDynaSqlProvider.class,method="selectWhitParam")
		@Results({
			@Result(id=true,column="id",property="id"),
			@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
			@Result(column="USER_ID",property="user",
				one=@One(select="org.slh.hrm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER))
		})
		List<Document> selectByPage(Map<String, Object> params);
			
		@SelectProvider(type=DocumentDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object> params);
			
		// 动态插入文档
		@SelectProvider(type=DocumentDynaSqlProvider.class,method="insertDocument")
		void save(Document document);
		
		@Select("select * from "+DOCUMENTTABLE+" where ID = #{id}")
		Document selectById(int id);
		
		// 根据id删除文档
		@Delete(" delete from "+DOCUMENTTABLE+" where id = #{id} ")
		void deleteById(Integer id);
			
		// 动态修改文档
		@SelectProvider(type=DocumentDynaSqlProvider.class,method="updateDocument")
		void update(Document document);
}
