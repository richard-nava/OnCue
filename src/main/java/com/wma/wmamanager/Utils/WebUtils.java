package com.wma.wmamanager.Utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.wma.wmamanager.entity.Organization;
import com.wma.wmamanager.repository.OrgRepository;
import com.wma.wmamanager.repository.UserRepository;

@Component
@Transactional
public class WebUtils {
	
	private static final Logger log=LoggerFactory.getLogger("WebUtils.class");
	
	@Autowired
	UserRepository usersRepository;
	
	@Autowired
	OrgRepository orgRepo;
	
	@Autowired
    HttpServletRequest request;
	
	private static final String UPLOADED_FOLDER = "static"+ File.separator +"img";
	
	public void addProfilePhoto(MultipartFile file, long id, String folder) throws IllegalStateException, IOException {
		try {
			// save dir
			String destDir = request.getSession().getServletContext().getRealPath(UPLOADED_FOLDER) + File.separator
					+ folder + File.separator + id + File.separator + "profile";
			log.info("This is path {}", destDir);

			// innitalize file
			File dir = new File(destDir);
			// if folder does not exist create it
			if (!dir.exists()) {
				new File(destDir).mkdirs();
			}

			MultipartFile multipartFile = (MultipartFile) file;
			String fileName = file.getOriginalFilename(); // set

			String img = orgRepo.findById(id).get().getImage();

			File doc = new File(destDir + File.separator + img);
			if (doc.exists()) {
				doc.delete();
			}

			// rename file to md5
			String parseMd5 = md5(fileName.toLowerCase());
			File destination = new File(destDir + File.separator + parseMd5);
			// save to file system and db
			multipartFile.transferTo(destination);
			orgRepo.findById(id).ifPresent(a -> {
				a.setImage(parseMd5);

			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String md5(String filename) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	    String hash = DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(filename.getBytes("UTF-8")));
		return hash;
   }

}
