package co.com.bancolombia.adapter;

import co.com.bancolombia.integracion.config.ConfigProperties;
import co.com.bancolombia.integracion.models.Parameters;
import co.com.bancolombia.integracion.models.ents.componente.tecnico.homologacion.criterioparametrizacion.v1.CriterioParametrizacion;
import co.com.bancolombia.integracion.models.ents.componente.tecnico.homologacion.encabezadohomologacion.v1.EncabezadoHomologacion;
import co.com.bancolombia.integracion.models.ents.componente.tecnico.homologacion.resultadoparametrizacion.v1.ResultadoParametrizacion;
import co.com.bancolombia.integracion.service.EquivalenceAsync;
import co.com.bancolombia.model.peq.gateways.PeqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PeqService implements PeqRepository {

     private final EquivalenceAsync equivalenceAsync;


    @Override
    public void consumer() {
        ArrayList<CriterioParametrizacion> dataList = new ArrayList<CriterioParametrizacion>();

        dataList.add(new CriterioParametrizacion("ADRTP", "1"));
        dataList.add(new CriterioParametrizacion("CONTROL TERCEROS", "K"));


        Flux<ResultadoParametrizacion> response= equivalenceAsync.get(Parameters.builder()
                .header(EncabezadoHomologacion.builder()
                        .aplicacionOrigen("CIF")
                        .aplicacionDestino("CRM-VENTAS")
                        .sociedadOrigen("1000")
                        .sociedadDestino("1000")
                        .build())
                .criteria(dataList)
                .consumerId("CAPA-TRX")
                .messageId("dd64877b-3f11-48cf-abe1-0fc2f789f52a")
                .build());

      //  Mono<ResultadoParametrizacion> mono = Mono.from(response);

        response.map(resp->resp.toString())
                .subscribe(System.out::println);

    }

}
