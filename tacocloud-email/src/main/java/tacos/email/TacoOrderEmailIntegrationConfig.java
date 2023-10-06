package tacos.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.mail.dsl.Mail;

@Configuration
public class TacoOrderEmailIntegrationConfig {

    private final Logger log = LoggerFactory.getLogger(TacoOrderEmailIntegrationConfig.class);

    @Bean
    public IntegrationFlow tacoOrderEmailFlow(EmailProperties emailProps,
                                              EmailToOrderTransformer emailToOrderTransformer,
                                              OrderSubmitMessageHandler orderSubmitHandler) {

        log.info("IMAP url from properties: {}", emailProps.getImapUrl());

        return IntegrationFlows
                .from(Mail.imapInboundAdapter(emailProps.getImapUrl()),
                        e -> e.poller(Pollers.fixedDelay(emailProps.getPollRate())))
                .transform(emailToOrderTransformer)
                .handle(orderSubmitHandler)
                .get();
    }

}
