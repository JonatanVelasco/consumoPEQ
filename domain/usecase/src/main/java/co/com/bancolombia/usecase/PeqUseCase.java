package co.com.bancolombia.usecase;

import co.com.bancolombia.model.peq.gateways.PeqRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class PeqUseCase {

    private final PeqRepository peqRepository;

    public Flux<String> consumer(){
        return peqRepository.consumer();
    }
}
