package com.ydh.response.c_download;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.ydh.utils.DownLoadUtils;

/**
 * 文件下载
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文件下载步骤
		//0.获取下载文件名称
		String filename=request.getParameter("name");
		//注意中文乱码
		filename=new String(filename.getBytes("iso-8859-1"),"utf-8");
		//1.设置文件的mimeType
		ServletContext context=this.getServletContext();
		String mimeType=context.getMimeType(filename);
		response.setContentType(mimeType);
		//2.设置下载的头信息
		response.setHeader("content-disposition", "attachment;filename="+filename);
		//将文件名称使用utf-8编码 不推荐 不兼容火狐
		//response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
		//方式1：通过工具类编码(通用)
		//String _filename=DownLoadUtils.getName(request.getHeader("user-agent"), filename);
		//response.setHeader("content-disposition", "attachment;filename="+_filename);
		//方式2：网络上的方式(八成好使)
		response.setHeader("content-disposition", "attachment;filename="+new String(filename.getBytes("gbk"),"iso-8859-1"));
		//3.对拷流
		//获取输入流
		InputStream is=context.getResourceAsStream("/download/"+filename);
		//获取输出流
		ServletOutputStream os=response.getOutputStream();
//		int len=-1;
//		byte[] b=new byte[1024];
//		while((len=is.read(b))!=-1) {
//			os.write(b,0,len);
//		}
		IOUtils.copy(is, os);
		os.close();
		is.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
