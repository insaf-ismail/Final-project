package com.evaluation.student.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.evaluation.student.entities.Livre;
import com.evaluation.student.entities.Media;
import com.evaluation.student.request.AddLivreRequest;
import com.evaluation.student.services.AppUserService;
import com.evaluation.student.services.LivreService;
import com.evaluation.student.services.MediaService;

@RestController
@RequestMapping("/Rest/Api/livre")
public class LivreController {
	
	@Autowired
	AppUserService appUserService;
	
	@Autowired
	LivreService livreService;
	
	@Autowired
	MediaService mediaService;
	
	
	@CrossOrigin(origins = "*" ) 
	@RequestMapping(method = RequestMethod.POST, value = "/addLivre")
	public Livre addLivre(@RequestBody AddLivreRequest addLivreRequest){
		Livre livre = new Livre();
		livre.setAuteur(addLivreRequest.getAuteur());
		livre.setDescription(addLivreRequest.getDescription());
		livre.setNom(addLivreRequest.getNom());
		return livreService.addLivre(livre);
	}
	
	@CrossOrigin(origins = "*" ) 
	@RequestMapping(method = RequestMethod.GET, value = "/getAll")
	public List<Livre> getAllLivre(){
	
		return livreService.getAllLivre();
	}
	
	
	@CrossOrigin(origins = "*" ) 
	@GetMapping(path = "/deleteLivre/{id}")
	public List<Livre> deleteLivre(@PathVariable("id") Long id){
	
		livreService.deleteLivre(id);
		return livreService.getAllLivre();
	}

	@CrossOrigin(origins = "*" )
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void uploadOneFileHandlerPOST(HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws IOException {
		String id = request.getHeader("id");
		System.out.println("id     : **** : "+id);
		String name = file.getOriginalFilename();
		File serverFile = new File("C:\\Users\\rahal\\Desktop\\version final\\livre"+File.separator+name);

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(file.getBytes());
		stream.close();
		
		Media media = new Media();
		media.setName(name);
		media.setIdLivre(Long.valueOf(id));
		media.setPath("C:\\Users\\rahal\\Desktop\\version final\\livre");
		mediaService.addMedia(media);

	}
	
	@CrossOrigin(origins = "*" )
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	public void downloadFile(@PathVariable("id") Long id, 
			HttpServletResponse response, HttpServletRequest req) throws IOException {
		
		Media media = mediaService.getMediaById(id);
		if (media != null) {
			String file_path = media.getPath()+File.separator+media.getName();

			File file = new File(file_path);
			if (!file.exists()) {
				String errorMessage = "The file does not exist";
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				outputStream.close();
				return;
			}
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);

			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());
		
		}else {
			String errorMessage = "The file does not exist";
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
	}
}
