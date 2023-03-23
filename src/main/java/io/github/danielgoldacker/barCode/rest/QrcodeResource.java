package io.github.danielgoldacker.barCode.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.zxing.WriterException;

import io.github.danielgoldacker.barCode.repository.QrcodeRepository;
import io.github.danielgoldacker.barCode.rest.dto.QrcodeRequest;
import io.github.danielgoldacker.barCode.rest.dto.ResponseError;


@Path("/bar-code")
public class QrcodeResource {
    private QrcodeRepository qrcodeRepository;
    private Validator validator; 

    @Inject
    public QrcodeResource(QrcodeRepository qrcodeRepository, Validator validator){
        this.qrcodeRepository = qrcodeRepository;
        this.validator = validator;
    }

    @POST
    @Path("/qrcode/generate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Generate(QrcodeRequest qrcodeRequest) throws WriterException, IOException {
        Set<ConstraintViolation<QrcodeRequest>> violations = validator.validate(qrcodeRequest);
        if (!violations.isEmpty()){
            return ResponseError.createFromValidation(violations).withStatusCode(ResponseError.UNPROCESSABLE_ENTITY_STATUS);
        }
        
        BufferedImage image = qrcodeRepository.generate(qrcodeRequest.getText(), qrcodeRequest.getWidth(), qrcodeRequest.getHeight());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
    
        byte[] imageData = baos.toByteArray();

        return Response.ok(new ByteArrayInputStream(imageData))  
                       .header("Content-Type", "image/png")
                       .build();
    }
}