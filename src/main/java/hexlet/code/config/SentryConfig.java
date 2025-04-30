package hexlet.code.config;

import io.sentry.Sentry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SentryConfig {

    @Bean
    public void configureSentry() {
        String sentryAuthToken = System.getenv("SENTRY_AUTH_TOKEN");
        if (sentryAuthToken != null && !sentryAuthToken.isEmpty()) {
            Sentry.init(options -> {
                options.setDsn("https://0dae560a3a969a7b4dd2d5b8a5332851@"
                        + "o4509207537647616.ingest.de.sentry.io/4509207545053264");

            });
        } else {
            System.out.println("Sentry is not active: SENTRY_AUTH_TOKEN is not set or is empty");
        }
    }
}
