package com.udgaman.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AudioFileController {
	
	byte[] aFile;
	
	@RequestMapping(value="/addAudio",produces="audio/mpeg",consumes="multipart/form-data", method=RequestMethod.POST)
	
	public String musicTest(@RequestParam("audio") MultipartFile file) throws IOException{
		aFile = file.getBytes();
//		File f1 = new File(file.getOriginalFilename());
//		file.transferTo(f1);
		
		return "uploadAudio";
	}
	
	@RequestMapping(value="/addAudio.mp3", method=RequestMethod.GET)
//	@ResponseBody
	public void getMusic(HttpServletResponse response) throws IOException{
		response.setContentType("audio/mpeg");
		OutputStream os = response.getOutputStream();
		response.setContentLength(aFile.length);
		os.write(aFile);
//		os.flush();
//		os.close();
		response.flushBuffer();
//		return aFile;
	}

}
