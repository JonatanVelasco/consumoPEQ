package co.com.bancolombia.adapter;

import co.com.bancolombia.integracion.models.Parameters;
import co.com.bancolombia.integracion.models.ents.componente.tecnico.homologacion.criterioparametrizacion.v1.CriterioParametrizacion;
import co.com.bancolombia.integracion.models.ents.componente.tecnico.homologacion.encabezadohomologacion.v1.EncabezadoHomologacion;
import co.com.bancolombia.integracion.models.ents.componente.tecnico.homologacion.resultadoparametrizacion.v1.ResultadoParametrizacion;
import co.com.bancolombia.integracion.service.EquivalenceAsync;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class PeqService{

     private final EquivalenceAsync equivalenceAsync;

    public Flux<ResultadoParametrizacion> consumer() {
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

        return response;
    }

}
