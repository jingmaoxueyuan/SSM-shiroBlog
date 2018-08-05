package com.ss.www.control.Api.Admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.ss.www.entity.Label;
import com.ss.www.entity.Rows;
import com.ss.www.entity.POJO.Message;
import com.ss.www.service.LabelService;

@Controller
@RequestMapping(value = "admin")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiLabelControl {
	@Autowired
	LabelService labelService;

	@ResponseBody
	@RequestMapping(value = "findLabelTable")
	@RequiresPermissions("label:view")
	public JSONObject findLabelTable() {
		Rows<Label> labelRows = new Rows<Label>();
		try {
			List<Label> label = labelService.findLabel();
			if (label != null) {
				labelRows.setRows(label);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(labelRows);

	}

	@ResponseBody
	@RequestMapping(value = "insertLabel", method = RequestMethod.POST)
	@RequiresPermissions("label:insert")
	public JSONObject insertLabel(@RequestBody JSONObject json) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(new Date());
		String labelContent = json.getString("label");
		Label label = new Label();
		label.setLabel(labelContent);
		label.setCreate_Date(date);
		Message m = new Message();
		try {
			if (labelService.insertLabelInfo(label)) {
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
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "findUpdataLabel", method = RequestMethod.GET)
	@RequiresPermissions("label:updateLabel")
	public JSONObject findUpdataLabel(HttpServletRequest req) {
		String labelId = req.getParameter("label_Id");
		Message m = new Message();
		try {
			Label label = labelService.findUpdateLabel(Integer.parseInt(labelId));
			if (label != null) {
				m.setCode(Message.SUCCESS);
				m.setObject(label);
			} else {
				m.setCode(Message.ERROR);
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
		}
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "updateLabel", method = RequestMethod.POST)
	@RequiresPermissions("label:update")
	public JSONObject updateLabel(@RequestBody JSONObject json) {
		String labelId = json.getString("label_Id");
		String labelContent = json.getString("label");
		Label label = new Label();
		label.setLabel_Id(Integer.parseInt(labelId));
		label.setLabel(labelContent);
		Message m = new Message();
		try {
			if (labelService.updateLabel(label)) {
				m.setCode(Message.SUCCESS);
				m.setInfo("更改成功");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("更改失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "deleteLabel")
	@RequiresPermissions("label:delete")
	public JSONObject deleteLabel(@RequestBody JSONObject json) {
		String labelId = json.getString("label_Id");
		Message m = new Message();
		try {
			if (labelService.deleteLabel(Integer.parseInt(labelId))) {
				m.setCode(Message.SUCCESS);
				m.setInfo("删除成功");
			}else {
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
}
