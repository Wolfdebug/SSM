package com.zrm.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadCtrl {
	@RequestMapping("/toUpload.do")
	public String toUpload() {
		return "upload";
	}
	@RequestMapping("/upload.do")
	public ModelAndView upload(HttpServletRequest req,@RequestParam("file")CommonsMultipartFile file) {
		String path = req.getServletContext().getRealPath("/upload");
		String name = file.getOriginalFilename();
		System.out.println("文件名："+name);
		InputStream is = null;
		OutputStream os = null;
		try {
			is = file.getInputStream();
			os = new FileOutputStream(new File(path,name));
			byte[] bytes = new byte[1024];
			int len =0;
			while((len=is.read(bytes))!=-1) {
				os.write(bytes,0,len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(is!=null)
					is.close();
				if(os!=null)
					os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
		   return new ModelAndView("index");
	}
	@RequestMapping("/toBatchUpload.do")
	public String toBatchUpload() {
		return "batchUpload";
	}
	@RequestMapping("/batchUpload.do")
	public ModelAndView batchUpload(HttpServletRequest req,@RequestParam("file")CommonsMultipartFile[] file) {
		String path = req.getServletContext().getRealPath("/upload");
		String name = null;
		InputStream is = null;
		OutputStream os = null;
			byte[] bytes = new byte[1024];
			int len =0;
			for (int i = 0; i < file.length; i++) {
				try {
					name = file[i].getOriginalFilename();
					is = file[i].getInputStream();
					System.out.println("文件名："+name);
					os = new FileOutputStream(new File(path,name));
					while((len=is.read(bytes))!=-1) {
						os.write(bytes,0,len);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						if(is!=null)
							is.close();
						if(os!=null)
							os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			}
			return new ModelAndView("index");
	
	}
}
