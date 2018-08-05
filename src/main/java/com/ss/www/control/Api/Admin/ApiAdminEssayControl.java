package com.ss.www.control.Api.Admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ss.www.entity.Blog;
import com.ss.www.entity.EssayResultMap;
import com.ss.www.entity.EssayRows;
import com.ss.www.entity.LabelList;
import com.ss.www.entity.POJO.Message;
import com.ss.www.service.EssayService;
import com.ss.www.service.LoginUserService;

@Controller
@RequestMapping(value = "admin")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiAdminEssayControl {
	@Autowired
	EssayService essayService;
	@Autowired
	LoginUserService loginUserService;

	/**
	 * @return json info 查询所有文章
	 */
	@ResponseBody
	@RequestMapping(value = "essayView", method = RequestMethod.GET)
	@RequiresPermissions("essay:view")
	public JSONObject EssayView() {
		EssayRows essayRows = new EssayRows();
		Message m = new Message();
		Subject subject = SecurityUtils.getSubject();
		String userName = (String) subject.getSession().getAttribute("user1");
		try {
			List<EssayResultMap> blogContent = essayService.findEssayByUserName(userName);
			// int total = essayService.findEssayCount(userName);
			// essayRows.setTotal(total);
			essayRows.setRows(blogContent);
			return (JSONObject) JSON.toJSON(essayRows);
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @param json
	 * @return json info 发布|取消发布
	 */
	@ResponseBody
	@RequestMapping(value = "statusChange", method = RequestMethod.POST)
	@RequiresPermissions("essay:status")
	public JSONObject statusChange(@RequestBody JSONObject json) {
		String status = json.getString("blogId");
		Blog blog = new Blog();
		Message m = new Message();
		try {
			String statusChange = essayService.findEssayStatusByBlogId(Integer.parseInt(status));
			if (statusChange == null) {
				blog.setBlogId(Integer.parseInt(status));
				blog.setStatus("未发布");
				if (essayService.updateEssayStatus(blog)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("取消发布成功");
				} else {
					m.setCode(Message.ERROR);
					m.setInfo(Message.ERROR_INFO);
				}
			} else {
				if (statusChange.equals("已发布")) {
					blog.setBlogId(Integer.parseInt(status));
					blog.setStatus("未发布");
					if (essayService.updateEssayStatus(blog)) {
						m.setCode(Message.SUCCESS);
						m.setInfo("取消发布成功");
					} else {
						m.setCode(Message.ERROR);
						m.setInfo(Message.ERROR_INFO);
					}
				} else {
					blog.setBlogId(Integer.parseInt(status));
					blog.setStatus("已发布");
					if (essayService.updateEssayStatus(blog)) {
						m.setCode(Message.SUCCESS);
						m.setInfo("发布成功");
					} else {
						m.setCode(Message.ERROR);
						m.setInfo(Message.ERROR_INFO);
					}
				}
			}
		} catch (JSONException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @param json
	 * @return json info 删除文章
	 */
	@ResponseBody
	@RequestMapping(value = "essayDelete", method = RequestMethod.POST)
	@RequiresPermissions("essay:delete")
	public JSONObject essayDelete(@RequestBody JSONObject json) {
		String blogId = json.getString("blogId");
		Message m = new Message();
		try {
			if (essayService.deleteEssayByEssayId(Integer.parseInt(blogId))) {
				m.setCode(Message.SUCCESS);
				m.setInfo("删除成功");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("删除失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @return json info 查询新增下拉框的分类数据
	 */
	@ResponseBody
	@RequestMapping(value = "essayLabel", method = RequestMethod.GET)
	public JSONObject essayLabel() {
		LabelList labelList = new LabelList();
		labelList.setObject(essayService.findLabel());
		return (JSONObject) JSON.toJSON(labelList);
	}

	/**
	 * @param json
	 * @return json info 新增文章
	 */
	@ResponseBody
	@RequestMapping(value = "insertEssay", method = RequestMethod.POST)
	@RequiresPermissions("essay:insert")
	public JSONObject insertEssay(@RequestBody JSONObject json) {
		Subject subject = SecurityUtils.getSubject();
		String title = json.getString("essayTitle");
		String label = json.getString("label");
		String something = json.getString("something");
		String content = json.getString("content");
		String userName = (String) subject.getSession().getAttribute("user1");
		EssayResultMap essayResultMap = new EssayResultMap();
		Message m = new Message();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		essayResultMap.setUserName(userName);
		essayResultMap.setLabel(label);
		essayResultMap.setTitle(title);
		essayResultMap.setSomething(something);
		essayResultMap.setContent(content);
		essayResultMap.setCreate_Date(date);
		try {
			if (essayService.insertEssay(essayResultMap)) {
				m.setCode(Message.SUCCESS);
				m.setInfo("提交成功");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("提交失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSONObject.toJSON(m);
	}

	/**
	 * @param json
	 * @return json info 显示修改框的信息
	 */
	@ResponseBody
	@RequestMapping(value = "updataEssay", method = RequestMethod.POST)
	@RequiresPermissions("essay:updata")
	public JSONObject updataEssay(@RequestBody JSONObject json) {
		String blogId = json.getString("blogId");
		Message m = new Message();
		try {
			EssayResultMap essayResultMap = essayService.findEssayByBlogId(Integer.parseInt(blogId));
			if (essayResultMap != null) {
				m.setCode(Message.SUCCESS);
				m.setObject(essayResultMap);
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @param json
	 * @return json info 更新文章信息
	 */
	@ResponseBody
	@RequestMapping(value = "updataEssayByBlogId", method = RequestMethod.POST)
	@RequiresPermissions("essay:updataEssay")
	public JSONObject updataEssayByBlogId(@RequestBody JSONObject json) {
		String blogId = json.getString("blogId");
		String title = json.getString("title");
		String label = json.getString("label");
		String content = json.getString("content");
		String something = json.getString("something");
		EssayResultMap essayResultMap = new EssayResultMap();
		essayResultMap.setBlogId(Integer.parseInt(blogId));
		essayResultMap.setTitle(title);
		essayResultMap.setLabel(label);
		essayResultMap.setContent(content);
		essayResultMap.setSomething(something);
		Message m = new Message();
		try {
			if (essayService.updateEssayByBlogId(essayResultMap)) {
				m.setCode(Message.SUCCESS);
				m.setInfo("更新成功");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("更新失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	@ResponseBody
	@RequestMapping(value = "searchEssay", method = RequestMethod.POST)
	@RequiresPermissions("essay:searchEssay")
	public JSONObject searchEssay(@RequestBody JSONObject json) {
		String title = json.getString("title");
		EssayRows essayRows = new EssayRows();
		// Subject subject=SecurityUtils.getSubject();
		// String userName=(String) subject.getSession().getAttribute("user1");
		try {
			List<EssayResultMap> essayResultMap = essayService.searchTitle(title);

			if (essayResultMap != null) {
				// int total = essayService.findEssayCount(userName);
				// essayRows.setTotal(total);
				essayRows.setRows(essayResultMap);
			} else {
				// m.setCode(Message.ERROR);
			}
		} catch (JSONException e) {
			// TODO: handle exception
			// m.setCode(Message.ERROR_AUTHORIZATION);
		}
		return (JSONObject) JSON.toJSON(essayRows);

	}
}
