package com.mypack.rest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.mypack.exception.MyException;


//Sample file has been placed in resources/testApi.html
@Path("/file")
public class FileUpload {
	@POST
	@Path("/upload")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadPdfFile(
			@FormDataParam("file") InputStream fileInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileMetaData,
	        @FormParam("user_id") int userId) throws MyException {
		
		String uploadPath = "c://temp/";
		File file = new File(uploadPath + fileMetaData.getFileName());
		file.getAbsolutePath();
		
	    try (OutputStream out = new FileOutputStream(file)){
	        int read = 0;
	        byte[] bytes = new byte[1024];
	        while ((read = fileInputStream.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	        throw new MyException(200, "Error while uploading file. Please try again", e);
	    }
	    
	    return Response.ok("File successfully uploaded").build();
		
	}
}
