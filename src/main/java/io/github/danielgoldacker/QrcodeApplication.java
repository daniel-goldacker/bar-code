package io.github.danielgoldacker;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
info = @Info(
        title="API Generated Bar Code",
        version = "1.0",
        contact = @Contact(
            name = "Daniel Goldacker",
            url = "https://www.linkedin.com/in/daniel-goldacker/",
            email = "daniel-goldacker@hotmail.com"),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class QrcodeApplication extends Application {
    
}
