package controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import model.dao.PictureDAO;

@Named
@ViewScoped
public class PictureMB {
		private UploadedFile uploadedFile;
		private PictureDAO dao = new PictureDAO();
				
		public UploadedFile getUploadedFile() {
			return uploadedFile;
		}
		public void setUploadedFile(UploadedFile uploadedFile) {
			this.uploadedFile = uploadedFile;
		}
		public PictureDAO getDao() {
			return dao;
		}
		public void setDao(PictureDAO dao) {
			this.dao = dao;
		}




}
