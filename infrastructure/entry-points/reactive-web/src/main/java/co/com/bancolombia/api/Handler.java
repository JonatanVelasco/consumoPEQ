package co.com.bancolombia.api;

import co.com.bancolombia.adapter.PeqService;
import co.com.bancolombia.integracion.models.ents.componente.tecnico.homologacion.resultadoparametrizacion.v1.ResultadoParametrizacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

private final PeqService peqService;

public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {

    return ServerResponse.ok().body(peqService.consumer(),ResultadoParametrizacion.class);

}
}
