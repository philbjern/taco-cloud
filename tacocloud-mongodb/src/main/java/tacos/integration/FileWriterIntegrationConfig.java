package tacos.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;

import java.io.File;

@Configuration
public class FileWriterIntegrationConfig {

    // Java config

//    @Bean
//    @Transformer(inputChannel = "textInChannel", outputChannel = "fileWriterChannel")
//    public GenericTransformer<String, String> upperCaseTransformer() {
//        return text -> text.toUpperCase();
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "fileWriterChannel")
//    public FileWritingMessageHandler fileWriter() {
//        FileWritingMessageHandler handler =
//                new FileWritingMessageHandler(new File("C:\\Users\\filip\\dev\\taco-cloud\\tmp\\sia6\\files"));
//        handler.setExpectReply(false);
//        handler.setFileExistsMode(FileExistsMode.APPEND);
//        handler.setAppendNewLine(true);
//        return handler;
//    }


    // Java with Spring Integration DSL (domain specific language)

    @Bean
    public IntegrationFlow fileWriterFlow() {
        return IntegrationFlows
                .from(MessageChannels.direct("textInChannel"))
                .<String, String>transform(t -> t.toUpperCase())
                .channel(MessageChannels.direct("FileWriterChannel"))
                .handle(Files
                        .outboundAdapter(new File("C:\\Users\\filip\\dev\\taco-cloud\\tmp\\sia6\\files"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .appendNewLine(true))
                .get();
    }

}
