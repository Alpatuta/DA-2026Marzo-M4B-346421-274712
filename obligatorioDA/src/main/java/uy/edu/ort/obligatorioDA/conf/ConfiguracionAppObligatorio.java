package uy.edu.ort.obligatorioDA.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uy.edu.ort.obligatorioDA.servicios.Fachada.Fachada;

@Configuration
public class ConfiguracionAppObligatorio {

    @Bean
    public Fachada fachada() {
        return Fachada.getInstancia();
    }
}