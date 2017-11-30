package ru.kotovalexandrfrombutovo.destrictpassenger.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerException;
import org.springframework.context.annotation.Import;
import ru.kotovalexandrfrombutovo.destrictpassenger.server.utils.JpaConfiguration;

/**
 * Created by alexkotov on 29.11.17.
 */
@SpringBootApplication
@Import(JpaConfiguration.class)
public class ServerConfiguration implements EmbeddedServletContainer {

    public static void main(String[] args) {
        SpringApplication.run(ServerConfiguration.class, args);
    }

    @Override
    public void start() throws EmbeddedServletContainerException {

    }

    @Override
    public void stop() throws EmbeddedServletContainerException {

    }

    @Override
    public int getPort() {
        return 0;
    }
}
