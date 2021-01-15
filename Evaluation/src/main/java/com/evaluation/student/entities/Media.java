package com.evaluation.student.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "media")
public class Media {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mediaSeq") 
    @SequenceGenerator(name="mediaSeq",sequenceName="MEDIA_ID",allocationSize =1) 
	@Column(name="media_id")
	private long mediaId;
	
	private String name;
	private Long idLivre;
	private String path;

	public Media() {
		super();
	}

	public long getMediaId() {
		return mediaId;
	}

	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	

}
