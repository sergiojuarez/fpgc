package gob.mx.salud.fpgc.model.mapper;


import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import gob.mx.salud.fpgc.model.DiagnosticoDTO;
import gob.mx.salud.fpgc.model.ExpedienteDTO;
import gob.mx.salud.fpgc.model.request.RequestDiagnostico;
import gob.mx.salud.fpgc.model.request.RequestExpediente;


@Configuration
public class MappingConfig {


    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath*:mappings/*.xml") Resource[] resources) throws Exception {
        final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        // Other configurations
        dozerBeanMapperFactoryBean.setMappingFiles(resources);
        return dozerBeanMapperFactoryBean;
    }

	//@Bean
//	public BeanMappingBuilder expedienteMappingBuilder() {
//	    return new BeanMappingBuilder() {
//	        @Override
//	        protected void configure() {
//
//	        	mapping(RequestExpediente.class, ExpedienteDTO.class)
//		        	.fields("fl_expediente", "flExpediente")
//		        	.fields("fl_poliza", "flPoliza")
//		        	.fields("fl_patologia", "flPatologia")
//		        	.fields("fl_subgrupo_diagnostico", "flSubgrupoDiagnostico")
//		        	.fields("fl_subdiagnostico", "flSubDiagnostico")
//		        	.fields("fl_genotipo", "flGenotipo")
//		        	.fields("fl_clasificacion_ana", "flClasificacionAna")
//		        	.fields("fl_cie", "flCie")
//		        	.fields("fl_clasificacion_morfologica", "flClasificacionMorfologica")
//		        	.fields("fe_captacion", "feCaptacion")
//		        	.fields("ds_comentarios", "dsComentarios")
//		        	.fields("ds_primera_valoracion", "dsPrimeraValoracion")
//		        	.fields("ds_primera_atencion", "dsPrimeraAtencion")
//		        	.fields("atributo1", "atributo1")
//		        	.fields("atributo2", "atributo2")
//		        	.fields("atributo3", "atributo3")
//		        	.fields("atributo4", "atributo4")
//		        	.fields("atributo5", "atributo5")
//		        	.fields("atributo6", "atributo6")
//		        	.fields("atributo7", "atributo7")
//		        	.fields("atributo8", "atributo8")
//		        	.fields("atributo9", "atributo9")
//		        	.fields("atributo10", "atributo10");
//
//	        	mapping(RequestDiagnostico.class, DiagnosticoDTO.class)
//		        	.fields("fl_diagnostico", "flDiagnostico")
//		        	.fields("fl_expediente", "flExpediente")
//		        	.fields("fl_etapa", "flEtapa")
//		        	.fields("fe_diagnostico", "feDiagnostico")
//		        	.fields("ds_doc_diagnostico", "dsDocDiagnostico")
//		        	.fields("atributo1", "atributo1")
//		        	.fields("atributo2", "atributo2")
//		        	.fields("atributo3", "atributo3")
//		        	.fields("atributo4", "atributo4")
//		        	.fields("atributo5", "atributo5")
//		        	.fields("atributo6", "atributo6")
//		        	.fields("atributo7", "atributo7")
//		        	.fields("atributo8", "atributo8")
//		        	.fields("atributo9", "atributo9")
//		        	.fields("atributo10", "atributo10");
//
//	        }
//	    };
//	}


}