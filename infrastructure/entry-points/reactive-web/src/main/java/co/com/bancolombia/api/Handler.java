package co.com.bancolombia.api;

import co.com.bancolombia.usecase.PeqUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    @Autowired
private final PeqUseCase peqUseCase;
public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {


    Flux<String> response=peqUseCase.consumer();

    return ServerResponse.ok().bodyValue(response.toString());
}
}
