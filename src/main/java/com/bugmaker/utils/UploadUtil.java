package com.bugmaker.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {

	@SuppressWarnings("unchecked")
	public static List<FileItem> getUploadFileStream(HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileupload = new ServletFileUpload(factory);
			// 解析请求正文并返回List<FileItem>
			List<FileItem> list = null;
			try {
				list = fileupload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}
}
