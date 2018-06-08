package org.slh.hrm.util.tag;

import org.slh.hrm.util.common.HrmConstants;

/**
 * 
 * @ClassName: PageModel
 * @Description: 为简化分页功能而设计的分页标签
 * @author Song
 *
 */
public class PageModel {
	/** 分页数据总条数 */
	private int recordCount;
	/** 当前页 */
	private int pageIndex;
	/** 每页分多少条数据 */
	private int pageSize = HrmConstants.PAGE_DEFAULT_SIZE;
	/** 总页数 */
	private int totalSize;

	public int getRecordCount() {
		this.recordCount = this.recordCount > 0 ? this.recordCount : 0;
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageIndex() {
		this.pageIndex = this.pageIndex > 0 ? this.pageIndex : 1;
		/** 判断当前页是否超过总页数，如果超过了则默认最后一页为当前页 */
		this.pageIndex = this.pageIndex >= this.getTotalSize() ? this.getTotalSize() : this.pageIndex;
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		this.pageSize = this.pageSize <= HrmConstants.PAGE_DEFAULT_SIZE ? HrmConstants.PAGE_DEFAULT_SIZE
				: this.pageSize;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		if(this.getRecordCount()<=0){
			totalSize = 0;
		}else{
			totalSize = (this.getRecordCount()-1)/this.getPageSize()+1;
		}
		return totalSize;
	}
	public int getFirstLimitParam(){
		return (this.getPageIndex()-1)*this.getPageSize();
	}
}
