<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div>
	<h3 style="text-align:center;color:black">查询结果</h3>
		<div class="pager-header">
			<div class="header-info">

					共 <b style="color:#428bca;" >${page.totalNumber}</b> 条
					<c:if test="${page.currentPage > 1}">
						<a href="javascript:changeCurrentPage('1')" class='first'>首页</a>
						<a href="javascript:changeCurrentPage('${page.currentPage-1}')" class='pre'>上一页</a>
					</c:if>
					当前第<span>${page.currentPage}/${page.totalPage}</span>页
					<c:if test="${page.currentPage < page.totalPage}">
						<a href="javascript:changeCurrentPage('${page.currentPage+1}')" class='next'>下一页</a>
						<a href="javascript:changeCurrentPage('${page.totalPage}')" class='last'>末页</a>
					</c:if>
					跳至&nbsp;<input id="currentPageText" type='text' value='${page.currentPage}' class='allInput w28' size="4" maxlength="4" />&nbsp;页&nbsp;
					<a href="javascript:changeCurrentPage($('#currentPageText').val())" class='go'>跳转</a>
					
		</div>
	</div>
</div>