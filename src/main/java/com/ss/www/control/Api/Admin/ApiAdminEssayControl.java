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
	 * @return json info ��ѯ��������
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
			m.setInfo("��������");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @param json
	 * @return json info ����|ȡ������
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
				blog.setStatus("δ����");
				if (essayService.updateEssayStatus(blog)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("ȡ�������ɹ�");
				} else {
					m.setCode(Message.ERROR);
					m.setInfo(Message.ERROR_INFO);
				}
			} else {
				if (statusChange.equals("�ѷ���")) {
					blog.setBlogId(Integer.parseInt(status));
					blog.setStatus("δ����");
					if (essayService.updateEssayStatus(blog)) {
						m.setCode(Message.SUCCESS);
						m.setInfo("ȡ�������ɹ�");
					} else {
						m.setCode(Message.ERROR);
						m.setInfo(Message.ERROR_INFO);
					}
				} else {
					blog.setBlogId(Integer.parseInt(status));
					blog.setStatus("�ѷ���");
					if (essayService.updateEssayStatus(blog)) {
						m.setCode(Message.SUCCESS);
						m.setInfo("�����ɹ�");
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
	 * @return json info ɾ������
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
				m.setInfo("ɾ���ɹ�");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("ɾ��ʧ��");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("��������");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @return json info ��ѯ����������ķ�������
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
	 * @return json info ��������
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
				m.setInfo("�ύ�ɹ�");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("�ύʧ��");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("��������");
		}
		return (JSONObject) JSONObject.toJSON(m);
	}

	/**
	 * @param json
	 * @return json info ��ʾ�޸Ŀ����Ϣ
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
			m.setInfo("��������");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @param json
	 * @return json info ����������Ϣ
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
				m.setInfo("���³ɹ�");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("����ʧ��");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("��������");
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
