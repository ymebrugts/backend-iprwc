package nl.iprwc.resources;

import io.dropwizard.auth.Auth;
import nl.iprwc.auth.AuthChecker;
import nl.iprwc.model.Account;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.Optional;

@Path("/imageupload")
public class ImageUploadResource {

    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces({MediaType.TEXT_PLAIN})
    public boolean uploadFile(@Auth Optional<Account> account,
                              @FormDataParam("file") InputStream uploadedInputStream,
                              @FormDataParam("filename") String fileName) {
        // TODO: fileUploadLocation should come from config.yml
        if (!AuthChecker.goodAdmin(account) || !fileName.endsWith(".png")) {
            return false;
        }
        String fileUploadLocation = "/var/www/html/.product_images/" + fileName;
        return writeToFile(uploadedInputStream, fileUploadLocation);
    }

    private boolean writeToFile(InputStream uploadedInputStream, String fileUploadLocation) {
        int read;
        final int BUFFER_LENGTH = 1024;
        final byte[] buffer = new byte[BUFFER_LENGTH];
        try {
            OutputStream out = new FileOutputStream(new File(fileUploadLocation));
            while ((read = uploadedInputStream.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}

