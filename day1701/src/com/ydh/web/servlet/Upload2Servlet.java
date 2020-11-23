package com.ydh.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.ydh.utils.UploadUtils;

/**
 * Servlet implementation class Upload1Servlet
 */
@WebServlet("/upload2")
@MultipartConfig
public class Upload2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		//1.获取普通的上传组件 username
		String username=request.getParameter("username");
		System.out.println(username);
		//2.获取文件上传组件 
		Part part=request.getPart("f");
		//2.1获取文件的名称
		String dis=part.getHeader("Content-disposition");
		String realName=dis.substring(dis.indexOf("filename=")+10,dis.length()-1);
		realName=UploadUtils.getRealName(realName);
		System.out.println("文件的名称："+realName);
		//2.2获取随机名称
		String uuidName=UploadUtils.getUUIDName(realName);
		System.out.println("文件随机名称："+uuidName);
		//2.3获取文件存放目录
		String dir=UploadUtils.getDir(realName);
		String realPath=this.getServletContext().getRealPath("/upload"+dir);
		File file=new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		System.out.println("文件的目录："+realPath);
		InputStream is=part.getInputStream();
		FileOutputStream os=new FileOutputStream(new File(file,uuidName));
		IOUtils.copy(is, os);
		os.close();
		is.close();
		//删除临时文件
		part.delete();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
