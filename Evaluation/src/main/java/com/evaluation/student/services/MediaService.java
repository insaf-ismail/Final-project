package com.evaluation.student.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.student.entities.Media;
import com.evaluation.student.repositories.MediaRepository;

@Service
public class MediaService {
	
	@Autowired
	MediaRepository mediaRepository;
	
	
	public void addMedia(Media media) {
		mediaRepository.save(media);
	}
	
	public Media getMediaById(Long id) {
		return mediaRepository.getByIdLivre(id);
	}

}
